package com.wy.leetcode.window;

/**
 * @author zhangyuyang
 * @since 2024/9/11 18:30
 */
public class L1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int count = 0;
        if (sum / k >= threshold) {
            count++;
        }
        for (int i = k; i < arr.length; i++) {
            // 此时开始移动窗口
            sum = sum - arr[i-k];
            sum = sum + arr[i];
            if (sum / k >= threshold) {
                count++;
            }
        }

        return count;
    }
}
