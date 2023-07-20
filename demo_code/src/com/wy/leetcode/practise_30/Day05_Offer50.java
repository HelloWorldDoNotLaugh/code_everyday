package com.wy.leetcode.practise_30;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author HelloWorld
 * @date 2023/7/21 07:15
 * @email helloworld.dng@gmail.com
 */
public class Day05_Offer50 {
    public char firstUniqChar(String s) {
        // LinkedHashMap是有序的，放入key的顺序和取出的顺序是一样的
        // map中重置的字符的value是false
        LinkedHashMap<Character, Boolean> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, !map.containsKey(c));
        }

        for (Character key : map.keySet()) {
            if (map.get(key)) {
                return key;
            }
        }

        return ' ';
    }
}
