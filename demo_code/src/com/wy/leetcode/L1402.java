package com.wy.leetcode;

import java.util.Arrays;

/**
 * @author HelloWorld
 * @date 2023/10/22 23:07
 * @email helloworld.dng@gmail.com
 */
public class L1402 {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        int[][] dp = new int[n + 1][n + 1];
        Arrays.sort(satisfaction);
        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + satisfaction[i - 1] * j;
                if (j < i) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j]);
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
