package com.wy.leetcode.practise_30;

/**
 * @author HelloWorld
 * @date 2023/7/16 15:36
 * @email helloworld.dng@gmail.com
 */
public class Day04_Offer53II {
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                // 相等：出错的一定在右边
                left = mid + 1;
            } else {
                // 不等：出错的一定在左边
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        Day04_Offer53II day04Offer53II = new Day04_Offer53II();
        System.out.println(day04Offer53II.missingNumber(new int[]{1, 1}));
    }
}
