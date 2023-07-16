package com.wy.leetcode.practise_30;

/**
 * @author HelloWorld
 * @date 2023/7/16 15:04
 * @email helloworld.dng@gmail.com
 */
public class Day04_Offer53 {
    public int search(int[] nums, int target) {
        int position = position(nums, target);
        if (position == -1) {
            return 0;
        }

        int result = 1;
        int cur = position - 1;
        while (cur >= 0 && nums[cur] == target) {
            result++;
            cur--;
        }

        cur = position + 1;
        while (cur < nums.length && nums[cur] == target) {
            result++;
            cur++;
        }

        return result;

    }

    private int position(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = right + (left - right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Day04_Offer53 day04Offer53 = new Day04_Offer53();
        System.out.println(day04Offer53.search(new int[]{1}, 1));
    }
}
