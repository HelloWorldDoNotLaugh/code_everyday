package com.wy.leetcode;

/**
 * @author zhangyuyang
 * @since 2024/10/10 12:52
 */
public class L121 {
    public int maxProfit(int[] prices) {
        int minPoint = prices[0];
        int maxProfit = 0;
        for (int price : prices) {
            minPoint = Math.min(minPoint, price);
            maxProfit = Math.max(maxProfit, price - minPoint);
        }

        return maxProfit;
    }
}
