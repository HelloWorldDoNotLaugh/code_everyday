package com.wy.global.handler;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.text.CharSequenceUtil;
import com.wy.global.config.GlobalizeConfig;
import com.wy.global.util.YouDaoTranslateUtil;
import com.wy.mycode.ExcelUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author HelloWorld
 * @date 2023/9/1 20:38
 * @email helloworld.dng@gmail.com
 */
public class GlobalizeHandler {
    private static Pattern englishPattern = Pattern.compile("[^\\s\\p{IsLetter}\\p{IsDigit}]+");

    private static final String CONFIG_FILE_PATH = "/Users/td/code/project/code_everyday/demo_code/src/com/wy/global/config/auto_globalize_config.yml";

    private static GlobalizeConfig globalizeConfig = initGlobalConfig();

    private static final String CODE_TYPE_UTF8 = "UTF-8";

    private static List<String> MESSAGES_LIST;
    private static List<String> MESSAGES_CN_LIST;
    private static List<String> MESSAGES_EN_LIST;
    private static List<String> LOCALE_MESSAGE_ENUM_LIST;

    public static Pattern chinesePattern = Pattern.compile("[\\u4e00-\\u9fa5]");

    /** 结尾丢失”的字符串*/
    private static Pattern endPattern = Pattern.compile(".*\"[^\"]*\\)");

    private static Integer APPEND_LINES;

    private static boolean shouldGlobalizeFlag = false;

