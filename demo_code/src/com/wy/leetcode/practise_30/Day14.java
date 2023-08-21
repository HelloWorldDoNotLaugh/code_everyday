package com.wy.leetcode.practise_30;

import java.util.Stack;

/**
 * @author HelloWorld
 * @date 2023/8/6 14:43
 * @email helloworld.dng@gmail.com
 */
public class Day14 {
    /**
     * @description
     * @author HelloWorld
     * @create 2023/8/6 15:00
     * @param board
     * @param word
     * @return boolean
     *  第一步：从 board[0][0]开始遍历，如果 board[i][j]=word[0]则进入第二步，否则 ++
     *  第二步：分别判断向上，向下，向左，向右一步是否在board中，如果在，将位置点入栈，并在已使用数组中做标记，进入第三步；
     *  第三步：如果栈不为空，取栈顶元素，判断和当前word[index]是否相等，相等并且board已经是最后一个元素，返回true，不是最后一个元素 index++，在已使用数组中标记，并将它的向下，向左，向上，向右一个元素且未使用的入栈
     *  问题，不相等的时候怎么回退index
     *
     */
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 数组中第一个值存放当前位置的i，第二个值存放j，第三个值存放当前字符在word中对应的位置
                Stack<int[]> stack = new Stack<>();
                int[][] used = new int[board.length][board[0].length];

                stack.push(new int[]{i, j, -1});
                while (!stack.isEmpty()) {
                    int[] pops = stack.pop();
                    int x = pops[0];
                    int y = pops[1];
                    int index = pops[2] + 1;
                    if (board[x][y] == word.toCharArray()[index] && used[x][y] != 1) {
                        used[x][y] = 1;
                        if (index == word.length() -1) {
                            return true;
                        }
                        pushStackIfNotUsed(x, y, index, stack, board, used);
                    } else {
                        used[x][y] = 0;
                    }
                }
            }
        }

        return false;
    }

    private void pushStackIfNotUsed(int i, int j, int index, Stack<int[]> stack, char[][] board, int[][] used) {
        if (i-1 >= 0 && used[i-1][j] != 1) {
            stack.push(new int[]{i-1, j, index});
        }
        if (i+1 < board.length && used[i+1][j] != 1) {
            stack.push(new int[]{i+1, j, index});
        }
        if (j-1 >= 0 && used[i][j-1] != 1) {
            stack.push(new int[]{i, j-1, index});
        }
        if (j+1 < board[0].length && used[i][j+1] != 1) {
            stack.push(new int[]{i, j+1, index});
        }
    }

    public static void main(String[] args) {
        Day14 day14 = new Day14();

        char[][] board = new char[][]{{'A','B','C','E'}, {'S','F','E','S'}, {'A','D','E','E'}};
        //char[][] board = new char[][]{{'a','b'},{'c','d'}};
        String word = "ABCESEEEFS";

        System.out.println(day14.exist(board, word));
    }
}
