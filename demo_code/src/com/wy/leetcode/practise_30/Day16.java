package com.wy.leetcode.practise_30;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author HelloWorld
 * @date 2023/9/4 22:42
 * @email helloworld.dng@gmail.com
 */
public class Day16 {
    public String minNumber(int[] nums) {
        quickSort(nums);
        return Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining());
    }

    private void quickSort(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(nums.length-1);
        while (!stack.isEmpty()) {
            Integer right = stack.pop();
            Integer left = stack.pop();

            if (left < right) {
                int partition = partition(nums, left, right);
                stack.push(left);
                stack.push(partition-1);

                stack.push(partition+1);
                stack.push(right);
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int pivotIndex = left;

        for (int i = left; i < right; i++) {
            if (compare(nums[i], pivot) < 0) {
                swap(nums, i, pivotIndex);
                pivotIndex++;
            }
        }
        swap(nums, pivotIndex, right);
        return pivotIndex;
    }



    private int compare(int m, int n) {
        return (""+m+n).compareTo(""+n+m);
    }

    public static void main(String[] args) {
        Day16 day16 = new Day16();

        //System.out.println(day16.minNumber(new int[]{824,938,1399,5607,6973,5703,9609,4398,8247}));
        System.out.println(day16.isStraight(new int[]{0, 7, 1, 3, 5}));
    }

    /**
     * @description 剑指 Offer 61. 扑克牌中的顺子
     * @author yuyang.zhang
     * @date 2023/9/5 09:42
     * @param nums
     * @return boolean
     */
    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0, min = 14;
        for (int num : nums) {
            if (num == 0) {continue;}
            if (set.contains(num)) {return false;}

            max = Math.max(max, num);
            min = Math.min(min, num);
            set.add(num);
        }

        return max - min <= 4;
    }


    private void swap(int[]nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
