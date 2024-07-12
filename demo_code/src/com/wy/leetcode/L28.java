package com.wy.leetcode;

import com.wy.algo.linkedlist.LinkedList;

import java.util.Arrays;

/**
 * @author zhangyuyang
 * @create 2024/2/22 17:29
 */
public class L28 {
    public static void main(String[] args) {
        L28 l28 = new L28();
        System.out.println(l28.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        Arrays.sort(nums);
        int max = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i-1] == 1) {
                count++;
            } else if (nums[i] - nums[i-1] == 0) {
                continue;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }

        return Math.max(max, count);
    }
}
