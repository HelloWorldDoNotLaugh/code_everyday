package com.wy.leetcode.math;

import java.util.HashSet;

/**
 * @author HelloWorld
 * @date 2023/10/17 09:31
 * @email helloworld.dng@gmail.com
 */
public class L2652 {
    public int sumOfMultiples(int n) {
        HashSet<Integer> factorSet = new HashSet<>();
        for (int i = 1; i < n; i++) {
            if (i * 3 <= n) {
                factorSet.add(i*3);
            } else {
                break;
            }

            if (i * 5 <= n) {
                factorSet.add(i*5);
            }

            if (i * 7 <= n) {
                factorSet.add(i*7);
            }
        }

        int sum = 0;
        for (Integer integer : factorSet) {
            sum += integer;
        }

        return sum;
    }
}
