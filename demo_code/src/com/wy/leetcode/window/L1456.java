package com.wy.leetcode.window;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author zhangyuyang
 * @since 2024/9/11 12:54
 */
public class L1456 {
    private static final Set<Character> VOWEL_SET = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    public int maxVowels(String s, int k) {
        if (s.length() < k) {
            return 0;
        }

        int result = 0;
        LinkedList<Character> window = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (VOWEL_SET.contains(s.charAt(i))) {
                result++;
            }
            window.add(s.charAt(i));
        }

        int count = result;
        for (int i = k; i < s.length(); i++) {
            // 此时开始移动窗口
            // 窗口中的第一个元素
            char firstWord = window.removeFirst();
            if (VOWEL_SET.contains(firstWord)) {
                count--;
            }
            if (VOWEL_SET.contains(s.charAt(i))) {
                count++;
            }

            result = Math.max(result, count);

            if (result == k) {
                return result;
            }
            window.add(s.charAt(i));
        }

        return result;
    }
}
