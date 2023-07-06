package com.wy.mycode.algorithm.sort;

import com.wy.mycode.algorithm.sort.common.SortExample;
import com.wy.mycode.algorithm.sort.common.TestExampleData;

/**
 * @author HelloWorld
 * @create 2022/6/5 16:44
 * @email helloworld.dng@gmail.com
 */
public class Quick extends SortExample {
    public static void sort(Comparable[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(Comparable[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int v = partition(array, low, high);
        sort(array, low, v-1);
        sort(array, v+1, high);
    }


    /**
     * @description 选取数组中的第一个数为基数v，使 < v 的数位于v的右边， >= v 的数位于v的左边
     * @author HelloWorld
     * @create 2022/6/5 16:49
     * @param array
     * @param low
     * @param high
     * @return int
     */
    private static int partition(Comparable[] array, int low, int high) {
        int i = low;
        int j = high + 1;
        Comparable v = array[low];
        while (true) {
            // 找到左边第一个大于 v 的数
            while (SortExample.less(array[++i], v)) {
                if (i == high) {
                    break;
                }
            }
            // 找到右边第一个小于v的数
            while (SortExample.less(v, array[--j])) {
                if (j == low) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }
            // 交换它们的位置
            SortExample.exch(array, i, j);
        }
        // 将 v 放入正确的位置
        SortExample.exch(array, low, j);
        // 返回 v 的下标
        return j;
    }

    public static void main(String[] args) {
        TestExampleData[] testData = TestExampleData.getTestData(1000 * 10 * 10);
        SortExample.show("排序前", testData);
        sort(testData);
        if (SortExample.isSorted(testData)) {
            SortExample.show("排序后", testData);
            return;
        }
        SortExample.show("排序失败", testData);
    }
}
