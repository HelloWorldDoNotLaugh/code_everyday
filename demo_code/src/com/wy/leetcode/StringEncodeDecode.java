package com.wy.leetcode;

import java.util.Scanner;

/**
 * @author HelloWorld
 * @create 2022/6/25 11:04
 * @email helloworld.dng@gmail.com
 */
public class StringEncodeDecode {
    /*  输入两行数据，第一行是待加密数据，第二行是待解秘数据
     *  加密： 数字 -> 0~8, 加 1， 9 变 0
     *        字母 -> 码值 加 1，转变大小写， Z 变 a， z 变 A
     *  解密： 数字 -> 1~9 减 1， 0 变 9
     *        字母 -> 码值 减 1，转变大小写， a 变 Z， Z 变 a
     */


    /** 数字规则  */
    private static final String NUMBER_RULE = "[\\d]";
    /** 大写字母规则 */
    private static final String UPPERCASE_RULE = "[A-Z]";
    /** 小写字母规则 */
    private static final String LOWERCASE_RULE = "[a-z]";
    /** 数字字母规则 */
    private static final String CHAR_RULE = "[\\dA-Za-z]+";

    private static final String nine = "9";
    private static final String zero = "0";
    private static final String z = "z";
    private static final String Z = "Z";
    private static final String a = "a";
    private static final String A = "A";

    /** 异常输入返回值 */
    private static final String ERROR = "ERROR";

    /** 异常退出程序码值 */
    private static final int ERROR_STATE = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 接收输入的要加密字符串
        String encodeStr = scanner.next();
        // 检查输入是否符合规则
        check(encodeStr);
        // 加密后的结果
        String encodeResult = "";
        for (int i = 0; i < encodeStr.toCharArray().length; i++) {
            String encode = encode(encodeStr.toCharArray()[i]);
            encodeResult += encode;
        }

        // 接收输入的要解密字符串
        String decodeStr = scanner.next();
        // 检查输入是否符合规则
        check(decodeStr);
        // 解密后的结果
        String decodeResult = "";
        for (int i = 0; i < decodeStr.toCharArray().length; i++) {
            String decode = decode(decodeStr.toCharArray()[i]);
            decodeResult += decode;
        }

        System.out.println(encodeResult);
        System.out.println(decodeResult);

    }

    /**
     * @description 加密
     * @author HelloWorld
     * @create 2022/6/26 09:56
     * @param
     * @return java.lang.String
     */
    private static String encode(char ch){
        String str = ch + "";
        switch (str){
            case nine:
                return zero;
            case z:
                return A;
            case Z:
                return a;
        }

        /* 处理0 ～ 8 */
        if (str.matches(NUMBER_RULE)) {
            return (char)(ch + 1) + "";
        }

        /* 处理a ～ y */
        if (str.matches(LOWERCASE_RULE)) {
            return ((char)(ch + 1) + "").toUpperCase();
        }

        /* 处理 A ~ Y */
        if (str.matches(UPPERCASE_RULE)) {
            return ((char)(ch + 1) + "").toLowerCase();
        }

        return ERROR;
    }

    /**
     * @description 解密
     * @author HelloWorld
     * @create 2022/6/26 09:56
     * @param
     * @return java.lang.String
     */
    private static String decode(char ch){
        String str = ch + "";
        switch (str){
            case zero:
                return nine;
            case A:
                return z;
            case a:
                return Z;
        }

        /* 处理1 ～ 9 */
        if (str.matches(NUMBER_RULE)) {
            return (char)(ch - 1) + "";
        }

        /* 处理 b ～ y */
        if (str.matches(LOWERCASE_RULE)) {
            return ((char)(ch - 1) + "").toUpperCase();
        }

        /* 处理 B ~ Y */
        if (str.matches(UPPERCASE_RULE)) {
            return ((char)(ch - 1) + "").toLowerCase();
        }

        return ERROR;
    }

    /**
     * @description 处理异常输入
     * @author HelloWorld
     * @create 2022/6/26 10:35
     * @param str
     * @return void
     */
    private static void check(String str) {
        if (!str.matches(CHAR_RULE)) {
            System.out.println("输入异常！！！");
            System.exit(ERROR_STATE);
        }
    }

}
