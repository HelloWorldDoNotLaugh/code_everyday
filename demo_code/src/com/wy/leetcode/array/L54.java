package com.wy.leetcode.array;

import com.wy.util.DataUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * @author HelloWorld
 * @date 2023/9/21 19:05
 * @email helloworld.dng@gmail.com
 */
public class L54 {
    private int count = 0, time = 0;
    private LinkedList<Integer> list = new LinkedList<>();
    /**
     * @description 螺旋数组
     * @author HelloWorld
     * @create 2023/9/21 19:09
     * @param matrix
     * @return java.util.List<java.lang.Integer>
     *  一定总是 右 -> 下 -> 左 -> 上
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        while (lessCount(matrix)) {
            goRight(matrix);
            goDown(matrix);
            goLeft(matrix);
            goUp(matrix);

            time++;
        }

        return list;
    }

    private void goRight(int[][] matrix) {
        int i = time;
        int right = time;
        boolean canRight = lessCount(matrix) && time < matrix.length && time < matrix[0].length;
        if (!canRight) {
            return;
        }

        while (right <= matrix[0].length - 1 - time) {
            list.addLast(matrix[i][right++]);
            count++;
        }

    }

    private void goDown(int[][] matrix) {
        int j = matrix[0].length - 1 - time;
        int down = time + 1;

        boolean canDown = lessCount(matrix) && down <= matrix.length - 1;
        if (!canDown) {
            return;
        }

        while (down <= matrix.length - 1 - time) {
            list.addLast(matrix[down++][j]);
            count++;
        }
    }

    private void goLeft(int[][] matrix) {
        int i = matrix.length - 1 - time;
        int left = matrix[0].length - 1 - time - 1;
        boolean canLeft = lessCount(matrix) && left >= 0 && i >= 0;
        if (!canLeft) {
            return;
        }

        while (left >= time) {
            list.addLast(matrix[i][left--]);
            count++;
        }
    }

    private void goUp(int[][] matrix) {
        int j = time;
        int up = matrix.length - 1 - time - 1;

        boolean canUp = lessCount(matrix) && j <= matrix[0].length - 1 && up >= 0;
        if (!canUp) {
            return;
        }

        while (up >= time+1) {
            list.addLast(matrix[up--][j]);
            count++;
        }
    }

    private boolean lessCount(int[][] matrix) {
        return count < matrix.length*matrix[0].length;
    }

    public static void main(String[] args) {
        int[][] datas = DataUtil.getDouArray("[[1,2,3],[4,5,6],[7,8,9]]");
        L54 l54 = new L54();
        for (Integer integer : l54.spiralOrder(datas)) {
            System.out.print(integer + " ");
        }

    }

}
