package com.wy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyuyang
 * @create 2024/3/21 12:36
 */
public class L3 {
    public static void main(String[] args) {
        L3 l3 = new L3();
        System.out.println(l3.lengthOfLongestSubstring("abba"));
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();

        int right = 0;
        int left = 0;
        int max = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (window.containsKey(c)) {
                // left 重新定位, 并且 left 不能往回走
                left = Math.max(left, window.get(c) + 1);
            }
            max = Math.max(max, right - left + 1);
            window.put(c, right);
            right++;
        }

        return max;
    }
}
