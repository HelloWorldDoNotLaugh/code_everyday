package com.wy.leetcode;

/**
 * @author zhangyuyang
 * @since 2024/9/14 14:26
 */
public class L3152 {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] a = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] % 2 == nums[i+1] % 2) {
                a[i] = 1;
            }
        }

        int[] s = new int[a.length + 1];
        for (int i = 0; i < a.length; i++) {
            s[i+1] = s[i] + a[i];
        }

        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int left = query[0];
            int right = query[1];
            if (s[right] - s[left] == 0) {
                ans[i] = true;
            }
        }

        return ans;
    }
}
