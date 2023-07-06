package com.wy.leetcode.array.doubleprint;

import java.util.Arrays;

public class L189 {
    public void rotate1(int[] nums, int k) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[(i+k) % nums.length] = nums[i];
        }
        System.arraycopy(result, 0, nums, 0, nums.length);
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length-1);
    }

    private void reverse(int[]nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        L189 l189 = new L189();
        int[] nums = {1,2};
        int k = 3;
        l189.rotate(nums, k);
        Arrays.stream(nums).forEach(System.out::print);
    }
}
