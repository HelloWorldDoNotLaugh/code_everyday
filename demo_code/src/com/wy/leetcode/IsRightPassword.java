package com.wy.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author HelloWorld
 * @create 2022/4/16 22:02
 * @email helloworld.dng@gmail.com
 */
public class IsRightPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.next();
            System.out.println(isRight(string));
        }
    }

    /**
     * @description 判断密码是否正确
     * @author HelloWorld
     * @create 2022/4/16 22:06
     * @param password
     * @return java.lang.String
     */
    private static String isRight(String password) {

        /*
            长度超过8位校验
         */
        if (password.length() <= 8) {
            return "NG";
        }


        /*
            判定 包括大小写字母.数字.其它符号,以上四种至少三种
            通过map中包含key的个数判定
         */
        HashMap<String, Integer> map = new HashMap<String, Integer>();


        for (int i = 0; i < password.length(); i++) {
            String s = password.charAt(i) + "";
            checkLetter(map, s);
            /*
                不能有长度大于2的不含公共元素的子串重复
             */
            if (i < password.length() - 3 && hasSameSubstring(password.substring(i, i+3), password.substring(i+3))) {
                return "NG";
            }
        }

        /*
            包括大小写字母.数字.其它符号,以上四种至少三种 校验
         */
        if (map.keySet().size() < 3) {
            return "NG";
        }

        return "OK";
    }

    /**
     * @description 判定是否包含 大写字母， 小写字母， 数字 或其他字符
     * @author HelloWorld
     * @create 2022/4/17 08:25
     * @param map
     * @param letter
     * @return void
     */
    private static void checkLetter(Map<String, Integer> map, String letter) {
        String upperLetterRule = "[A-Z]";
        String lowerLetterRule = "[a-z]";
        String numRule = "\\d";
        String otherLetterRule = "[^A-Za-z0-9_]";
        if (!map.containsKey("UPPER") && letter.matches(upperLetterRule)) {
            map.put("UPPER", 1);
        }

        if (!map.containsKey("LOWER") && letter.matches(lowerLetterRule)) {
            map.put("LOWER", 1);
        }

        if (!map.containsKey("NUM") && letter.matches(numRule)) {
            map.put("NUM", 1);
        }

        if (!map.containsKey("OTHER") && letter.matches(otherLetterRule)) {
            map.put("OTHER", 1);
        }
    }

    /**
     * @description 是否含有连续3个相同字符的子串
     * @author HelloWorld
     * @create 2022/4/17 09:03
     * @param substring
     * @param string
     * @return boolean
     */
    private static boolean hasSameSubstring(String substring, String string) {
        for (int i = 0; i < string.length() - 3; i++) {
            if (substring.equals(string.substring(i, i+3))) {
                return true;
            }
        }
        return false;
    }
}
