package com.wy.leetcode.practise_30;

import java.util.Stack;

/**
 * @author HelloWorld
 * @create 2023/7/16 09:55
 * @email helloworld.dng@gmail.com
 */
public class Day01_Offer09 {
    private Stack<Integer> inputStack = new Stack<>();

    private Stack<Integer> outputStack = new Stack<>();

    public void appendTail(int value) {
        inputStack.push(value);
    }

    public int deleteHead() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }

        return outputStack.isEmpty() ? -1 : outputStack.pop();
    }

    public static void main(String[] args) {
        Day01_Offer09 day01Offer09 = new Day01_Offer09();

        day01Offer09.appendTail(1);
        day01Offer09.appendTail(2);
        day01Offer09.appendTail(3);
        System.out.println(day01Offer09.deleteHead());
        day01Offer09.appendTail(4);
        System.out.println(day01Offer09.deleteHead());
        day01Offer09.appendTail(5);
        System.out.println(day01Offer09.deleteHead());
        System.out.println(day01Offer09.deleteHead());
        System.out.println(day01Offer09.deleteHead());
        System.out.println(day01Offer09.deleteHead());
        System.out.println(day01Offer09.deleteHead());
    }
}
