package com.wy.leetcode.array;

/**
 * @author HelloWorld
 * @date 2023/9/13 16:05
 * @email helloworld.dng@gmail.com
 */
public class L2596 {
    public boolean checkValidGrid(int[][] grid) {
        // 骑士会从棋盘的 左上角 出发
        if (grid[0][0] != 0) {
            return false;
        }
        // 1. 先按顺序将骑士走过的位置记录下来
        int length = grid.length;
        int[][] pos = new int[length * length][2];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                pos[grid[i][j]] = new int[]{i, j};
            }
        }

        // 2. 判断相邻的两个元素是不是符合要求
        for (int i = 1; i <= pos.length - 1; i++) {
            int dx = Math.abs(pos[i][0] - pos[i-1][0]);
            boolean isOk = dx == 1 || dx == 2;
            if (!isOk) {
                return false;
            }

            int dy = Math.abs(pos[i][1] - pos[i-1][1]);
            isOk = dy == 1 || dy == 2;
            if (!isOk) {
                return false;
            }
        }

        return true;
    }
}
