package com.wy.leetcode;

import java.util.ArrayDeque;

/**
 * @author zhangyuyang
 * @since 2024/9/13 13:11
 */
public class L1475 {
    public int[] finalPrices(int[] prices) {
        int[] result = new int[prices.length];
        ArrayDeque<Integer> unKnowStack = new ArrayDeque<>();
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            result[i] = price;
            while (!unKnowStack.isEmpty() && price <= prices[unKnowStack.peek()]) {
                Integer j = unKnowStack.pop();
                result[j] -= price;
            }
            unKnowStack.push(i);
        }

        return result;
    }
}
