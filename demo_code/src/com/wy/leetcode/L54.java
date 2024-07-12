package com.wy.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyuyang
 * @create 2024/4/1 13:12
 */
public class L54 {
    public static void main(String[] args) {
        List<Integer> integers = new L54().spiralOrder(new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}});
        System.out.println(JSON.toJSONString(integers));
    }

    private int total = 0;
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resultList = new ArrayList<>();

        int rowNum = matrix.length;
        int lineNum = matrix[0].length;

        int cycleTime = 0;
        total = rowNum * lineNum;
        while (total > 0) {
            right(matrix, rowNum, lineNum, cycleTime, resultList);
            down(matrix, rowNum, lineNum, cycleTime, resultList);
            left(matrix, rowNum, lineNum, cycleTime, resultList);
            up(matrix, rowNum, lineNum, cycleTime, resultList);
            cycleTime++;
        }

        return resultList;
    }

    private void right(int [][] matrix, int rowNum, int lineNum, int cycleTime, List<Integer> resultList) {
        int row = cycleTime;
        if (row >= rowNum || total <= 0) {
            return;
        }

        for (int line = cycleTime; line < lineNum - cycleTime; line++) {
            resultList.add(matrix[row][line]);
            total--;
        }
    }

    private void down(int [][] matrix, int rowNum, int lineNum, int cycleTime, List<Integer> resultList) {
        int line = lineNum - 1 - cycleTime;
        if (line < 0 || total <= 0) {
            return;
        }

        for (int row = cycleTime + 1; row < rowNum - cycleTime; row++) {
            resultList.add(matrix[row][line]);
            total--;
        }
    }

    private void left(int [][] matrix, int rowNum, int lineNum, int cycleTime, List<Integer> resultList) {
        int row = rowNum - 1 - cycleTime;
        if (row < 0 || total <= 0) {
            return;
        }

        for (int line = lineNum - 2 - cycleTime; line >= cycleTime; line--) {
            resultList.add(matrix[row][line]);
            total--;
        }
    }

    private void up(int [][] matrix, int rowNum, int lineNum, int cycleTime, List<Integer> resultList) {
        int line = cycleTime;
        if (line < 0 || total <= 0) {
            return;
        }

        for (int row = rowNum - 2 - cycleTime; row >= cycleTime + 1; row--) {
            resultList.add(matrix[row][line]);
            total--;
        }
    }
}
