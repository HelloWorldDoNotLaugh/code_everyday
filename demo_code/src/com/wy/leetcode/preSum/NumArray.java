package com.wy.leetcode.preSum;

/**
 * @author zhangyuyang
 * @create 2024/6/4 12:38
 */
public class NumArray {
    private int[] preSum;

    public NumArray(int[] nums) {
        preSum = new int[nums.length+1];
        preSum[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            preSum[i+1] = nums[i] + preSum[i];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right+1] - preSum[left];
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }
}
