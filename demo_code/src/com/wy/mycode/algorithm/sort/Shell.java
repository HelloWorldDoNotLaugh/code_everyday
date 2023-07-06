package com.wy.mycode.algorithm.sort;

import com.wy.mycode.algorithm.sort.common.SortExample;
import com.wy.mycode.algorithm.sort.common.TestExampleData;

/**
 * @author HelloWorld
 * @create 2022/6/4 21:17
 * @email helloworld.dng@gmail.com
 * 希尔排序
 */
public class Shell extends SortExample {
    /**
     * @description 希尔排序
     * @author HelloWorld
     * @create 2022/6/4 22:27
     * @param array
     * @return void
     */
    public static void sort(Comparable[] array) {
        int length = array.length;
        int h = 1;

        // h初始化
        while (h < length / 3) {
            // h的可能为：1， 4， 13， 40， 121， 364， 1093...
            h = 3 * h + 1;
        }

        while (h >= 1) {
            // 对间隔为h的子序列进行插入排序
            // 由于希尔排序的 h 一定存在一个值 1， 即对整个array进行插入排序，故，只需要将原插入逻辑改写

            /*  插入排序对逻辑，只需要将 1 换为h即可
                 for (int i = 1; i < array.length; i++) {
                     for (int j = i; j > 0 && less(array[j], array[j-1]); j--) {
                        exch(array, j, j-1);
                     }
                 }
             */
            for (int i = h; i < length; i++) {
                for (int j = i; j >= h && SortExample.less(array[j], array[j-h]); j = j - h) {
                   SortExample.exch(array, j, j-h);
                }
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {
        TestExampleData[] array = TestExampleData.getTestData(80);
        SortExample.show("排序前", array);
        sort(array);
        if (SortExample.isSorted(array)) {
            SortExample.show("排序后", array);
            return;
        }
        SortExample.show("排序失败", array);
    }
}
