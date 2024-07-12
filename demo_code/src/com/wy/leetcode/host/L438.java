package com.wy.leetcode.host;

import cn.hutool.core.map.MapUtil;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangyuyang
 * @create 2024/7/3 13:05
 */
public class L438 {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return Collections.emptyList();
        }

        int[] windows = new int[26];
        int[] counts = new int[26];

        for (int i = 0; i < p.length(); i++) {
            windows[s.charAt(i) - 'a']++;
            counts[p.charAt(i) - 'a']++;
        }

        List<Integer> result = new ArrayList<>();
        if (Arrays.equals(windows, counts)) {
            result.add(0);
        }

        for (int i = p.length(); i < s.length(); i++) {
            char preChar = s.charAt(i - p.length());
            char curChar = s.charAt(i);
            // 为了保证窗口的长度一直跟 p 保持一致，先移出前一个字符
            windows[preChar - 'a']--;
            windows[curChar - 'a']++;
            if (Arrays.equals(windows, counts)) {
                result.add(i + 1 - p.length());
            }
        }

        return result;
    }


    public static void main(String[] args) {
        L438 l438 = new L438();
        System.out.println(l438.findAnagrams("aa", "bb"));
    }
}
