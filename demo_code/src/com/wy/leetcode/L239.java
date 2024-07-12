package com.wy.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zhangyuyang
 * @create 2024/3/28 12:41
 */
public class L239 {
    public static void main(String[] args) {
        L239 l239 = new L239();
        l239.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }


    // 定义优先队列，元素有两个值，第一个值是数组中的 value, 第二个值记录 index
    Queue<int[]> window = new PriorityQueue<>((o1, o2) -> {
        // 当值不等时，谁大谁在队首
        if (o1[0] != o2[0]) {
            return o2[0] - o1[0];
        }
        // 当值相等时，谁的坐标在后谁在队首
        return o2[1] - o1[1];
    });

    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        // 先构造最初的窗口
        for (int i = 0; i < k; i++) {
            window.offer(new int[]{nums[i], i});
        }

        assert window.peek() != null;
        result.add(window.peek()[0]);

        for (int i = k; i < nums.length; i++) {
            window.offer(new int[]{nums[i], i});
            // 为什么要傻傻的真的去移动窗口，只要保证最大值在窗口中不就行了
            while (window.peek()[1] <= i - k) {
                window.poll();
            }
            result.add(window.peek()[0]);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
