package com.wy.leetcode.practise_30;

import cn.hutool.core.text.StrBuilder;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/7/28
 */
public class Day13 {

    /**
     * @description 剑指 Offer 58 - I. 翻转单词顺序
     * @author yuyang.zhang
     * @date 2023/7/28 10:35
     * @param s
     * @return java.lang.String
     */
    public String reverseWords(String s) {
        if (null == s || "".equals(s.trim())) {
            return "";
        }
        int start = s.length() - 1;
        int end = start;

        String result = "";
        while (start >= 0) {
            boolean noMatch = true;
            while (start >= 0 && !s.substring(start, start + 1).equals(" ")) {
                if (noMatch) {
                    end = start;
                    noMatch = false;
                }
                start--;
            }

            if (!noMatch) {
                result = result + s.substring(start+1, end+1) + " ";
            }

            while (start >= 0 && s.substring(start, start+1).equals(" ")){
                start--;
            }
        }

        return result.substring(0, result.length() - 1);
    }

    public static void main(String[] args) {
        Day13 day13 = new Day13();
        String s = day13.reverseWords(" a be ced  ");
        System.out.println(s);
    }
}
