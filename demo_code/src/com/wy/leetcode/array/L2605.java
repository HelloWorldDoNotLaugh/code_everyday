package com.wy.leetcode.array;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/9/6
 *
 * 2605. 从两个数字数组里生成最小数字
 */
public class L2605 {
    public int minNumber(int[] nums1, int[] nums2) {
        int[] totals = new int[10];
        int minNum1 = countAndFindMin(nums1, totals);
        int minNum2 = countAndFindMin(nums2, totals);

        for (int i = 1; i < totals.length; i++) {
            if (totals[i] == 2) {
                return i;
            }
        }

        return Math.min(minNum1*10 + minNum2, minNum2*10 + minNum1);
    }

    private int countAndFindMin(int[] nums, int[] totals) {
        int minNum = 11;
        for (int num : nums) {
            totals[num]++;
            minNum = Math.min(minNum, num);
        }

        return minNum;
    }

    public static void main(String[] args) {
        L2605 l2605 = new L2605();

        System.out.println(l2605.minNumber(new int[]{4, 1, 7}, new int[]{5, 7}));
    }
}
