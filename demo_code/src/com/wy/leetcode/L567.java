package com.wy.leetcode;

import java.util.Arrays;

/**
 * @author zhangyuyang
 * @create 2024/3/26 13:00
 */
public class L567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }

        int[] window = new int[26];
        int[] s1Count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(window, s1Count)) {
            return true;
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            // 窗口中移出一个字符，并将下一个字符加入
            window[s2.charAt(i) - 'a'] --;
            window[s2.charAt(i+s1.length()) - 'a'] ++;
            if (Arrays.equals(window, s1Count)) {
                return true;
            }
        }

        return false;
    }
}
