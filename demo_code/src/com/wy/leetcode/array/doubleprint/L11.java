package com.wy.leetcode.array.doubleprint;

public class L11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int s = 0;
        while (left < right) {
            int currentValue = Math.min(height[left], height[right]) * (right - left);
            s = Math.max(s, currentValue);
            // 向两边较大的移动，探索最大值
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return s;
    }
}
