package com.wy.leetcode;

import java.util.Scanner;

/**
 * @author HelloWorld
 * @create 2022/5/8 12:45
 * @email helloworld.dng@gmail.com
 */
public class RegularExpressionRule {
    /** 匹配整数 \d+ */
    private static final String INTEGER_RULE = "\\d+";
    /** 匹配小数 \d+.\d+ */
    private static final String FLOAT_RULE = "\\d+\\.\\d+";

    /** 匹配小数或整数  \d+(.?\d+)       */
    private static final String INT_AND_FLOAT_RULE = "\\d+\\.?\\d+";

    /** 匹配连续两个相同单词  [ ]+(\w+)[ ]+\1  */
    private static final String REPEAT_WORD = "[ ]+(\\w+)[ ]+\\1";

    private static final String RULE = ".*[ ].*";



    private static String intNum = "1234";
    private static String intNum2 = "1";
    private static String intNum3 = "11";

    private static String intNum1 = "1234567";
    private static String floatNum = "0.123";
    private static String floatNum1 = "12.12";
    private static String floatNum2 = "1233.0";
    private static String floatNum3 = "123a001";
    private static String string = "you do do";
    private static String string1 = "do not do";

    public static void main(String[] args) {
        //testIntRule(INTEGER_RULE);
        testIntRule(INT_AND_FLOAT_RULE);
    }

    public static void testIntRule(String rule) {
        System.out.println("1".matches(rule));
        System.out.println("11".matches(rule));
        System.out.println(intNum.matches(rule));
        System.out.println(intNum1.matches(rule));
        System.out.println(floatNum.matches(rule));
        System.out.println(floatNum1.matches(rule));
        System.out.println(floatNum2.matches(rule));
        System.out.println(floatNum3.matches(rule));
        System.out.println(string.matches(rule));
        System.out.println(string1.matches(rule));
        
    }



}
