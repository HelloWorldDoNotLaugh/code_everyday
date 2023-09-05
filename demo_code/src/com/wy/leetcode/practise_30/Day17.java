package com.wy.leetcode.practise_30;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/9/5
 */
public class Day17 {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        // 冒泡排序，每次可以确定一个最大的或最小的
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
                result[i] = arr[arr.length - 1 - i];
            }
        }
        result[k-1] = arr[arr.length-k];
        return result;
    }

    public static void main(String[] args) {
        Day17 day17 = new Day17();
//        int[] leastNumbers = day17.getLeastNumbers(new int[]{0,0,2,3,2,1,1,2,0,4}, 10);
//        System.out.println(leastNumbers);

        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(10);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(6);
        medianFinder.addNum(5);
        medianFinder.addNum(0);
        medianFinder.addNum(6);
        medianFinder.addNum(3);
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(0);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(0);
        System.out.println(medianFinder.findMedian());

    }


    static class MedianFinder {
        Queue<Integer> bigHeap, smallHeap;

        public MedianFinder() {
            // 小顶堆保存较大的数
            smallHeap = new PriorityQueue<>();
            // 大顶堆保存较小堆数
            bigHeap = new PriorityQueue<>((x, y)-> (y - x));
        }

        public void addNum(int num) {
            if (bigHeap.size() != smallHeap.size()) {
                smallHeap.add(num);
                bigHeap.add(smallHeap.poll());
            } else {
                bigHeap.add(num);
                smallHeap.add(bigHeap.poll());
            }
        }

        public double findMedian() {
            return smallHeap.size() != bigHeap.size() ? smallHeap.peek() : (smallHeap.peek() + bigHeap.peek()) / 2.0;
        }
    }

}
