package com.wy.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author HelloWorld
 * @create 2022/4/23 08:34
 * @email helloworld.dng@gmail.com
 */
public class SortData {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String IString = scanner.nextLine();
        String RString = scanner.nextLine();

        System.out.println(doSortDate(IString, RString));;
    }

    private static String doSortDate(String IString, String RString) {
        // 将R序列转换为list，并去重 升序排序
        List<String> RSortList = Arrays.stream(RString.split(" "))
                .skip(1)
                .distinct()
                .map(s -> Long.parseLong(s))
                .sorted()
                .map(s -> s.toString())
                .collect(Collectors.toList());

        StringBuilder results = new StringBuilder();
        for (String s : RSortList) {
            StringBuilder resultTemp = new StringBuilder();
            int count = 0;
            // IString 第一个数为串长度要去掉
            String[] IStr = IString.split(" ");
            for (int i = 1; i < IStr.length; i++) {
                if (IStr[i].contains(s)) {
                    resultTemp.append(i - 1 + " " + IStr[i] + " ");
                    count++;
                }
            }
            if (count != 0) {
                results.append(s + " " + count + " ");
                results.append(resultTemp);
            }
        }
        return results.toString().split(" ").length + " " + results;

    }
}
