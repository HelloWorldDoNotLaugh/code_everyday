package com.wy.mycode.algorithm.sort;

import com.wy.mycode.algorithm.sort.common.SortExample;
import com.wy.mycode.algorithm.sort.common.TestExampleData;

/**
 * @author HelloWorld
 * @create 2022/6/3 19:14
 * @email helloworld.dng@gmail.com
 * 选择排序
 */
public class Selection extends SortExample {
    /**
     * @description 第一次：选择数组中的最小的元素，与数组中的第一个元素交换位置(如果第一个元素就是最小的，也交换)
     *              第二次：从剩下元素中选择最小的元素，与数组中第二个元素交换位置
     *              如此往复，直到遍历完整个数组
     * @author HelloWorld
     * @create 2022/6/3 19:16
     * @param a
     * @return void
     */
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            // 找到当前最小的元素
            for (int j = i; j < a.length; j++) {
                if (SortExample.less(a[j], a[min])) {
                    min = j;
                }
            }
            // 交换位置
            SortExample.exch(a, i, min);
        }
    }

    public static void main(String[] args) {
        TestExampleData[] array = TestExampleData.getTestData(100);
        SortExample.show("排序前", array);
        sort(array);
        if (SortExample.isSorted(array)) {
            SortExample.show("排序后", array);
            return;
        }
        SortExample.show("排序失败", array);

    }
}
