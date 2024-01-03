package com.wy.leetcode;

import com.wy.util.DataUtil;

import java.util.Arrays;

/**
 * @author HelloWorld
 * @date 2023/10/27 12:57
 * @email helloworld.dng@gmail.com
 */
public class L1465 {
    private static final int MOD = 1_000_000_007;
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        long l = (long) getMaxSplit(horizontalCuts, h) * getMaxSplit(verticalCuts, w);
        return (int)(l % MOD);
    }

    private int getMaxSplit(int[] array, int length) {
        int result = Math.max(array[0], length - array[array.length - 1]);
        for (int i = 1; i <= array.length-1; i++) {
            result = Math.max(result, array[i] - array[i-1]);
        }

        return result;
    }
    public static void main(String[] args) {
        int[] horizontalCuts = DataUtil.getArray("[3]");
        int[] verticalCuts = DataUtil.getArray("[3]");

        int h = 5;
        int w = 4;

        L1465 l1465 = new L1465();
        System.out.println(l1465.maxArea(h, w, horizontalCuts, verticalCuts));
    }
}
