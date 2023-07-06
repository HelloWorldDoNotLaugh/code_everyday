package com.wy.leetcode.array.doubleprint;

/**
 * @author HelloWorld
 * @create 2023/4/20 23:03
 * @email helloworld.dng@gmail.com
 */
public class L209 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int windowsSum = 0;
        int minLength = Integer.MAX_VALUE;
        while (right < nums.length) {
            windowsSum += nums[right];
            while (windowsSum >= target) {
                minLength = Math.min(minLength, right-left+1);
                windowsSum -= nums[left];
                left++;
            }
            right++;
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
