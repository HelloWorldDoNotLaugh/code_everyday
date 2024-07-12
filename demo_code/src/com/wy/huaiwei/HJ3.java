package com.wy.huaiwei;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @author zhangyuyang
 * @create 2024/2/21 13:10
 */
public class HJ3 {
    public static void main (String[] args) {
        // 获取输入并利用 set 去重
        Set<Integer> set = getInput();

        // 排序
        List<Integer> list = new ArrayList(set);
        list.sort(Comparator.comparingInt(Integer::intValue));
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    private static Set<Integer> getInput() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(scanner.nextInt());
        }
        return set;
    }
}
