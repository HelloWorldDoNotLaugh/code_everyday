package com.wy.leetcode.practise_30;

/**
 * @author HelloWorld
 * @date 2023/7/28 08:17
 * @email helloworld.dng@gmail.com
 */
public class Day13 {
    /**
     * @description 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
     * @author HelloWorld
     * @create 2023/7/28 08:17
     * @param nums
     * @return int[]
     */
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
           while (left < right && nums[left] % 2 == 1) {
               left++;
           }

           while (left < right && nums[right] %2 == 0) {
               right--;
           }

           exchangePosition(nums, left, right);
           left++;
           right--;
        }

        return nums;
    }

    private void exchangePosition(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * @description 剑指 Offer 57. 和为 s 的两个数字
     * @author HelloWorld
     * @create 2023/7/28 08:31
     * @param nums
     * @param target
     * @return int[]
     */
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int value = nums[left] + nums[right];
            if (value < target) {
                left++;
            } else if (value > target) {
                right--;
            } else {
                return new int[]{nums[left], nums[right]};
            }
        }

        return new int[0];
    }

    /**
     * @description 剑指 Offer 58 - I. 翻转单词顺序
     * @author yuyang.zhang
     * @date 2023/7/28 10:35
     * @param s
     * @return java.lang.String
     */
    public String reverseWords(String s) {
        if (null == s || "".equals(s.trim())) {
            return "";
        }
        int start = s.length() - 1;
        int end = start;

        String result = "";
        while (start >= 0) {
            boolean noMatch = true;
            while (start >= 0 && !s.substring(start, start + 1).equals(" ")) {
                if (noMatch) {
                    end = start;
                    noMatch = false;
                }
                start--;
            }

            if (!noMatch) {
                result = result + s.substring(start+1, end+1) + " ";
            }

            while (start >= 0 && s.substring(start, start+1).equals(" ")){
                start--;
            }
        }

        return result.substring(0, result.length() - 1);
    }

    public static void main(String[] args) {
        Day13 day13 = new Day13();
        int[] nums = {1, 2,  3, 4, 5};
        System.out.println(day13.twoSum(nums, 8));
    }
}
