package com.wy.leetcode;

import java.util.Arrays;

public class L2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] pairs = new int[spells.length];
        // 优化：先对potions排序，当 spells[i] * potions[j] >= success时，i之后当一定也符合
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            int spell = spells[i];
            // 二分查找恰好满足要求的那瓶药水
           pairs[i] = binarySearch(potions, spell, success);
        }

        return pairs;
    }

    private int binarySearch(int[] potions, int spell, long success) {
        int right = potions.length - 1;
        int left = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if ((long)spell * potions[mid] >= success) {
                if (mid == 0) {
                    return potions.length;
                }

                if (mid >= 1 && (long)spell * potions[mid - 1] < success) {
                    return potions.length - mid;
                }

                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        new L2300().successfulPairs(new int[] {15,8,19 }, new int[] {38,36,23}, 328);
    }
}
