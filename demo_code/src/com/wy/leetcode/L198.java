package com.wy.leetcode;

/**
 * @author zhangyuyang
 * @since 2024/10/11 13:14
 */
public class L198 {
    public int rob(int[] nums) {
        int f0 = nums[0];
        if (nums.length == 1) {
            return f0;
        }

        int f1 = Math.max(nums[0], nums[1]);
        if (nums.length == 2) {
            return f1;
        }

        for (int i = 2; i < nums.length; i++) {
            int fx = Math.max(f1, f0 + nums[i]);
            f0 = f1;
            f1 = fx;
        }

        return f1;
    }


    public static void main(String[] args) {

        String str = "{\n" +
                "    \"children\": [\n" +
                "      {\n" +
                "        \"property\": \"S_S_PADINCAP\",\n" +
                "        \"type\": \"context\",\n" +
                "        \"propertyDataType\": \"STRING\",\n" +
                "        \"op\": \"==\",\n" +
                "        \"value\": \"1\",\n" +
                "        \"rightValueType\": \"input\",\n" +
                "        \"priority\": 1,\n" +
                "        \"params\": \"\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"logicOperator\": \"##\",\n" +
                "    \"type\": \"context\",\n" +
                "    \"customLogicOperator\": \"1\"\n" +
                "  }";
        System.out.println(str);
    }
}
