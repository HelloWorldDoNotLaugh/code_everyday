package com.wy.mycode.algorithm.sort;

import com.wy.mycode.algorithm.sort.common.SortExample;
import com.wy.mycode.algorithm.sort.common.TestExampleData;

/**
 * @author HelloWorld
 * @create 2022/6/3 21:11
 * @email helloworld.dng@gmail.com
 * 插入排序
 */
public class Insertion extends SortExample {
    /**
     * @description 遍历数组，将数据插入到合适到位置
     *              第一次：只有一个数，那么它一定在它最合适的位置
     *              第二次：比较第二个数与第一个数的大小，如果第二个数小于第一个数，交换他们位置
     *              第三次：比较第三个数与前两个数的大小，并按照比较结果交换它们位置
     *              直到数组遍历完
     * @author HelloWorld
     * @create 2022/6/3 21:13
     * @param array
     * @return void
     */
    public static void sort(Comparable[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && SortExample.less(array[j], array[j-1]); j--) {
                SortExample.exch(array, j, j-1);
            }
        }
    }

    public static void main(String[] args) {
        TestExampleData[] testData = TestExampleData.getTestData(100);
        SortExample.show("排序前",  testData);
        sort(testData);
        if (SortExample.isSorted(testData)) {
            SortExample.show("排序后", testData);
            return;
        }
        SortExample.show("排序失败", testData);
    }
}
