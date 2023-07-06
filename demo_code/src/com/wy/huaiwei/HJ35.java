package com.wy.huaiwei;

import java.util.Scanner;

/**
 * @author HelloWorld
 * @create 2022/8/6 20:51
 * @email helloworld.dng@gmail.com
 */
public class HJ35 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        doDealInput(n);
    }

    /**
     * @description 蛇形矩阵
     * @author HelloWorld
     * @create 2022/8/6 20:53
     * @param n
     * @return void
     */
    private static void doDealInput(int n) {
        int num = 1;
        for (int column = 1; column <= n; column++) {
            num = num + column - 1;
            System.out.print(num + " ");
            int temp = num;
            for (int row = column + 1; row <= n; row++) {
                temp += row;
                System.out.print(temp + " ");
            }
            System.out.println();
        }
    }
}
