package com.wy.leetcode.array;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author zhangyuyang
 * @since 2024/10/8 13:03
 */
public class L155 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);

        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.top());

    }
}


class MinStack {

    private LinkedList<Integer> linkedList;

    private int min;

    public MinStack() {
        linkedList = new LinkedList<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (val < min) {
            min = val;
        }

        linkedList.add(val);
    }

    public void pop() {
        linkedList.removeLast();
        min = Integer.MAX_VALUE;

        if (linkedList.isEmpty()) {
            return;
        }

        for (Integer value : linkedList) {
            if (value < min) {
                min = value;
            }
        }
    }

    public int top() {
        return linkedList.getLast();
    }

    public int getMin() {
        if (linkedList.isEmpty()) {
            throw new EmptyStackException();
        }
        return min;
    }
}

