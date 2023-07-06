package com.wy.mycode.algorithm.sort;

import com.wy.mycode.algorithm.sort.common.SortExample;
import com.wy.mycode.algorithm.sort.common.TestExampleData;

/**
 * @author HelloWorld
 * @create 2022/6/5 08:53
 * @email helloworld.dng@gmail.com
 */
public class Merge extends SortExample {
    /** 辅助数组 */
    private static Comparable[] aux;

    /**
     * @description  将两个有序数组合并为 1 个有序数组
     * @author HelloWorld
     * @create 2022/6/5 15:39
     * @param array
     * @param low
     * @param mid
     * @param high
     * @return void
     */
    public static void merge(Comparable[] array, int low, int mid, int high) {
        // 第一个有序数组的第一个坐标
        int i = low;
        // 第二个有序数组的第一个坐标
        int j = mid + 1;

        // 初始化辅助数组
        for (int k = low; k <= high ; k++) {
            aux[k] = array[k];
        }
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                // 此时说明，第一个数组，已经被合并完了，只需要将第二个数组剩余部分全部加进去
                array[k] = aux[j++];
            }else if (j > high) {
                // 第二个数组合并完成了
                array[k] = aux[i++];
            }else if (SortExample.less(aux[j], aux[i])) {
                array[k] = aux[j++];
            }else {
                array[k] = aux[i++];
            }
        }

    }

    public static void sort(Comparable[] array) {
        // 辅助数组初始化容量
        aux = new Comparable[array.length];
        sort(array, 0, array.length - 1);
    }

    private static void sort(Comparable[] array, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;
        sort(array, low, mid);
        sort(array, mid+1, high);
        merge(array, low, mid, high);
    }

    public static void main(String[] args) {
        TestExampleData[] testData = TestExampleData.getTestData(100);
        SortExample.show("排序前", testData);
        sort(testData);
        if (SortExample.isSorted(testData)) {
            SortExample.show("排序后", testData);
            return;
        }
        SortExample.show("排序失败", testData);

    }
}
