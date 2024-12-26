package com.wy.leetcode.host;

/**
 * @author zhangyuyang
 * @create 2024/7/23 12:52
 */
public class L53 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 200; i++) {
            stringBuilder.append("a");
        }

        System.out.println(stringBuilder);
    }



}
