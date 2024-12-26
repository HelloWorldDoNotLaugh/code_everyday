package com.wy.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * @author zhangyuyang
 * @since 2024/10/8 12:53
 */
public class Host20 {
    protected static final Map<Character, Character> MAP = new HashMap<>();
    static {
        MAP.put('(', ')');
        MAP.put('[', ']');
        MAP.put('{', '}');
    }

    public boolean isValid(String s) {
        Set<Character> leftSet = MAP.keySet();
        Deque<Character> stack = new LinkedList<>();
        for (char left : s.toCharArray()) {
            if (leftSet.contains(left)) {
                stack.push(left);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                Character right = stack.pop();
                if (!MAP.getOrDefault(right, 'N').equals(left)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}
