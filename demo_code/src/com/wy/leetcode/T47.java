package com.wy.leetcode;

public class T47 {
    public static void main(String[] args) {
        T47 t47 = new T47();
        int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}};


        System.out.println(t47.maxValue(grid));

    }

    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    f[i][j] = Math.max(f[i][j], f[i-1][j]);
                }
                if (j > 0) {
                    f[i][j] = Math.max(f[i][j], f[i][j-1]);
                }

                f[i][j] += grid[i][j];
            }
        }
        return f[m-1][n-1];
    }

    public int maxValue1(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        //dp[i][j]表示从gr1d[0][0]到grid[i - 1][j - 1]时的最大价值
        int[][] dp = new int[row + 1][column + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[row][column];
    }
}
