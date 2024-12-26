package com.wy.leetcode;

import java.util.PriorityQueue;

/**
 * @author zhangyuyang
 * @since 2024/10/9 13:34
 */
public class L295 {
}

class MedianFinder {

    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((pre, post) -> post - pre);
    }

    public void addNum(int num) {
        if (minHeap.size() != maxHeap.size()) {
           minHeap.add(num);
           maxHeap.add(minHeap.poll());
        } else {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        return minHeap.size() == maxHeap.size() ? (minHeap.peek() + maxHeap.peek()) / 2.0 : minHeap.peek();
    }
}