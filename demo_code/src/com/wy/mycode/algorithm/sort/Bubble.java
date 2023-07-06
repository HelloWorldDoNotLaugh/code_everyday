package com.wy.mycode.algorithm.sort;

import com.wy.mycode.algorithm.sort.common.SortExample;
import com.wy.mycode.algorithm.sort.common.TestExampleData;

/**
 * @author HelloWorld
 * @create 2022/6/5 17:40
 * @email helloworld.dng@gmail.com
 */
public class Bubble extends SortExample {
    public static void sort(Comparable[] array) {
        // 对n个数进行，冒泡排序，最多要进行 n - 1 轮，因为每次都能确定一个数都位置
        for (int i = 1; i < array.length; i++) {
            // 结束循环的标志 是否发生交换
            boolean eachFlag = false;
            // 第二层循环表示 每个数要比较的次数
            for (int j = 0; j < array.length - i; j++) {
                if (SortExample.less(array[j+1], array[j])) {
                    SortExample.exch(array, j+1, j);
                    eachFlag = true;
                }
            }
            if (!eachFlag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        TestExampleData[] testData = TestExampleData.getTestData(6000);
        SortExample.show("排序前", testData);
        sort(testData);
        if (SortExample.isSorted(testData)) {
            SortExample.show("排序后", testData);
            return;
        }
        SortExample.show("排序失败", testData);
    }
}
