package com.wy.leetcode;

/**
 * @author zhangyuyang
 * @since 2024/9/12 12:34
 */
public class L34 {

    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                int start = mid;
                while (start >= 0 && nums[start] == target) {
                    start--;
                }

                int end = mid;
                while (end < nums.length && nums[end] == target) {
                    end++;
                }

                return new int[]{start + 1, end - 1};
            }
        }

        return new int[]{-1, -1};
    }
}
