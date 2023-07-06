package com.wy.mycode.algorithm.sort.common;

/**
 * @author HelloWorld
 * @create 2022/6/3 17:16
 * @email helloworld.dng@gmail.com
 *
 * 排序算法模版类
 */
public class SortExample {
    /**
     * @description 比较两个数的大小  v < w 返回 true
     * @author HelloWorld
     * @create 2022/6/3 18:56
     * @param v
     * @param w
     * @return boolean
     */
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * @description  交换数组元素位置
     * @author HelloWorld
     * @create 2022/6/3 19:05
     * @param a
     * @param i
     * @param j
     * @return void
     */
    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * @description 单行打印数组元素
     * @author HelloWorld
     * @create 2022/6/3 19:08
     * @param a
     * @return void
     */
    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void show(String msg, Comparable[] a) {
        System.out.print(msg + ": ");
        show(a);
    }

    /**
     * @description  判断数组元素是否有序
     * @author HelloWorld
     * @create 2022/6/3 19:11
     * @param a
     * @return boolean
     */
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i-1])) {
                return false;
            }
        }
        return true;
    }
}
