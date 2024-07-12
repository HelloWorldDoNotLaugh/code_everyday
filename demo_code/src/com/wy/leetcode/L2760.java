package com.wy.leetcode;

import com.wy.util.DataUtil;

public class L2760 {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int res = 0, n = nums.length;
        for (int l = 0; l < n; l++) {
            for (int r = l; r < n; r++) {
                if (isSatisfied(nums, l, r, threshold)) {
                    res = Math.max(res, r - l + 1);
                }
            }
        }
        return res;
    }

    public boolean isSatisfied(int[] nums, int l, int r, int threshold) {
        if (nums[l] % 2 != 0) {
            return false;
        }
        for (int i = l; i <= r; i++) {
            if (nums[i] > threshold || (i < r && nums[i] % 2 == nums[i + 1] % 2)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] datas = DataUtil.getArray("[4]");
        int threshold = 1;

        System.out.println(new L2760().longestAlternatingSubarray(datas, threshold));
    }
}
