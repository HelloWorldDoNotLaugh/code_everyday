package com.wy.leetcode;

import java.util.HashMap;

public class L2367 {

    public static void main(String[] args) {
        L2367 l2367 = new L2367();
        int[] nums = {0,1,4,6,7,10};
        int diff = 3;

        int i = l2367.arithmeticTriplets(nums, diff);
        System.out.printf(i + "");
    }


    public int arithmeticTriplets(int[] nums, int diff) {
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int num : nums) {
            int count = 0;
            int current = num;
            while (count < 2 && hasNextValue(diff, map, current)) {
                current = current + diff;
                count++;
            }

            if (count == 2) {
                result++;
            }
        }

        return result;
    }

    private static boolean hasNextValue(int diff, HashMap<Integer, Integer> map, int current) {
        return map.containsKey(current + diff) && map.get(current) < map.get(current + diff);
    }
}
