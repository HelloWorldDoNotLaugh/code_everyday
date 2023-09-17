package com.wy.leetcode.practise_30;

import com.wy.util.DataUtil;

import java.util.HashMap;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/9/15
 */
public class Day22 {
    /**
     * @description 剑指 Offer 56 - I. 数组中数字出现的次数
     * @author yuyang.zhang
     * @date 2023/9/15 13:48
     * @param nums
     * @return int[]
     */
    public int[] singleNumbers(int[] nums) {
        int x = 0, y = 0, n = 0, m = 1;
        for(int num : nums)               // 1. 遍历异或
            n ^= num;
        while((n & m) == 0)               // 2. 循环左移，计算 m
            m <<= 1;
        for(int num: nums) {              // 3. 遍历 nums 分组
            if((num & m) != 0) x ^= num;  // 4. 当 num & m != 0
            else y ^= num;                // 4. 当 num & m == 0
        }

        return new int[] {x, y};          // 5. 返回出现一次的数字
    }


    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer value = map.getOrDefault(num, 0);
            map.put(num, ++value);
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }

        throw new RuntimeException("not found!");
    }

    public static void main(String[] args) {
        Day22 day22 = new Day22();
        int[] ints = day22.singleNumbers(DataUtil.getArray("[4,1,4,6]"));
        System.out.println(ints);
    }
}
