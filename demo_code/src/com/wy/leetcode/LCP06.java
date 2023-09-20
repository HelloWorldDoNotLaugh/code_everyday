package com.wy.leetcode;

/**
 * @author HelloWorld
 * @date 2023/9/20 18:50
 * @email helloworld.dng@gmail.com
 */
public class LCP06 {
    public int minCount(int[] coins) {
        int result = 0;
        for (int coin : coins) {
            if (coin % 2 == 0) {
                result += coin / 2;
            } else {
                result += coin/2 + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LCP06 lcp06 = new LCP06();
        System.out.println(lcp06.minCount(new int[]{2, 3, 10}));
    }
}
