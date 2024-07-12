package com.wy.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangyuyang
 * @create 2024/4/1 12:37
 */
public class L73 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        new L73().setZeroes(matrix);
        System.out.println(JSON.toJSONString(matrix));
    }
    public void setZeroes(int[][] matrix) {
        Set<Integer> zeroRow = new HashSet<>();
        Set<Integer> zeroLine = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroRow.add(i);
                    zeroLine.add(j);
                }
            }
        }

        for (Integer row : zeroRow) {
            Arrays.fill(matrix[row], 0);
        }

        for (Integer line : zeroLine) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][line] = 0;
            }
        }
    }

    /*

    0 1 2 0     0 0 0 0   0 0 0 0
    3 4 5 2  => 0 4 5 0   0 4 5 0
    1 3 1 5     1 3 1 5   0 3 1 0

     */
}
