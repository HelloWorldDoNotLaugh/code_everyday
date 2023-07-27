package com.wy.leetcode.practise_30;

/**
 * @author HelloWorld
 * @date 2023/7/23 15:05
 * @email helloworld.dng@gmail.com
 */
public class Day08 {

    /**
     * @description 剑指 Offer 10- I. 斐波那契数列
     * @author HelloWorld
     * @create 2023/7/24 07:18
     * @param n
     * @return int
     */
    public static int fib(int n) {
        int fn = 0;
        int fn1 = 1;
        int fn2 = 0;
        for (int i = 0; i < n; i++) {
            fn2 = (fn + fn1) % 1000000007;
            fn = fn1;
            fn1 = fn2;
        }

        return fn;
    }


    /**
     * @description 剑指 Offer 10- II. 青蛙跳台阶问题
     * @author HelloWorld
     * @create 2023/7/27 06:31
     * @param n
     * @return int
     */
    public int numWays(int n) {
        int fn = 1;
        int fn1 = 1;
        int fn2;
        for (int i = 0; i < n; i++) {
            fn2 = (fn + fn1) % 1000000007;
            fn = fn1;
            fn1 = fn2;
        }

        return fn;
    }

    /**
     * @description 剑指 Offer 63. 股票的最大利润
     * @author HelloWorld
     * @create 2023/7/27 06:41
     * @param prices
     * @return int
     * 记第i日的最大利润为 dp[i];  dp[i] = max(dp[i-1]], prices[i]-min(prices[0, i-1]))
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[] dp = new int[prices.length];
        int minPrices = prices[0];
        dp[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i-1], prices[i]-minPrices);
            minPrices = prices[i] < minPrices ? prices[i] : minPrices;
        }

        return dp[prices.length - 1];
    }

    public static void main(String[] args) {
        int[] prices = {7, 6, 5, 4, 3, 2, 1};
        Day08 day08 = new Day08();
        System.out.println(day08.maxProfit(prices));
    }
}
