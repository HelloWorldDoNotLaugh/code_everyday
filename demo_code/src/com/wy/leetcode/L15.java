package com.wy.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhangyuyang
 * @create 2024/3/20 12:56
 */
public class L15 {
    public static void main(String[] args) {
        L15 l15 = new L15();
        List<List<Integer>> lists = l15.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(JSON.toJSONString(lists));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        List<List<Integer>> lists = new ArrayList<>(result);
        return lists;
    }
}
