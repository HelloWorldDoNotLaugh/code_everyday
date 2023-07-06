package com.wy.leetcode.search;

/**
 * @author HelloWorld
 * @create 2023/4/15 07:54
 * @email helloworld.dng@gmail.com
 */
public class L35 {
    public int searchInsert(int[] nums, int target) {
        int end = nums.length - 1;
        int start = 0;
        while (start <= end) {
            int current = end + (start - end) / 2;
            if (target == nums[current]) {
                return current;
            } else if (target < nums[current]) {
                end = current - 1;
            } else {
                start = current + 1;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        L35 l35 = new L35();
        int[] nums = new int[]{1, 3, 5, 6};
        System.out.println(l35.searchInsert(nums, 0));
    }
}
