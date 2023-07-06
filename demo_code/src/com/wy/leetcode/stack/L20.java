package com.wy.leetcode.stack;

import java.util.*;

public class L20 {
    private static final List<Character> LEFT_ARRAY = Arrays.asList('(', '[', '{');
    private static final Map<Character, Character> MAP;
    static {
        MAP = new HashMap<>();
        MAP.put('(', ')');
        MAP.put('[', ']');
        MAP.put('{', '}');
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (LEFT_ARRAY.contains(c)) {
                stack.push(c);
                continue;
            }
            if (stack.empty()) {
                return false;
            }

            if (MAP.get(stack.pop()) != c) {
                return false;
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        L20 l20 = new L20();
        System.out.println(l20.isValid("(]"));
    }
}