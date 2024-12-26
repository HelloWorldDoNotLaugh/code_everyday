package com.wy.leetcode;

import java.util.ArrayDeque;

/**
 * @author zhangyuyang
 * @since 2024/9/13 13:03
 */
public class L739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        ArrayDeque<Integer> unKnowStack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            int temperature = temperatures[i];
            while (!unKnowStack.isEmpty() && temperature > temperatures[unKnowStack.peek()]) {
                Integer j = unKnowStack.pop();
                result[j] = i - j;
            }

            unKnowStack.push(i);
        }

        return result;
    }
}
