package com.wy.leetcode.window;

/**
 * @author zhangyuyang
 * @since 2024/9/11 13:09
 */
public class L643 {
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }

        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double result = sum / k;

        for (int i = k; i < nums.length; i++) {
            // 此时开始移动窗口
            sum = sum - nums[i - k];
            sum = sum + nums[i];
            result = Math.max(result, sum / k);
        }

        return result;
    }

    public static void main(String[] args) {


        System.out.println((double) 10 / 4);
    }
}
