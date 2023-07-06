package com.wy.leetcode;

import sun.security.util.ArrayUtil;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author HelloWorld
 * @create 2022/2/21 19:14
 * @email helloworld.dng@gmail.com
 */
public class Rotate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        new Rotate().rotate(nums, 3);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    private void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int nums[], int start, int end) {
        while (start < end) {
            int t = nums[start];
            nums[start++] = nums[end];
            nums[end--] = t;
        }
    }
}
