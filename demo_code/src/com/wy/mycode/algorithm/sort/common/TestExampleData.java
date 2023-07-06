package com.wy.mycode.algorithm.sort.common;

import java.util.Random;

/**
 * @author HelloWorld
 * @create 2022/6/3 19:27
 * @email helloworld.dng@gmail.com
 *
 */

public class TestExampleData implements Comparable<TestExampleData>{

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value + "";
    }

    @Override
    public int compareTo(TestExampleData a) {
        if (this.getValue() - a.getValue() >= 0) {
            return 1;
        }
        return -1;
    }

    /**
     * @description 返回长度为n的int型随机数组, 数组中的数据范围 [0, 1000]
     * @author HelloWorld
     * @create 2022/6/3 19:34
     * @param n
     * @return com.wy.mycode.algorithm.sort.common.TestExampleData[]
     */
    public static TestExampleData[] getTestData(int n) {
        TestExampleData[] array = new TestExampleData[n];
        for (int i = 0; i < n; i++) {
            TestExampleData testExampleData = new TestExampleData();
            Random random = new Random();
            testExampleData.value = random.nextInt(Integer.MAX_VALUE);
            array[i] = testExampleData;
        }
        return array;
    }


}
