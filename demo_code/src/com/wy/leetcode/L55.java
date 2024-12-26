package com.wy.leetcode;

/**
 * @author zhangyuyang
 * @since 2024/10/10 13:04
 */
public class L55 {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }

            max = Math.max(max, i + nums[i]);
        }

        return true;
    }
}
