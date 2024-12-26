package com.wy.leetcode.host;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyuyang
 * @create 2024/7/22 12:52
 */
public class L76 {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty() || s.length() < t.length()) {
            return "";
        }
        HashMap<Character, Integer> counterMap = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();


        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        int minLeft = Integer.MAX_VALUE;
        int minRight = Integer.MAX_VALUE;
        while (right < t.length()) {
            char c = t.charAt(right);
            counterMap.put(c, counterMap.getOrDefault(c, 0) + 1);

            char c1 = s.charAt(right);
            window.put(c1, window.getOrDefault(c1, 0) + 1);

            right++;
        }

        if (containAll(window, counterMap)) {
            min = right - left;
            minLeft = left;
            minRight = right - 1;
        }

        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (containAll(window, counterMap)) {
                char c1 = s.charAt(left);
                window.put(c1, window.getOrDefault(c1, 0) - 1);
                if (min > right - left + 1) {
                    min = right - left + 1;
                    minLeft = left;
                    minRight = right;
                }
                left++;
            }

            right++;
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(minLeft, minRight + 1);
    }

    private boolean containAll(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
        if (map1.equals(map2)) {
            return true;
        }

        for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
            Character key = entry.getKey();
            if (!map1.containsKey(key)) {
                return false;
            }

            if (map1.get(key) < entry.getValue()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        L76 l76 = new L76();
        String s = l76.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }
}
