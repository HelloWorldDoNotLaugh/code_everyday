package com.wy.leetcode.array;

/**
 * @author zhangyuyang
 * @since 2024/9/6 12:40
 */
public class ArrayRemoveDuplicate {
    public int removeDuplicates(int[] nums) {
        int cur = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[cur] = nums[i];
                cur++;
            }
        }

        return cur;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0,0,1,1,1,2,2,3,3,4};
        int i = new ArrayRemoveDuplicate().removeDuplicates(nums);
        System.out.println(i);
    }
}
