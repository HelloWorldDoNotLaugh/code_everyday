package com.wy.leetcode.math;

import java.util.HashMap;

/**
 * @author HelloWorld
 * @date 2023/10/19 21:13
 * @email helloworld.dng@gmail.com
 */
public class L1726 {
    public int tupleSameProduct(int[] nums) {
        // 1. 定义map记录 积相等的数量
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int key = nums[i] * nums[j];
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }

        /*
            2. 四元组数量
                当 value = 1  0      (1-1)*1*4
                  value = 2  8      (2-1)*2*4
                  value = 3  24     (3-1)*3*4
         */
        int res = 0;
        for (Integer value : map.values()) {
            res += (value-1) * value * 4;
        }

        return res;
    }
}
