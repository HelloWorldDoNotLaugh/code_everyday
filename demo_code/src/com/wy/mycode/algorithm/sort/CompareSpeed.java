package com.wy.mycode.algorithm.sort;

import com.wy.mycode.algorithm.sort.common.TestExampleData;

import java.util.HashMap;

/**
 * @author HelloWorld
 * @create 2022/6/5 18:17
 * @email helloworld.dng@gmail.com
 * 比较算法的速度
 */
public class CompareSpeed {

    public static void doTest(int times, int max) {
        long startAll = System.currentTimeMillis();
        System.out.println("归并排序...");
        long total = 0;
        HashMap<String, Long> map = new HashMap<>();
        for (int i = 0; i < times; i++) {
            TestExampleData[] testData = TestExampleData.getTestData(max);
            long start = System.currentTimeMillis();
            Merge.sort(testData);
            long end = System.currentTimeMillis();
            total = total + end - start;
        }
        map.put("归并排序", total / times);

        System.out.println("冒泡排序...");
        total = 0;
        for (int i = 0; i < times; i++) {
            TestExampleData[] testData = TestExampleData.getTestData(max);
            long start = System.currentTimeMillis();
            Bubble.sort(testData);
            long end = System.currentTimeMillis();
            total = total + end - start;
        }
        map.put("冒泡排序", total / times);

        System.out.println("插入排序...");
        total = 0;
        for (int i = 0; i < times; i++) {
            TestExampleData[] testData = TestExampleData.getTestData(max);
            long start = System.currentTimeMillis();
            Insertion.sort(testData);
            long end = System.currentTimeMillis();
            total = total + end - start;
        }
        map.put("插入排序", total / times);

        System.out.println("快速排序...");
        total = 0;
        for (int i = 0; i < times; i++) {
            TestExampleData[] testData = TestExampleData.getTestData(max);
            long start = System.currentTimeMillis();
            Quick.sort(testData);
            long end = System.currentTimeMillis();
            total = total + end - start;
        }
        map.put("快速排序", total / times);

        System.out.println("选择排序...");
        total = 0;
        for (int i = 0; i < times; i++) {
            TestExampleData[] testData = TestExampleData.getTestData(max);
            long start = System.currentTimeMillis();
            Selection.sort(testData);
            long end = System.currentTimeMillis();
            total = total + end - start;
        }
        map.put("选择排序", total / times);

        System.out.println("希尔排序...");
        total = 0;
        for (int i = 0; i < times; i++) {
            TestExampleData[] testData = TestExampleData.getTestData(max);
            long start = System.currentTimeMillis();
            Shell.sort(testData);
            long end = System.currentTimeMillis();
            total = total + end - start;
        }
        map.put("希尔排序", total / times);
        long endAll = System.currentTimeMillis();


        System.out.println(max + "个数据" + times + "次排序的平均时间");
        map.keySet().stream().forEach(key-> System.out.println(key + ": " + map.get(key)));

        System.out.println("总计耗时：" + (endAll - startAll) + "ms");
    }

    public static void main(String[] args) {
        doTest(100, 1000 * 10);
        System.out.println();
        doTest(100, 1000 * 10 * 10);
    }
}
