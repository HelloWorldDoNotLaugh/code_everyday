package com.wy.leetcode;

import java.util.Scanner;

/**
 * @author HelloWorld
 * @create 2022/7/1 22:32
 * @email helloworld.dng@gmail.com
 */
public class ReverseWord {

    /* HJ21 单词倒排 */

    private static final String WORD_NULL_MATCH_RULE = "[a-zA-Z\\s]";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();

        System.out.println(doReverseWord(inputStr));
    }

    /**
     * @description 实现单词倒排
     * @author HelloWorld
     * @create 2022/7/1 23:08
     * @param str
     * @return java.lang.String
     */
    public static String doReverseWord(String str) {
        // 第一步： 处理特殊字符
        str = dealSpecChar(str);

        // 第二步: 将字符串数组按单词倒序
        str = reverseStr(str);

        return str;

    }

    /**
     * @description 将传入的字符串按照空格分隔后倒序
     * @author HelloWorld
     * @create 2022/7/1 23:09
     * @param str
     * @return java.lang.String
     */
    private static String reverseStr(String str) {
        String[] strings = str.split(" ");
        String result = "";
        for (int i = strings.length - 1; i > 0; i--) {
            result += strings[i] + " ";
        }
        return result + strings[0];
    }

    /**
     * @description 处理特殊字符
     * @author HelloWorld
     * @create 2022/7/1 22:39
     * @param str 待处理字符串
     * @return java.lang.String
     */
    private static String dealSpecChar(String str) {
        String result = "";
        for (int i = 0; i < str.toCharArray().length; i++) {
            char c = str.toCharArray()[i];
            if ((c + "").matches(WORD_NULL_MATCH_RULE)) {
                result += c;
            }else {
                result += " ";
            }
        }
        return result;
    }
}
