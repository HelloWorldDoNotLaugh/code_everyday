package com.wy.mycode.algorithm.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author HelloWorld
 * @create 2022/6/25 08:50
 * @email helloworld.dng@gmail.com
 */
public class SwitchStringUtil {

    /**
     * @description 按指定规则替换字符传
     * @author HelloWorld
     * @create 2022/6/25 08:55
     * @param str 待转换的字符串
     * @param rule 转换规则
     * @param target 转换子串
     * @return java.lang.String
     */
    public String switchStringByRule(String str, String rule, String target) {
        Pattern pattern = Pattern.compile(rule);
        Matcher matcher = pattern.matcher(str);
        return matcher.replaceFirst(target);
    }

    public static void main(String[] args) {
        String str = "insert    into     table (item1, item2) values (value1, value2)";

        String str1 = "(dadada,  ocud1)";
        //insert\s*into\s*\w+\s*\((\w+,)*\s*\w+\)\s*values\s*\((\w+,)*\s*\w+\)
        String rule = "insert\\s*into\\s*\\w+\\s*\\((\\w+,)*\\s*\\w+\\)\\s*values\\s*\\((\\w+,)*\\s*\\w+\\)";
        // \((\w+,)*\s*\w+\)
        String rule1 = "\\((\\w+,)*\\s*\\w+\\)";
        System.out.println(str.matches(rule));
        System.out.println(str1.matches(rule1));
    }
}
