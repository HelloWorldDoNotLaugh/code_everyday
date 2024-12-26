package com.wy.leetcode;

/**
 * @author zhangyuyang
 * @since 2024/10/10 13:41
 */
public class L45 {
    public int jump(int[] nums) {
        int curMax = 0;
        int nextMax = 0;
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            nextMax = Math.max(nextMax, i + nums[i]);
            if (i == curMax) {
                step++;
                curMax = nextMax;
            }
        }

        return step;
    }

    public static void main(String[] args) {
        L45 l45 = new L45();
        int[] nums = {2, 3, 1, 0, 0, 0, 0};
        System.out.println(l45.jump(nums));
    }
}
