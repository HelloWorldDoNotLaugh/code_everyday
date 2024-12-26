package com.wy.leetcode.host;

import javafx.util.Pair;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zhangyuyang
 * @create 2024/7/18 15:44
 */
public class L239 {
    /**
     * 优先队列，key-值，value-下标
     */
    static Queue<Pair<Integer, Integer>> queue = new PriorityQueue<> ((o1, o2) -> {
        // 值不同的，值最大的在队首
        if (!Objects.equals(o1.getKey(), o2.getKey())) {
            return o2.getKey() - o1.getKey();
        }

        // 值相同的，下标最小的在队首
        return o1.getValue() - o2.getValue();
    });

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k > nums.length) {
            return new int[0];
        }

        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            queue.offer(new Pair<>(nums[i], i));
        }

        result[0] = queue.peek().getKey();

        for (int i = k; i < nums.length; i++) {
            // 如果最大值不在窗口的范围内，移出窗口
            while (!queue.isEmpty() && queue.peek().getValue() < i - k + 1) {
                queue.poll();
            }
            queue.offer(new Pair<>(nums[i], i));
            result[i - k + 1] = queue.peek().getKey();
        }

        return result;
    }

    public static void main(String[] args) {
        queue.add(new Pair<>(1, 2));
        queue.add(new Pair<>(3, 3));
        queue.add(new Pair<>(3, 4));
        System.out.println();
    }
}
