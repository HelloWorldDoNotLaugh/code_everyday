package com.wy.leetcode.array;

/**
 * @author HelloWorld
 * @date 2023/9/17 20:51
 * @email helloworld.dng@gmail.com
 */
public class L213 {
    /**
     * @description
     * @author HelloWorld
     * @create 2023/9/20 09:53
     * @param nums
     * @return int
     * 房屋首尾相连，并且相邻房屋不能被偷窃
     * 所以当偷窃第一间房屋，可偷窃房屋范围为：0, length-2
     * 当偷窃最后一间房屋，可偷窃房屋范围为   1, length-1
     */
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(robRange(nums, 0, length-2), robRange(nums, 1, length-1));
    }

    /**
     * @description
     * @author HelloWorld
     * @create 2023/9/20 10:07
     * @param nums
     * @param start
     * @param end
     * @return int
     * 状态转移房程
     * 到第i间房屋盗窃的最大金额 dp[i] = max(dp[i-1], dp[i-2]+num[i])
     *    只有两种情况，第i间不偷窃，那么dp[i] = dp[i-1]
     *               第i间偷窃，dp[i]=nums[i] + dp[i-2]
     */
    private int robRange(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start+1] = Math.max(nums[start], nums[start+1]);
        for (int i = start+2; i <= end; i++) {
            dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]);
        }

        return dp[end];
    }

    public static void main(String[] args) {
        L213 l213 = new L213();
        System.out.println(l213.rob(new int[]{1, 2, 3}));
    }
}
