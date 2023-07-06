package com.wy.leetcode.array.doubleprint;

public class L1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int left = 0;
        int right = 0;
        int windowSum = 0;
        int result = 0;
        while (right < arr.length) {
            windowSum += arr[right];
            if (right - left + 1 >= k) {
                if (windowSum >= k * threshold) {
                    result++;
                }
                windowSum -= arr[left];
                left++;
            }

            right++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int k = 1;
        int threshold = 0;
        L1343 l1343 = new L1343();
        System.out.println(l1343.numOfSubarrays(nums, k, threshold));
    }
}
