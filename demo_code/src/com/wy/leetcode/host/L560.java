package com.wy.leetcode.host;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyuyang
 * @create 2024/7/18 14:21
 */
public class L560 {
    public int subarraySum_temp(int[] nums, int k) {
        int[] preSum = getPreSum(nums);

        int count = 0;
        for (int i = 0; i < preSum.length; i++) {
            for (int j = i + 1; j < preSum.length; j++) {
                if (preSum[j] - preSum[i] == k) {
                    count++;
                }
            }
        }

        return count;
    }

    private int[] getPreSum(int[] nums) {
        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        return preSum;
    }

    public int subarraySum(int[] nums, int k) {
        int preSum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            preSum += num;
            count += map.getOrDefault(preSum - k, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(new L560().subarraySum(nums, k));
    }
}
