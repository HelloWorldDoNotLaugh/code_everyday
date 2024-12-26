package com.wy.leetcode;

import org.yaml.snakeyaml.util.ArrayStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author zhangyuyang
 * @since 2024/9/20 13:05
 */
public class L844 {
    public boolean backspaceCompare(String s, String t) {
        return backspace(s).equals(backspace(t));
    }

    private Deque<Character> backspace(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }

        return stack;
    }

    public static void main(String[] args) {
        System.out.println(new L844().backspaceCompare("y#fo##f", "y#f#o##f"));

        // 创建两个 Deque
        Deque<Integer> deque1 = new LinkedList<>();
        Deque<Integer> deque2 = new LinkedList<>();

        // 向 Deque 添加元素
        deque1.add(1);
        deque1.add(2);
        deque1.add(3);

        deque2.add(1);
        deque2.add(2);
        deque2.add(3);

        // 使用 equals 方法比较两个 Deque 是否相等
        boolean areEqual = deque1.equals(deque2);

        System.out.println("Are the deques equal? " + areEqual);
    }
}
