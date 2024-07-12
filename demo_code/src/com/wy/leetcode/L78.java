package com.wy.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangyuyang
 * @create 2024/4/18 12:36
 */
public class L78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultLists = new ArrayList<>();
        resultLists.add(new ArrayList<>());
        if (nums == null || nums.length == 0) {
            return resultLists;
        }

        for (int windowSize = 1; windowSize <= nums.length; windowSize++) {
            LinkedList<Integer> window = initWindow(nums, windowSize);
            resultLists.add(new ArrayList<>(window));
            int right = windowSize;
            while (right <= nums.length - 1) {
                window.removeFirst();
                window.add(nums[right]);
                resultLists.add(new ArrayList<>(window));
                right++;
            }
        }

        return resultLists;
    }

    private LinkedList<Integer> initWindow(int[] nums, int windowSize) {
        LinkedList<Integer> window = new LinkedList<>();
        for (int i = 0; i < windowSize; i++) {
            window.add(nums[i]);
        }

        return window;
    }

    public static void main(String[] args) {
        L78 l78 = new L78();
        System.out.println(l78.subsets(new int[]{1, 2, 3, 4}));
    }
}
