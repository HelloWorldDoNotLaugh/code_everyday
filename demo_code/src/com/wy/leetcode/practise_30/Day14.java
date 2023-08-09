package com.wy.leetcode.practise_30;

import java.util.Stack;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/8/2
 */
public class Day14 {
    /**
     * @description 剑指 Offer 12. 矩阵中的路径
     * @author yuyang.zhang
     * @date 2023/8/2 12:47
     * @param board
     * @param word
     * @return boolean
     */
    public boolean exist(char[][] board, String word) {
        /*
            只能上下左右移动。利用栈
         */
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[2]);

        int index = 0;
        while (!stack.isEmpty()) {
            int[] currentPosition = stack.pop();
            int i = currentPosition[0];
            int j = currentPosition[1];

            if ((i >= 0 && i < board.length-1) && (j >= 0 && j < board.length-1)) {
                if (word.substring(index, index+1).equals(board[i][j])) {
                    index++;
                } else {
                    index = 0;
                }
            }
            // 向上走
            if (j+1 < board[0].length) {
                stack.push(new int[]{i, j+1});
            }

            // 向下走
            if (j-1 >= 0) {
                stack.push(new int[]{i, j-1});
            }

            // 向左走
            if (i-1 >= 0) {
                stack.push(new int[]{i-1, j});
            }

            // 向右走
            if (i+1 < board.length) {
                stack.push(new int[]{i+1, j});
            }
        }

        return false;
    }
}
