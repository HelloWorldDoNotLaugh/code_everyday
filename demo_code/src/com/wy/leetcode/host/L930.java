package com.wy.leetcode.host;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author zhangyuyang
 * @create 2024/7/12 12:34
 */
public class L930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int windowSum = 0;
        int left = 0;
        int right = 0;
        int result = 0;
        while (right < nums.length) {
            windowSum += nums[right];
            while (windowSum > goal && left < right) {
                windowSum -= nums[left];
                left++;
            }

            while (windowSum == goal && right < nums.length) {
                result++;
                right++;
            }

            right++;
        }

        return result;
    }

    public static void main(String[] args) {
        L930 l930 = new L930();
        int[] nums = new int[]{1,0,1,0,1};

        int total = 2;
        System.out.println(JSON.toJSONString(l930.numSubarraysWithSum(nums, total)));
    }
}
