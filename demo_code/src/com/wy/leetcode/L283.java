package com.wy.leetcode;

/**
 * @author zhangyuyang
 * @create 2024/2/23 12:50
 */
public class L283 {
    public static void main(String[] args) {
        L283 l283 = new L283();
        int[] ints = {0, 1, 0, 3, 12, 0, 5, 0};
        l283.moveZeroes(ints);
        System.out.println();
    }

    public void moveZeroes(int[] nums) {
        // 利用快速排序思想，把0看作快速排序的中间数
        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            // 当前元素不是 0，交换到左边
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[zeroIndex];
                nums[zeroIndex] = temp;
                zeroIndex++;
            }
        }
    }

}
