package com.wy.leetcode.preSum;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * @author zhangyuyang
 * @create 2024/6/5 12:52
 */
public class L2389 {
    public int[] answerQueries_out(int[] nums, int[] queries) {
        int[] res = new int[queries.length];
        Arrays.sort(nums);

        for (int i = 0; i < queries.length; i++) {
            int sum = 0;
            int index = 0;
            while (index < nums.length) {
                sum += nums[index];
                if (sum > queries[i]) {
                    break;
                }
                index++;
            }
            res[i] = index;
        }

        return res;
    }

    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] preSumArray = buildPreSumArray(nums);

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            result[i] = binarySearch(preSumArray, query);
        }

        return result;
    }
    private int[] buildPreSumArray(int[] nums) {
        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        return preSum;
    }

    private int binarySearch(int[] preSum, int target) {
        int left = 0;
        int right = preSum.length - 1;
        // L <= T <= R
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (preSum[mid] < target) {
                left = mid + 1;
            } else if (preSum[mid] > target) {
                right = mid - 1;
            } else {
                return mid+1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,2,1};
        int[] queries = {3, 10, 21};

        L2389 l2389 = new L2389();
        int[] ints = l2389.answerQueries(nums, queries);
        System.out.println(JSON.toJSONString(ints));
    }
}
