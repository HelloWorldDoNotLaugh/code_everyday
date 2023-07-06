package com.wy.leetcode.stack;

import java.util.Stack;

public class L1047 {
    public String removeDuplicates(String s) {
        Stack<Character> charStack = new Stack<>();
        charStack.push('9');
        for (char c : s.toCharArray()) {
            if (c == charStack.peek()) {
                charStack.pop();
            } else {
                charStack.push(c);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Character character : charStack) {
            stringBuffer.append(character);
        }
        return stringBuffer.toString().substring(1);
    }

    public static void main(String[] args) {
        L1047 l1047 = new L1047();
        System.out.println(l1047.removeDuplicates("abbaca"));
    }
}
