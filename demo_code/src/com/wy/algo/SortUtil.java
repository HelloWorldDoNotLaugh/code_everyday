package com.wy.algo;

import com.google.common.collect.Lists;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhangyuyang
 * @create 2024/2/8 09:46
 */
public class SortUtil {
    /**
     * 冒泡排序
     * @param list 待排序列表
     * @param comparator 比较器 递增：Comparator.comparingInt(Integer::intValue) 递减：Comparator.comparingInt(Integer::intValue).reversed()
     * @return 排序后的列表
     */
    public static<E> List<E> bubbleSort(List<E> list, Comparator<E> comparator) {
        for (int i = 1; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i; j++) {
                if (comparator.compare(list.get(j), list.get(j+1)) > 0) {
                    swap(list, j, j+1);
                }
            }
        }

        return list;
    }

    /**
     * 选择排序
     * @param list 待排序列表
     * @param comparator 比较器 递增：Comparator.comparingInt(Integer::intValue) 递减：Comparator.comparingInt(Integer::intValue).reversed()
     * @return 排序后的列表
     */
    public static<E> List<E> selectionSort(List<E> list, Comparator<E> comparator) {
        for (int i = 0; i < list.size(); i++) {
            int minIndex = i;
            E minElement = list.get(i);
            for (int j = i+1; j < list.size(); j++) {
                if (comparator.compare(list.get(j), minElement) < 0) {
                    minIndex = j;
                    minElement = list.get(j);
                }
            }
            swap(list, i, minIndex);
        }

        return list;
    }

    private static<E> void swap(List<E> list, int i, int j) {
        E temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1, 3, 5, 2, 4);
        List<Integer> integers = selectionSort(list, Comparator.comparingInt(Integer::intValue));
        System.out.println();
    }
}
