package com.wy.leetcode.practise_30;

/**
 * @author HelloWorld
 * @date 2023/7/17 19:58
 * @email helloworld.dng@gmail.com
 */
public class Day05_Offer04 {
    // 从右下角开始遍历
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int x = matrix.length - 1, y = 0;
        while (x >= 0 && y < matrix[0].length) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                x--;
            } else {
                y++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1,   4,  7, 11, 15}, {2,   5,  8, 12, 19}, {3,   6,  9, 16, 22}, {10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
        int[][] matrix = {};
        Day05_Offer04 day05Offer04 = new Day05_Offer04();
        System.out.println(day05Offer04.findNumberIn2DArray(matrix, 19));
    }
}
