package com.wy.leetcode.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author HelloWorld
 * @create 2023/4/15 08:10
 * @email helloworld.dng@gmail.com
 */
public class L977 {
    public int[] sortedSquares(int[] nums) {
        //return Arrays.stream(nums).map(num -> num * num).sorted().toArray();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length - i; j++) {
                if (Math.abs(nums[j-1]) > Math.abs(nums[j])) {
                    int temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                }
            }
            nums[nums.length - 1 - i] *= nums[nums.length - 1 - i];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10,199, 543};
        L977 l977 = new L977();
        int[] ints = l977.sortedSquares(nums);
        System.out.println(Arrays.stream(ints).mapToObj(String::valueOf).collect(Collectors.joining(",")));
    }
}
