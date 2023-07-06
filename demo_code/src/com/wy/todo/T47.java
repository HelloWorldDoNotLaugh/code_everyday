package com.wy.todo;

public class T47 {
    public static void main(String[] args) {
        T47 t47 = new T47();
        int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}};

        System.out.println(t47.maxValue(grid));

    }

    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
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
}
