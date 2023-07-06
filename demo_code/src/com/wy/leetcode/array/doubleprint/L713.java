package com.wy.leetcode.array.doubleprint;

/**
 * @author HelloWorld
 * @create 2023/4/20 23:13
 * @email helloworld.dng@gmail.com
 */
public class L713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1){return 0;}
        int left = 0;
        int right = 0;
        int windows = 1;
        int result = 0;
        while (right < nums.length) {
            windows *= nums[right];
            while (windows >= k) {
                windows /= nums[left];
                left++;
            }
            // 为什么是这样
            // 防止 int 类型溢出
            result += right - left + 1;
            right++;
        }

        return result;
    }


    public static void main(String[] args) {
        L713 l713 = new L713();
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        System.out.println(l713.numSubarrayProductLessThanK(nums, k));
    }
}

