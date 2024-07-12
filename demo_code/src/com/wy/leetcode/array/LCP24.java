package com.wy.leetcode.array;

import com.alibaba.fastjson.JSON;

import java.math.BigDecimal;

/**
 * @author zhangyuyang
 * @create 2024/2/1 12:52
 */
public class LCP24 {
    public int[] numsGame(int[] nums) {
        int[] results = new int[nums.length];
        BigDecimal total = new BigDecimal(0);
        for (int i = 1; i < nums.length; i++) {
            int result = Math.abs(nums[i-1] + 1 - nums[i]);
            total = total.add(new BigDecimal(result));
            BigDecimal[] bigDecimals = total.divideAndRemainder(new BigDecimal("1000000007"));
            results[i] = bigDecimals[1].intValue();
            nums[i] = nums[i-1] + 1;
        }
        return results;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,3,4};

        LCP24 lcp24 = new LCP24();
        System.out.println(JSON.toJSON(lcp24.numsGame(nums)));
    }
}
