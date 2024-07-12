package com.wy.leetcode;

import java.util.HashMap;

/**
 * @author zhangyuyang
 * @create 2024/2/22 12:35
 */
public class L1 {
    public int[] twoSum(int[] nums, int target) {
        // key: 数组值， value: 下标
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                return new int[]{map.get(key), i};
            }

            map.put(nums[i], i);
        }

        return new int[2];
    }

    /**
     * 错误解法，该解法的前提是 nums是有序的，但本题中 num 不一定有序
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumError(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int sum = nums[left] + nums[right];
            if (sum > target) {
                // 和比目标值大，得减下
                right--;
            } else if (sum < target) {
                // 和比目标值小，增大
                left++;
            } else {
                return new int[] {left, right};
            }
        }

        return new int[]{};
    }
}
