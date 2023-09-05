package com.wy.leetcode.practise_30;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
        private LinkedList<Integer> datas;

        /** initialize your data structure here. */
        public MedianFinder() {
            datas = new LinkedList<>();
        }

        public void addNum(int num) {
            int left = 0;
            int right = datas.size()-1;
            int index = 0;
            while (left <= right) {
                index = left + (right-left)/2;
                if (num == datas.get(index)) {
                    index++;
                    break;
                } else if (num < datas.get(index)) {
                    right = index - 1;
                } else {
                    left = index + 1;
                    index = left;
                }
            }
            index = index < 0 ? 0 : index;
            datas.add(index, num);
        }

        public double findMedian() {
            if (datas.size() % 2 == 1) {
                if (datas.size() == 1) {
                    return datas.get(0);
                }
                return datas.get(datas.size()/2);
            }


            return (double) (datas.get(datas.size() / 2) + datas.get(datas.size() / 2 - 1)) / 2;
        }

    }

}
