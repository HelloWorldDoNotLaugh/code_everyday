package com.wy.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author HelloWorld
 * @date 2023/9/1 17:13
 * @email helloworld.dng@gmail.com
 */

public class ExtractChineseTextFromLogInfo {

    public static void main(String[] args) {
        String logInfo = "           (\"任务停止失败1221\" + entda + \" 多少啊\", e);\n";
        String logInfo1 = "log.error(\"任务停止失败1221\", e);\n";
        String logInfo2 = "           log.error(\"任务停止失败1221\" + entda + \" 多少啊\", e);\n";

        List<String> chineseList1 = filterChineseText(logInfo);
        List<String> chineseList2 = filterChineseText(logInfo1);
        List<String> chineseList3 = filterChineseText(logInfo2);

        System.out.println("logInfo 匹配的中文字符列表: " + chineseList1);
        System.out.println("logInfo1 匹配的中文字符列表: " + chineseList2);
        System.out.println("logInfo2 匹配的中文字符列表: " + chineseList3);
    }

    public static List<String> filterChineseText(String inputText) {
        List<String> chineseList = new ArrayList<>();

        String regex = "log.*?\"([^\"]*[\u4e00-\u9fa5]+[^\"]*)\"";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputText);

        while (matcher.find()) {
            String chineseText = matcher.group(1);
            chineseList.add(chineseText);
        }

        return chineseList;
    }
}
