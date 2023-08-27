package com.wy.leetcode.practise_30;

import java.util.HashSet;
import java.util.LinkedList;
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
        // 优化：消除字符不一致的影响
        if (charNotAllMatch(board, word)) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 数组中第一个值存放当前位置的i，第二个值存放j，第三个值存放当前字符在word中对应的位置
                Stack<int[]> stack = new Stack<>();
                LinkedList<String> used = new LinkedList<>();

                stack.push(new int[]{i, j, -1});
                while (!stack.isEmpty()) {
                    int[] pops = stack.pop();
                    int x = pops[0];
                    int y = pops[1];
                    int index = pops[2] + 1;
                    if (board[x][y] == word.toCharArray()[index]) {
                        while (used.size() > index) {
                            used.removeLast();
                        }
                        used.addLast(String.format("(%s,%s)", x, y));
                        if (index == word.length() -1) {
                            return true;
                        }

                        pushStackIfNotUsed(x, y, index, stack, board, used);
                    }

                }
            }
        }

        return false;
    }

    private void pushStackIfNotUsed(int i, int j, int index, Stack<int[]> stack, char[][] board, LinkedList<String> used) {
        if (i-1 >= 0 && usedListNotContain(used, i-1, j)) {
            stack.push(new int[]{i-1, j, index});
        }
        if (i+1 < board.length && usedListNotContain(used, i+1, j)) {
            stack.push(new int[]{i+1, j, index});
        }
        if (j-1 >= 0 && usedListNotContain(used, i, j-1)) {
            stack.push(new int[]{i, j-1, index});
        }
        if (j+1 < board[0].length && usedListNotContain(used, i, j+1)) {
            stack.push(new int[]{i, j+1, index});
        }
    }

    private boolean usedListNotContain(LinkedList<String> matched, int x, int y) {
        return !matched.contains(String.format("(%s,%s)", x, y));
    }

    private boolean charNotAllMatch(char[][] board, String word) {
        HashSet<Character> wordCharSet = new HashSet<>();
        for (char c : word.toCharArray()) {
            wordCharSet.add(c);
        }

        HashSet<Character> boardCharSet = new HashSet<>();
        for (char[] chars : board) {
            for (char c : chars) {
                boardCharSet.add(c);
            }
        }

        return !boardCharSet.containsAll(wordCharSet);
    }


    /**
     * @description 剑指 Offer 13. 机器人的运动范围
     * @author HelloWorld
     * @create 2023/8/20 14:44
     * @param m
     * @param n
     * @param k
     * @return int
     */
    public int movingCount(int m, int n, int k) {
        int[][] ranArray = new int[m][n];
        ranArray[0][0] = 1;
        int count = 0;
        for (int i = 0; i < m; i++) {
            if (addEveryBit(i) > k) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (canRun(ranArray, i, j, k)) {
                    count++;
                    ranArray[i][j] = 1;
                }
            }
        }

        return count;
    }

    private int addEveryBit(int num) {
        int result = 0;
        while (num > 0) {
            result += num % 10;
            num = num / 10;
        }

        return result;
    }

    private boolean canRun(int[][] ranArray, int i, int j, int k) {
        boolean canDown = i-1 >= 0 && ranArray[i-1][j] == 1;
        if (canDown && addEveryBit(i) + addEveryBit(j) <= k) {
            return true;
        }
        boolean canRight = j - 1 >= 0 && ranArray[i][j - 1] == 1;

        if (canRight && addEveryBit(i) + addEveryBit(j) <= k) {
            return true;
        }

        if (i==0 && j==0) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Day14 day14 = new Day14();

        //System.out.println(day14.addEveryBit(0));

        System.out.println(day14.movingCount(16, 8, 4));
    }
}
