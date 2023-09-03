package com.wy.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author HelloWorld
 * @date 2023/8/27 21:51
 * @email helloworld.dng@gmail.com
 */
public class L56 {
    private static final String PATTERN_STRING = "\\[(\\d+),(\\d+)\\]";
    private static final Pattern PATTERN = Pattern.compile(PATTERN_STRING);

    /**
     * @description 合并区间
     * @author HelloWorld
     * @create 2023/8/27 21:51
     * @param intervals
     * @return int[][]
     */
    public int[][] merge(int[][] intervals) {
        List<int[]> resultList = new ArrayList<>();

        intervals = quickSort(intervals);
        int current = 0, next = 1;
        while (current < intervals.length - 1) {
            int[] currentArray = intervals[current];
            int[] nextArray = intervals[next];

            if (nextArray[0] > currentArray[1]) {
                resultList.add(currentArray);
            }else if (nextArray[1] <= currentArray[1]) {
                swap(intervals, current, next);
            }else  {
                nextArray[0] = currentArray[0];
            }
            current++;
            next++;
        }

        int[][] result = new int[resultList.size()+1][2];
        int index = 0;
        for (int[] ints : resultList) {
            result[index++] = ints;
        }
        result[index] = intervals[current];

        return result;
    }

    private int[][] quickSort(int[][] arrays) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(arrays.length - 1);

        while (!stack.isEmpty()) {
            Integer right = stack.pop();
            Integer left = stack.pop();

            if (left < right) {
                int partition = partition(arrays, left, right);

                stack.push(left);
                stack.push(partition-1);

                stack.push(partition+1);
                stack.push(right);
            }
        }

        return arrays;
    }

    private int partition(int[][] arrays, int left, int right) {
        int[] pivot = arrays[right];
        int pivotIndex = left;

        for (int j = left; j < right; j++) {
            int[] array = arrays[j];
            if (array[0] < pivot[0] || (array[0] == pivot[0] && array[1]< pivot[1])) {
                swap(arrays, pivotIndex, j);
                pivotIndex++;
            }
        }

        swap(arrays, pivotIndex, right);
        return pivotIndex;
    }

    private void swap(int[][] arrays, int i, int j) {
        int[] temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }

    public static void main(String[] args) {
        int[][] data = getData("[[2,3],[2,2],[3,3],[1,3],[5,7],[2,2],[4,6]]");
        L56 l56 = new L56();
        int[][] merge = l56.merge(data);

        System.out.println(merge);
    }

    private static int[][] getData(String input) {
        ArrayList<int[]> list = new ArrayList<>();

        Matcher matcher = PATTERN.matcher(input);
        while (matcher.find()) {
            String m = matcher.group(1);
            String n = matcher.group(2);
            list.add(new int[]{Integer.parseInt(m), Integer.parseInt(n)});
        }

        int[][] result = new int[list.size()][2];
        int index = 0;
        for (int[] ints : list) {
            result[index++] = ints;
        }

        return result;
    }

}
