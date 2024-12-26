package com.wy.leetcode;

/**
 * @author zhangyuyang
 * @since 2024/10/11 12:49
 */
public class L70 {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int f1 = 1;
        int f2 = 2;
        for (int i = 3; i <= n; i++) {
            int f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }

        return f2;
    }
}
