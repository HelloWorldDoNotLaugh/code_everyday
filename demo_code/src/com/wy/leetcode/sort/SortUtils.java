package com.wy.leetcode.sort;

import java.util.Arrays;
import java.util.Stack;

public class SortUtils {

    /**
     * @description 冒泡排序
     * @author HelloWorld
     * @create 2023/8/27 22:20
     * @param array
     * @return int[]
     */
    public static int[] bubbleSort(int[] array) {
        // 第一层控制需要排序的元素个数。 n个元素，只需要确定n-1个元素的位置
        for (int i = 1; i < array.length; i++) {
            // 第二层控制每个元素需要比较的次数 因为冒泡排序每次都能确定一个最大(或最小元素)，所以比较次数会递减
            for (int j = 0; j < array.length - i; j++) {
                if (array[j+1] > array[j]) {
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }

        return array;
    }


    /**
     * @description 快速排序-非递归
     * @author HelloWorld
     * @create 2023/8/27 22:20
     * @param array
     * @return int[]
     */
    public static int[] quickSort(int[] array) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(array.length - 1);

        while (!stack.isEmpty()) {
            Integer right = stack.pop();
            Integer left = stack.pop();

            if (left < right) {
                int partition = partition(array, left, right);

                stack.push(left);
                stack.push(partition-1);

                stack.push(partition+1);
                stack.push(right);
            }
        }

        return array;
    }

    private static int partition(int[] array, int left, int right) {
        // 选择最右边的数作为基数
        int pivot = array[right];
        // 记录基数的真实位置；先将基数固定在最左边
        int pivotIndex = left;

        for (int i = left; i < right; i++) {
            if (array[i] < pivot) {
                swap(array, pivotIndex, i);
                pivotIndex++;
            }
        }

        // 将基数移动到真正属于它的位置
        swap(array, pivotIndex, right);
        return pivotIndex;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        Arrays.stream(quickSort(new int[]{6, 2, 3, 5, 1, 4})).forEach(System.out::println);
    }
}
