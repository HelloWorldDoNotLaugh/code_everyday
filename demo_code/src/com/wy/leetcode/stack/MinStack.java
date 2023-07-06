package com.wy.leetcode.stack;

import java.util.LinkedList;
import java.util.List;

public class MinStack {
    private static List<Integer> stack;
    private static Integer minValue;
    public MinStack() {
        stack = new LinkedList<>();
        minValue = Integer.MAX_VALUE;
    }

    public void push(int val) {
        stack.add(val);
        minValue = minValue < val ? minValue : val;
    }

    public void pop() {
        top();
        stack.remove(stack.size() - 1);

        minValue = Integer.MAX_VALUE;
        for (Integer integer : stack) {
            minValue = minValue < integer ? minValue : integer;
        }
    }

    public int top() {
        if (stack.size() == 0) {
            throw new NullPointerException("stack is null");
        }

        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return minValue;
    }
}
