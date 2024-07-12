package com.wy.leetcode;

/**
 * @author zhangyuyang
 * @create 2024/4/19 12:56
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int middle = right - (right - left)/2;
            // 比 middle 小，比 middle - 1 大 或 比 middle 大，比 middle+1 小
            if (target > nums[middle]) {
                if (middle+1 >= nums.length) {
                    return middle+1;
                }
                if (target < nums[middle+1]) {
                    return middle;
                }else {
                    left = middle + 1;
                }
            } else {
                if (middle - 1 < 0) {
                    return 0;
                }

                if (target > nums[middle - 1]) {
                    return middle;
                } else if (target == nums[middle - 1]){
                    return Math.min(middle - 2, 0);
                } else {
                    right = middle - 1;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(new int[]{1, 3}, 1));
    }
}
