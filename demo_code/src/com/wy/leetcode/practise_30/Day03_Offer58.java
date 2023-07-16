package com.wy.leetcode.practise_30;

/**
 * @author HelloWorld
 * @date 2023/7/16 14:29
 * @email helloworld.dng@gmail.com
 */
public class Day03_Offer58 {

    /*
        eg s = abcdefg; n = 3
        现前n个返转：cbadefg
        再将剩余部分翻转：cbagfed
        再全部翻转：defgabc
     */
    public String reverseLeftWords(String s, int n) {
        n = n % s.length();
        String resultPart1 = reverseString(s.substring(0, n));
        String resultPart2 = reverseString(s.substring(n));

        return reverseString(resultPart1+resultPart2);
    }

    private String reverseString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            stringBuilder.insert(0, c);
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Day03_Offer58 day03Offer58 = new Day03_Offer58();
        System.out.println(day03Offer58.reverseLeftWords("abcdefg", 9));
    }
}
