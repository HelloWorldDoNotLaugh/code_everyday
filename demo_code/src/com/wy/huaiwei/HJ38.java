package com.wy.huaiwei;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author HelloWorld
 * @create 2022/8/9 20:11
 * @email helloworld.dng@gmail.com
 */
public class HJ38 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        doDealInput(n);
    }

    /**
     * @description HJ38 求小球落地5次后所经历的路程和第5次反弹的高度
     * @author HelloWorld
     * @create 2022/8/9 20:30
     * @param n
     * @return void
     */
    private static void doDealInput(int n) {
        BigDecimal sum = new BigDecimal(n);
        BigDecimal jump = sum.divide(new BigDecimal("2"));
        for (int i = 1; i < 5; i++) {
            sum = sum.add(jump.multiply(new BigDecimal("2")));
            jump = jump.divide(new BigDecimal("2"));
        }
        System.out.println(sum);
        System.out.println(jump);
    }
}
