package com.wy.leetcode.array.doubleprint;

import java.util.stream.Stream;

public class L26 {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[slow] == nums[fast]) {
                fast++;
            } else {
                slow++;
                nums[slow] = nums[fast];
                fast++;
            }
        }

        return ++slow;
    }

    public static void main(String[] args) {
        L26 l26 = new L26();
        int[] ints = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(l26.removeDuplicates(ints));
    }
}
