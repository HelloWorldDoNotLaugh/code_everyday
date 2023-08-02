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

        int i = 0, j = 0, index = 0;
        while (i < board.length && j < board[0].length) {
            if (board[i][j] == word.toCharArray()[index]) {

            }
        }

        return false;
    }
}
