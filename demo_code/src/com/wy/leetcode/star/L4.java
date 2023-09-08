package com.wy.leetcode.star;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/9/8
 */
public class L4 {
    /**
     *  如果数的总量为奇数个，中间那个数就为中位数；如果是偶数个，中间两个数的和除2
     *  所以尝试将数据分为两组 array1, array2; array1中的每个数都大于array2的数。
     *  且 array1比array2多一个或个数相等；这样取array1的第一个数或者，取array1[0] + array2[0]的和再除2
     *  因为原先两个数组均递增。
     *  所以array1中的第一个数要最小，先进先出，选队列
     *  array2中的第一个数要最大，后进先出 选堆栈。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Queue<Integer> smallQueue = new LinkedList<>();
        Stack<Integer> bigStack = new Stack<>();

        int index1 = 0, index2 = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            int value;
            if (nums1[index1] < nums2[index2]) {
                value = nums1[index1];
                index1++;
            } else {
                value = nums2[index2];
                index2++;
            }

            pushValue(smallQueue, bigStack, value);
        }

        // 假如2还没遍历完
        if (index2 < nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            index1 = index2;
        }

        while (index1 < nums1.length) {
            pushValue(smallQueue, bigStack, nums1[index1]);
            index1++;
        }
        
        return (nums1.length+nums2.length) % 2 == 1 ? smallQueue.peek() : (double) (smallQueue.peek() + bigStack.peek()) /2;
    }

    private void pushValue(Queue<Integer> smallQueue, Stack<Integer> bigStack, int value) {
        if (smallQueue.size() == bigStack.size()) {
            smallQueue.add(value);
        } else {
            smallQueue.add(value);
            bigStack.push(smallQueue.poll());
        }
    }

    public static void main(String[] args) {
        L4 l4 = new L4();

        System.out.println(l4.findMedianSortedArrays(new int[]{}, new int[]{3}));
    }
}
