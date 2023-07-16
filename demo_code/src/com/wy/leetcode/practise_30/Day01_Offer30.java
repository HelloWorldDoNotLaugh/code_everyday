package com.wy.leetcode.practise_30;

import java.util.Stack;

/**
 * @author HelloWorld
 * @create 2023/7/16 10:25
 * @email helloworld.dng@gmail.com
 */
public class Day01_Offer30 {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        Integer removed = stack.pop();
        if (removed.equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        Day01_Offer30 day01Offer30 = new Day01_Offer30();

        day01Offer30.push(512);
        day01Offer30.push(-1024);
        day01Offer30.push(-1024);
        day01Offer30.push(512);

        day01Offer30.pop();
        System.out.println(day01Offer30.min());
        day01Offer30.pop();
        System.out.println(day01Offer30.min());
        day01Offer30.pop();
        System.out.println(day01Offer30.min());
    }
}
