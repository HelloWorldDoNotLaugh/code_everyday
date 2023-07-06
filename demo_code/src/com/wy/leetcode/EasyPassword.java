package com.wy.leetcode;

import java.util.Scanner;

/**
 * HJ21 简单密码
 * @author HelloWorld
 * @create 2022/4/18 21:31
 * @email helloworld.dng@gmail.com
 */
public class EasyPassword {
    /** 秘文 */
    private final static String PRIVATEKEY = "abcdefghijklmnopqrstuvwxyz";
    /** 明文 */
    private final static String PUBLICKEY  = "22233344455566677778889999";

    /** 大写字母规则 */
    private final static String UPPER_LETTER_RULE = "[A-Z]";
    /** 小写字母规则 */
    private final static String LOWER_LETTER_RULE = "[a-z]";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.next();
            String result = "";
            for (int i = 0; i < string.length(); i++) {
                result += getPublicKey(string.charAt(i) + "");
            }

            System.out.println(result);
        }
    }

    /**
     * @description 加密，将秘文转为明文
     * @author HelloWorld
     * @create 2022/4/18 22:13
     * @param str
     * @return java.lang.String
     */
    private static String getPublicKey(String str) {
        // 大写字母则变成小写之后往后移一位 Z 往后移是 a
        if (str.matches(UPPER_LETTER_RULE)) {
            switch (str) {
                case "Z":
                    return "a";
                default:
                    return (char)(str.toLowerCase().toCharArray()[0] + 1 ) + "";
            }
        }
        // 小写字母都变成九键键盘对应的数字
        if (str.matches(LOWER_LETTER_RULE)) {
            return PUBLICKEY.charAt(PRIVATEKEY.indexOf(str)) + "";
        }
        // 数字和其他字符
        return str;
    }

}
