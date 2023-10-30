package com.wy.leetcode.sort;

import com.wy.util.DataUtil;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/10/18
 */
public class L2530 {

    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b)-> b-a);

        for (int num : nums) {
            priorityQueue.add(num);
        }

        long result = 0;
        for (int i = 0; i < k; i++) {
            Integer value = priorityQueue.poll();
            result += value;

            priorityQueue.add((value+2)/3);
        }

        return result;
    }

}
