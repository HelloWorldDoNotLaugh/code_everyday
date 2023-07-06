package com.wy.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author HelloWorld
 * @create 2022/4/23 16:29
 * @email helloworld.dng@gmail.com
 */
public class SortString {
    public static final String RULE = "[A-Za-z]";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        System.out.println(doSortString(string.toCharArray()));;
    }

    /**
     * @description HJ26 字符串排序
     * @author HelloWorld
     * @create 2022/4/23 17:48
     * @param chars
     * @return java.lang.String
     */
    private static String doSortString(char[] chars) {
        List<String> list = new ArrayList<>();
        for (char aChar : chars) {
            if ((aChar + "").matches(RULE)) {
                list.add(aChar + "");
            }
        }

        // 排序
        list = list.stream()
                .sorted((Comparator.comparingInt(o -> o.toLowerCase().charAt(0))))
                .collect(Collectors.toList());

        // 记录结果
        String result = new String();

        // 与原串比较，插入特殊字符
        int i = 0;
        for (char aChar : chars) {
            if ((aChar + "").matches(RULE)) {
                result += list.get(i);
                i++;
            }else {
                result += aChar;
            }
        }
        return result;
    }
}


