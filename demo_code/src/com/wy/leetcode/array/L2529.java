package com.wy.leetcode.array;

/**
 * @author zhangyuyang
 * @create 2024/4/9 12:38
 */
public class L2529 {
    public int maximumCount(int[] nums) {
        int positive = 0;
        int negative = 0;
        for (int num : nums) {
            if (num > 0) {
                positive++;
            } else if (num < 0) {
                negative++;
            }
        }
        return Math.max(positive, negative);
    }
}
