package com.wy.leetcode.math;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author HelloWorld
 * @date 2023/10/16 13:07
 * @email helloworld.dng@gmail.com
 */
public class L260 {
    /**
     * @description 只出现一次的数字
     * @author HelloWorld
     * @create 2023/10/16 13:07
     * @param nums
     * @return int[]
     */
    public int[] singleNumber(int[] nums) {

        HashSet<Integer> existSet = new HashSet<>();
        Arrays.stream(nums).forEach(num -> {
            if (existSet.contains(num)) {
                existSet.remove(num);
            } else {
                existSet.add(num);
            }
        });

        int[] results = new int[2];
        int index = 0;
        for (Integer integer : existSet) {
            results[index] = integer;
            index++;
        }

        return results;
    }
}
