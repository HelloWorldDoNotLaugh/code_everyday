package com.wy.leetcode;

import java.util.*;

/**
 * @author HelloWorld
 * @create 2022/11/27 09:36
 * @email helloworld.dng@gmail.com
 */
public class T1752 {
    public boolean check(int[] nums) {
        // 1. 确定最小数及其所在的位置;(需要注意 nums可能存在重复项)
        List<Integer> minValuePositionSet = getMinValuePositionSet(nums);
        // 2. 从小数开始检查是否满足是有序数组轮换得到：
        for (Integer minValuePosition : minValuePositionSet) {
            if (check(nums, minValuePosition)) {
                return true;
            }
        }
        return false;
    }

    private boolean check(int[] nums, int position) {
        for (int time = 1; time < nums.length; time++) {
            int temp = nums[position];
            if (position + 1 > nums.length - 1) {
                position = -1;
            }
            if (temp > nums[position + 1]) {
                return false;
            }

            position=position + 1;
        }

        return true;
    }

    private List<Integer> getMinValuePositionSet(int[] nums) {
        int min = nums[0];
        HashMap<Integer, List<Integer>> positionMap = new HashMap<>(16);

        ArrayList<Integer> integers = new ArrayList<>(16);
        integers.add(0);
        // 如果替换为：positionMap.put(min, Arrays.asList(0)), 在52行add时会报错 java.lang.UnsupportedOperationException
        positionMap.put(min, integers);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= min) {
                min = nums[i];
                List<Integer> positionList = positionMap.containsKey(min) ? positionMap.get(min) : new ArrayList<>(16);
                positionList.add(i);
                positionMap.put(min, positionList);
            }
        }

        return positionMap.get(min);
    }

    public static void main(String[] args) {
        T1752 t1752 = new T1752();
        int[] nums = {1, 1, 1};
        boolean check = t1752.check(nums);
        System.out.println(check);
    }
}
