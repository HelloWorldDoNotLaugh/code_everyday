package com.wy.leetcode;

/**
 * @author zhangyuyang
 * @since 2024/10/12 13:33
 */
public class L279 {
    public int numSquares(int n) {
        return dfs((int)Math.sqrt(n), n);
    }

    private int dfs(int i, int n) {
        if (n == 0) {
            return 0;
        }

        if (i == 0) {
            // 一定不能选
            return Integer.MAX_VALUE;
        }

        if (i * i > n) {
            // 第 i 个数不选
            return dfs(i-1, n);
        }

        return Math.min(dfs(i-1, n), dfs(i, n-i*i)+1);
    }
}
