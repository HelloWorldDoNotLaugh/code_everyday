package com.wy.leetcode.week;

import com.wy.util.DataUtil;

/**
 * @author HelloWorld
 * @date 2023/10/1 10:33
 * @email helloworld.dng@gmail.com
 */
public class Week365 {
    /**
     * @description 100088. 有序三元组中的最大值 I
     * @author HelloWorld
     * @create 2023/10/1 10:33
     * @param nums
     * @return long
     */
    public long maximumTripletValue(int[] nums) {
        long max = -1;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i+1; j < nums.length - 1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    long value = (long)(nums[i] - nums[j]) * nums[k];
                    max = Math.max(max, value);
                }
            }
        }

        return max > 0 ? max : 0;
    }

    /**
     * @description: 100086. 有序三元组中的最大值 II
     * @author HelloWorld
     * @create 2023/10/1 11:01
     * @param nums
     * @return long
     * 找出最大的两个数，和最小数
     */
    public long maximumTripletValue2(int[] nums) {
        long max = 0;
        int index = 1;
        while (index < nums.length - 1) {
            int i = findMaxValue(nums, 0, index - 1);
            int k = findMaxValue(nums, index + 1, nums.length - 1);

            long value = (long) (i-nums[index]) * k;
            max = Math.max(max, value);

            index++;
        }

        return Math.max(max, 0);
    }

    private int findMaxValue(int[] nums, int start, int end) {
        int max = nums[start];
        for (int i = start+1; i <= end; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }



    public static void main(String[] args) {
        Week365 week365 = new Week365();
        System.out.println(week365.maximumTripletValue(DataUtil.getArray("[6,14,20,19,19,10,3,15,12,13,8,1,2,15,3]")));
    }
}
