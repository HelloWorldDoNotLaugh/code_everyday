package com.wy.leetcode.sort;

import java.util.Arrays;

public class SortUtils {

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




    public static void main(String[] args) {
        Arrays.stream(bubbleSort(new int[]{2, 4, 5, 1, 8})).forEach(System.out::println);
    }
}
