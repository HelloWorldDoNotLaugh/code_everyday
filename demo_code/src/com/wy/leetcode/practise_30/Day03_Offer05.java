package com.wy.leetcode.practise_30;

/**
 * @author HelloWorld
 * @date 2023/7/16 14:22
 * @email helloworld.dng@gmail.com
 */
public class Day03_Offer05 {
    public String replaceSpace(String s) {
        String result = "";
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                result += "%20";
            } else {
                result += c;
            }
        }

        return result;
    }
}
