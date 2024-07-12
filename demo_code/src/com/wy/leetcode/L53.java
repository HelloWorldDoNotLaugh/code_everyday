package com.wy.leetcode;

import cn.hutool.core.date.DateUtil;

import java.time.Instant;
import java.util.Date;

/**
 * @author zhangyuyang
 * @create 2024/3/28 13:28
 */
public class L53 {
    public static void main(String[] args) {
        L53 l53 = new L53();
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int maxSubArray = l53.maxSubArray(nums);
        System.out.println(maxSubArray);
    }

    /**
     * 超时
     * @param nums
     * @return
     */
    public int maxSubArray_TimeOut(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int end = i; end >= 0; end--) {
                sum += nums[end];
                max = Math.max(max, sum);
            }
        }

        return max;
    }

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        int result = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i-1]+nums[i]);
            result = Math.max(result, dp[i]);
        }

        return result;
    }
}
