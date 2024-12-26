package com.wy.leetcode;

import java.util.PriorityQueue;

/**
 * @author zhangyuyang
 * @since 2024/10/9 12:41
 */
public class L215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((pre, post) -> post - pre);
        for (int num : nums) {
            priorityQueue.add(num);
        }
        for (int i = 0; i < k - 1; i++) {
            priorityQueue.poll();
        }

        return priorityQueue.poll();
    }
}
