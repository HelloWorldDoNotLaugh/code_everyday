package com.wy.leetcode.practise_30;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author HelloWorld
 * @date 2023/9/4 22:42
 * @email helloworld.dng@gmail.com
 */
public class Day16 {
    private static final String[] NINE_STR_ARR= {"", "9", "99", "999", "9999", "99999", "999999", "9999999", "99999999", "999999999"};
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
            if (append9(nums[i]).compareTo(append9(pivot)) < 0) {
                swap(nums, i, pivotIndex);
                pivotIndex++;
            }
        }
        swap(nums, pivotIndex, right);
        return pivotIndex;
    }

    private void swap(int[]nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private String append9(int num) {
        String numStr = String.valueOf(num);
        if (numStr.length() < 10) {
            numStr = numStr + NINE_STR_ARR[10-numStr.length()];
        }

        return numStr;
    }

    public static void main(String[] args) {
        Day16 day16 = new Day16();

        System.out.println(day16.minNumber(new int[]{3,30,34,5,9}));
    }

    private static Integer[] getData(String str) {
        return Arrays.stream(str.replace("[", "").replace("]", "").split(","))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }
}
