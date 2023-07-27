package com.wy.leetcode.practise_30;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/7/27
 */
public class Day10 {
    /**
     * @description 剑指 Offer 46. 把数字翻译成字符串
     * @author yuyang.zhang
     * @date 2023/7/27 09:39
     * @param num
     * @return int
     *  当num[i-1]num[i]整体可以倍翻译: dp[i] = dp[i-1] + dp[i-2]
     *                     不可以翻译: dp[i] = dp[i-1]
     */
    public int translateNum(int num) {
        char[] charArray = (num + "").toCharArray();
        int[] dp = new int[charArray.length + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < charArray.length; i++) {
            Integer value = Integer.valueOf(charArray[i - 1] + "" + charArray[i]);
            if (value > 25 || value < 10) {
                dp[i+1] = dp[i];
            } else {
                dp[i+1] = dp[i] + dp[i-1];
            }
        }

        return dp[charArray.length];
    }

    /**
     * @description 剑指 Offer 48. 最长不含重复字符的子字符串
     * @author yuyang.zhang
     * @date 2023/7/27 10:35
     * @param s
     * @return int
     *  设包含s[i]的最长不含重复子串为 d[i]
     *  当s[i]与 d[i-1]重复时，d[i]=s[i]; 否则 d[i]=d[i-1]中不包含s[i]的连续子串+s[i]
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        String temp = s.substring(0, 1);
        int maxLength = 1;
        for (int i = 1; i < s.length(); i++) {
            String cur = s.substring(i, i+1);
            while (temp.contains(cur)) {
                temp = temp.substring(1);
            }

            temp = temp + cur;

            maxLength = temp.length() > maxLength ? temp.length() : maxLength;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Day10 day10 = new Day10();
        System.out.println(day10.lengthOfLongestSubstring("pwwkew"));
    }
}
