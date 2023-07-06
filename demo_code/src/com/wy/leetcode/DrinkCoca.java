package com.wy.leetcode;

import java.util.Scanner;

/**
 * @author HelloWorld
 * @create 2022/4/18 22:29
 * @email helloworld.dng@gmail.com
 */
public class DrinkCoca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n == 0) {
                break;
            }
            System.out.println(doCount(n));
        }
    }

    /**
     * @description 三个空汽水瓶可以换一瓶汽水，允许向老板借空汽水瓶
     * @param n 空气水瓶数量
     * @return int
     */
    private static int doCount(int n) {
        /*
            当 n = 1， 2 换不到汽水
            当 n = 3, 可以换一瓶
            当 n = 4， 可以换两瓶

            每换一次 空瓶数量加1，获得的汽水数量加1，递归调用即可。
         */
        switch (n) {
            case 1 :
            case 2 :
                return 0;
            case 3:
                return 1;
            case 4:
                return 2;
        }
        return 1 + doCount(n - 3 + 1);
    }
}
