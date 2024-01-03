package com.wy.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author HelloWorld
 * @date 2023/11/2 22:05
 * @email helloworld.dng@gmail.com
 */
public class L2103 {
    public int countPoints(String rings) {
        HashMap<Character, HashSet<Character>> map = new HashMap<>();
        char[] chars = rings.toCharArray();
        for (int i = 0; i <= chars.length - 2; i=i+2) {
            HashSet<Character> set = map.getOrDefault(chars[i + 1], new HashSet<>());
            set.add(chars[i]);
            map.put(chars[i+1], set);
        }

        int result = 0;
        for (HashSet<Character> value : map.values()) {
            if (value.size() >= 3) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        L2103 l2103 = new L2103();
        System.out.println(l2103.countPoints("B0R0G0R9R0B0G0"));
    }
}
