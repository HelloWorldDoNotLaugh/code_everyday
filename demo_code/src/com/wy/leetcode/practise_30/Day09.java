package com.wy.leetcode.practise_30;

/**
 * @author HelloWorld
 * @date 2023/7/27 06:54
 * @email helloworld.dng@gmail.com
 */
public class Day09 {

    /**
     * @description 剑指 Offer 42. 连续子数组的最大和
     * @author HelloWorld
     * @create 2023/7/27 06:54
     * @param nums
     * @return int
     *  记到nums[i]时的最大连续子数组为 dp[i], dp[i] = max(nums[i], dp[i-1]+nums[i])
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i-1]+nums[i]);
            max = dp[i] > max ? dp[i] : max;
        }

        return dp[nums.length-1];
    }


    /** 剑指 Offer 47. 礼物的最大价值
     * @description
     * @author HelloWorld
     * @create 2023/7/27 07:44
     * @param grid
     * @return int
     *  记到第(x, y)格获得礼物第最大价值为 dp[x][y]  dp[x][y] = max(dp[x-1][y], dp[x][y-1]) + grid[x][y]
     */
    public int maxValue(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {dp[i][j] = grid[i][j];}
                else if (i == 0) {dp[i][j] = dp[i][j-1] + grid[i][j];}
                else if (j == 0) {dp[i][j] = dp[i-1][j] + grid[i][j];}
                else {dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + grid[i][j];}
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        Day09 day09 = new Day09();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(day09.maxSubArray(nums));
    }
}
