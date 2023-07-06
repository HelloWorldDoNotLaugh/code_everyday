package com.wy.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author HelloWorld
 * @create 2022/4/23 18:20
 * @email helloworld.dng@gmail.com
 */
public class FindBrotherWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        System.out.println(doFindBrotherWord(string));
    }

    /**
     * @description HJ27 查找兄弟单词
     * @author HelloWorld
     * @create 2022/4/23 18:22
     * @param string
     * @return java.lang.String
     */
    private static String doFindBrotherWord(String string) {
        String[] strings = string.split(" ");
        // 截取目标单词
        String targetWord = strings[strings.length - 2];
        int k = Integer.parseInt(strings[strings.length - 1]);

        ArrayList<String> brotherList = new ArrayList<>();

        for (int i = 1; i < strings.length - 2; i++) {
            if (isBrotherWord(targetWord, strings[i])) {
                brotherList.add(strings[i]);
            }
        }

        // 输出兄弟单词个数
        System.out.println(brotherList.size());

        if (brotherList.isEmpty()) {
            return "";
        }
        // 按字母表顺序输出第k个兄弟单词
        try {
            return brotherList.stream()
                    .sorted()
                    .collect(Collectors.toList())
                    .get(k - 1);
        } catch (IndexOutOfBoundsException e) {
            // 不存在第k个返回空
            return "";
        }

    }

    /**
     * @description 判定两个单词是否是兄弟单词
     * @author HelloWorld
     * @create 2022/4/23 18:53
     * @param targetWord
     * @param compareWord
     * @return boolean
     */
    private static boolean isBrotherWord(String targetWord, String compareWord) {
        /* 相等的不是兄弟单纯 */
        if (targetWord.equals(compareWord)) {
            return false;
        }
        /* 长度不一样的不是兄弟单纯 */
        if (targetWord.length() != compareWord.length()) {
            return false;
        }

        char[] targetCharArray = targetWord.toCharArray();
        char[] compareCharArray = compareWord.toCharArray();

        /*
            先判定所含定字母是否相同
            再利用异或运算：相同为0不同为1 判定两个单词所含的字符是否相同; 但是若 abccc 和 acbbb判定时也会出现相等
            因此可以再计算两个串当ascii码值是否相等；
        * */
        int temp = 0;
        int targetAsciiValue = 0, compareAsciiValue = 0;
        for (int i = 0; i < targetCharArray.length; i++) {
            // 两单词所含字母是否相同
            if (!compareWord.contains(targetCharArray[i] + "")) {
                return false;
            }
            // 异或运算
            temp = temp ^ compareCharArray[i] ^ targetCharArray[i];
            // ASCII码值是否相等
            targetAsciiValue += targetCharArray[i];
            compareAsciiValue += compareCharArray[i];

        }
        // 异或结果为0 并且ascii码值相同 则为兄弟单词
        return temp == 0 && compareAsciiValue == targetAsciiValue ? true : false;
    }
}