    static {
        try {
            init();
            APPEND_LINES = getAppendLines();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static int getAppendLines() {
        int result = 0;
        for (int i = 0; i < LOCALE_MESSAGE_ENUM_LIST.size(); i++) {
            if (LOCALE_MESSAGE_ENUM_LIST.get(i).trim().startsWith("public enum LocaleMessageEnum")) {
                result = i + 1;
            }
        }
        return result;
    }

    private static void init() {
        MESSAGES_LIST = FileUtil.readLines(globalizeConfig.getMessagesPath(),  CODE_TYPE_UTF8);
        MESSAGES_CN_LIST = FileUtil.readLines(globalizeConfig.getMessagesCnPath(), CODE_TYPE_UTF8);
        MESSAGES_EN_LIST = FileUtil.readLines(globalizeConfig.getMessagesEnPath(), CODE_TYPE_UTF8);
        LOCALE_MESSAGE_ENUM_LIST = FileUtil.readLines(globalizeConfig.getLocaleMessageEnumPath(), CODE_TYPE_UTF8);
    }

    public static String handler(String info) throws Exception{
        String firstWord = info.trim().split(" ")[0].split("\\.")[0];
        if (!globalizeConfig.getShouldGlobalFactorList().contains(firstWord)) {
            return info;
        }

        boolean onlyTranslateFlag = firstWord.substring(0, 3).equalsIgnoreCase("log");

        return globalizeHandler(info, onlyTranslateFlag);
    }


    /**
     * @description
     * @author HelloWorld
     * @create 2023/9/3 05:56
     * @param info
     * @return java.lang.String
     *
     * log：
     *     全中文：log.info("窗前明月光");
     *     中文加变量：log.info("窗前" + code + "明月光")
     *               log.info("窗前{}明月{}光", code1, code2)
     *               log.info(String.format("窗前%s明月光", code))
     */
    private static String globalizeHandler(String info, boolean onlyTranslateFlag) throws Exception{
        List<String> chineseInfoList = getChineseInfoList(info);

        shouldGlobalizeFlag = shouldGlobalizeFlag ? true : CollUtil.isNotEmpty(chineseInfoList);

        for (String chineseInfo : chineseInfoList) {
            String globalizeInfo = getGlobalizeInfo(chineseInfo, onlyTranslateFlag);
            if (CharSequenceUtil.isBlank(globalizeInfo)) {
                globalizeInfo = globalize(chineseInfo, onlyTranslateFlag);
            }

            if (!onlyTranslateFlag) {
                info = formatInfo(info, chineseInfo, globalizeInfo);
            } else {
                info = info.replace(chineseInfo, globalizeInfo);
            }
        }

        return info;
    }

    private static List<String> getChineseInfoList(String info) {
        List<String> chineseInfoList = new ArrayList<>();
        int right = 0;
        while (right < info.length()) {
            while (right < info.length() && info.charAt(right) != '"') {
                right++;
            }
            right++;
            int left = right;
            boolean hasChinese = false;
            while (right < info.length() && info.charAt(right) != '"') {
                if (hasChinese || chinesePattern.matcher(String.valueOf(info.charAt(right))).matches()) {
                    hasChinese = true;
                }
                right++;
            }

            if (hasChinese) {
                chineseInfoList.add(info.substring(left, right));
            }
            right++;
        }
        return chineseInfoList;
    }

    private static String formatInfo(String line, String chineseInfo, String globalizeInfo) {
        line = line.replace(chineseInfo, globalizeInfo);

        int i = line.indexOf(globalizeInfo);
        if (line.charAt(i-1) == '"') {
            line = line.substring(0, i-1) + line.substring(i);
        }

        i = line.indexOf(globalizeInfo) + globalizeInfo.length();
        if (line.charAt(i) == '"') {
            if (i+1 <= line.length() - 1) {
                line = line.substring(0, i) + line.substring(i+1);
            } else {
                line = line.substring(0, i);
            }
        }


        return line;
    }

    private static String getGlobalizeInfo(String info, boolean onlyTranslateFlag) {
        for (String s : MESSAGES_LIST) {
            if (s.contains(info)) {
                if (onlyTranslateFlag) {
                    return s.split("=")[0].replace("_", " ");
                }
                return String.format("I18nUtil.getLocaleMessage(LocaleMessageEnum.%s)", s.split("=")[0].toUpperCase());
            }
        }

        return "";
    }


    private static String globalize(String chineseInfo, boolean onlyTransLate) throws NoSuchAlgorithmException {
        String englishInfo = YouDaoTranslateUtil.translateCN2EN(chineseInfo);

        if (onlyTransLate) {
            return englishInfo;
        }

        Matcher matcher = englishPattern.matcher(englishInfo);
        String englishFormatInfo = matcher.replaceAll("");
        englishFormatInfo = englishFormatInfo.replace(" ", "_");
        englishFormatInfo = englishFormatInfo.replace("__", "_");
        if (englishFormatInfo.endsWith("_")) {
            englishFormatInfo = englishFormatInfo.substring(0, englishFormatInfo.length() - 1);
        }
        MESSAGES_LIST.add(String.format("%s=%s", englishFormatInfo, chineseInfo));
        MESSAGES_CN_LIST.add(String.format("%s=%s", englishFormatInfo, chineseInfo));
        MESSAGES_EN_LIST.add(String.format("%s=%s", englishFormatInfo, englishInfo));
        LOCALE_MESSAGE_ENUM_LIST.add(APPEND_LINES, "\t" + englishFormatInfo.toUpperCase() + ",");

        return String.format("I18nUtil.getLocaleMessage(LocaleMessageEnum.%s)", englishFormatInfo.toUpperCase());
    }

    private static GlobalizeConfig initGlobalConfig()  {
        GlobalizeConfig globalizeConfig = new GlobalizeConfig();

        Yaml yaml = new Yaml();
        try (FileInputStream inputStream = new FileInputStream(CONFIG_FILE_PATH)) {
            Object data = yaml.load(inputStream);
            Map<String, Object> stringObjectMap = BeanUtil.beanToMap(data);

            Class<? extends GlobalizeConfig> configClass = globalizeConfig.getClass();
            for (String key : stringObjectMap.keySet()) {
                String methodName = getMethodName(key);
                configClass.getDeclaredMethod(methodName, stringObjectMap.get(key).getClass())
                        .invoke(globalizeConfig, stringObjectMap.get(key));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return globalizeConfig;
    }

    private static String getMethodName(String name) {
        String[] strings = name.split("_");

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            builder.append(string.substring(0, 1).toUpperCase() + string.substring(1));
        }

        return "set" + builder;
    }

    /**
     * @description 将字符串格式转换为统一格式
     * @author HelloWorld
     * @create 2023/9/3 07:41
     * @param
     * @return java.lang.String
     *
     *     全中文：log.info("窗前明月光");
     *     中文加变量：log.info("窗前" + code + "明月光")
     *               log.info("窗前{}明月{}光", code1, code2)
     *               log.info(String.format("窗前%s明月光", code))
     */
    private static String tranCommonInfo(String info) {
        String[] strings = info.split("\",");
        if (strings.length <= 1) {
            return info;
        }

        info = strings[0] + ");";
        String[] params = strings[1].split(",");
        int index = 0;
        while (info.contains("{}") || info.contains("%s")) {
            String replace = params[index++].trim().replace(");", "");
            replace = String.format("\" + %s + \"", replace);
            info = info.replaceFirst("\\{\\}", replace);
            info = info.replaceFirst("%s", replace);
        }

        if (endPattern.matcher(info).matches()) {
            info = info.substring(0, info.length() - 1) + "\");";
        }

        if (info.contains("String.format(")) {
            info = info.replace("String.format(", "");
        }

        return info;
    }

    public static void writeFile(List<String> errorInfoList) {
        FileUtil.writeLines(MESSAGES_LIST, globalizeConfig.getMessagesPath(), CODE_TYPE_UTF8);
        FileUtil.writeLines(MESSAGES_CN_LIST, globalizeConfig.getMessagesCnPath(), CODE_TYPE_UTF8);
        FileUtil.writeLines(MESSAGES_EN_LIST, globalizeConfig.getMessagesEnPath(), CODE_TYPE_UTF8);
        FileUtil.writeLines(LOCALE_MESSAGE_ENUM_LIST, globalizeConfig.getLocaleMessageEnumPath(), CODE_TYPE_UTF8);
        FileUtil.writeLines(errorInfoList, globalizeConfig.getErrorLogPath(), CODE_TYPE_UTF8);
    }


    public static void writeInfoLog(List<List<String>> infoList) throws Exception {
        ExcelUtils.writeExcel(infoList, globalizeConfig.getInfoLogPath());
    }

    public static GlobalizeConfig getGlobalizeConfig() {
        return globalizeConfig;
    }

    public static boolean isShouldGlobalizeFlag() {
        return shouldGlobalizeFlag;
    }

    public static void main(String[] args) throws Exception{
        System.out.println(handler("                        log.error(\"回调 【{}】 任务失败\", item.getName(), e);\n"));
        System.exit(1);
    }
}
