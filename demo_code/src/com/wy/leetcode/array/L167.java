package com.wy.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HelloWorld
 * @create 2023/4/19 21:37
 * @email helloworld.dng@gmail.com
 */
public class L167 {
    public int[] twoSum(int[] numbers, int target) {
        // 定义双指针
        int right = 0;
        int left = numbers.length - 1;
        while (right < left) {
            int sum = numbers[right] + numbers[left];
            if (sum == target) {
                return new int[]{right+1, left+1};
            } else if (sum > target) {
                // 和大了，往小移动
                left--;
            } else {
                // 和小，往大的移动
                right++;
            }
        }
        return null;
    }

    public int[] twoSumByMap(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i + 1);
        }

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{i+1, map.get(target - numbers[i])};
            }
        }

        return null;
    }
}
