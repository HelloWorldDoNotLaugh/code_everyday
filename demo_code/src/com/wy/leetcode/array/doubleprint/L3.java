package com.wy.leetcode.array.doubleprint;

import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class L3 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        char[] charArray = s.toCharArray();
        HashMap<Character, Integer> windowsMap = new HashMap<>();
        while (right < charArray.length) {
            char rightChar = charArray[right];
            int value = windowsMap.containsKey(rightChar) ? windowsMap.get(rightChar) : 0;
            windowsMap.put(rightChar, value+1);
            while (windowsMap.get(rightChar) > 1) {
                windowsMap.put(charArray[left], windowsMap.get(charArray[left])-1);
                left++;
            }
            maxLength = Math.max(maxLength, right-left+1);
            right++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        L3 l3 = new L3();
        System.out.println(l3.lengthOfLongestSubstring(s));
    }
}
