package com.wy.mycode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author HelloWorld
 * @date 2023/9/1 20:02
 * @email helloworld.dng@gmail.com
 */
public class Test {
    private static final Pattern RETURN_THROW_PATTERN = Pattern.compile(".*\"[^\"]*\\)");

    public static void main(String[] args) {
        System.out.println(RETURN_THROW_PATTERN.matcher("+ \"光\")").matches());
        System.out.println(tranCommonInfo("log.info(\"窗前明月光 {} {}\", code1, code2)")); // log.info("窗前明月光 " + code1 + " " + code2 + ")
        System.out.println(tranCommonInfo("log.info(\"窗前{}明月{}光\", code1, code2)"));// log.info("窗前" + code1 + "明月" + code2 + "光)
        System.out.println(tranCommonInfo("log.info(\"{}窗前{}明月光\", code1, code2)")); // log.info("" + code1 + "窗前" + code2 + "明月光)
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

        info = strings[0] + ")";
        String[] params = strings[1].split(",");
        int index = 0;
        while (info.contains("{}") || info.contains("%s")) {
            String replace = params[index++].trim().replace(")", "");
            replace = String.format("\" + %s + \"", replace);
            info = info.replaceFirst("\\{\\}", replace);
        }

       if (RETURN_THROW_PATTERN.matcher(info).matches()) {
           info = info.substring(0, info.length() - 1) + "\")";
       }

       return info;
    }
}
