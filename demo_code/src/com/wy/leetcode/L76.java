package com.wy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyuyang
 * @create 2024/3/26 13:12
 */
public class L76 {
    public static void main(String[] args) {
        L76 l76 = new L76();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String minWindow = l76.minWindow(s, t);
        System.out.println(minWindow);
    }
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        HashMap<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        HashMap<Character, Integer> window = new HashMap<>();

        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;
        int minRight = 0;
        while (right < s.length()) {
            window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
            while (checkWindow(window, need) && left <= right) {
                if (minLen > right - left + 1) {
                    minLen = right - left + 1;
                    minLeft = left;
                    minRight = right;
                }
                window.put(s.charAt(left), window.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minRight + 1);
    }

    private boolean checkWindow(HashMap<Character, Integer> window, HashMap<Character, Integer> need) {
        for (Map.Entry<Character, Integer> entry : need.entrySet()) {
            if (window.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }

        return true;
    }
}
