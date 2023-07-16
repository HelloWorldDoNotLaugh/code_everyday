package com.wy.leetcode.practise_30;

import java.util.HashSet;
import java.util.Set;

/**
 * @author HelloWorld
 * @date 2023/7/16 14:41
 * @email helloworld.dng@gmail.com
 */
public class Day04_Offer03 {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> values = new HashSet<>();
        for (int num : nums) {
            if (values.contains(num)) {
                return num;
            }
            values.add(num);
        }

        return -1;
    }

    public static void main(String[] args) {
        Day04_Offer03 day04Offer03 = new Day04_Offer03();
        System.out.println(day04Offer03.findRepeatNumber(new int[]{1, 4, 2, 4}));
    }
}
