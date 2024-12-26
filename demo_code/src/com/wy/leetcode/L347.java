package com.wy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author zhangyuyang
 * @since 2024/10/9 12:52
 */
public class L347 {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }

        Arrays.sort(nums);
        int left = 0;
        int right;

        PriorityQueue<NumsCount> priorityQueue = new PriorityQueue<>((pre, post) -> post.count - pre.count);
        for (right = 0; right < nums.length - 1; right++) {
            if (nums[right] == nums[right+1]) {
                continue;
            }

            int count = right - left + 1;
            priorityQueue.add(new NumsCount(nums[right], count));
            left = right + 1;
        }

        priorityQueue.add(new NumsCount(nums[right], right - left + 1));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll().num;
        }

        return result;
    }

    static class NumsCount{
        int num;
        int count;

        public NumsCount(int num, int count)
        {
            this.num = num;
            this.count = count;
        }
    }


    public static void main(String[] args) {
        new L347().topKFrequent(new int[]{-1, -1}, 1);
    }
}
