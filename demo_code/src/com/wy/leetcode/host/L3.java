package com.wy.leetcode.host;

import java.util.HashMap;

/**
 * @author zhangyuyang
 * @create 2024/7/3 12:31
 */
public class L3 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        char[] charArray = s.toCharArray();

        // 记录窗口中当前的字符及个数
        HashMap<Character, Integer> windowMap = new HashMap<>();
        while (right < charArray.length) {
            Integer value = windowMap.getOrDefault(charArray[right], 0);
            windowMap.put(charArray[right], value + 1);
            while (windowMap.get(charArray[right]) > 1) {
                windowMap.put(charArray[left], windowMap.get(charArray[left]) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}
