package com.wy.huaiwei;

import java.util.Scanner;

/**
 * @author HelloWorld
 * @create 2022/8/8 21:29
 * @email helloworld.dng@gmail.com
 * HJ37 统计每个月兔子的总数
 */
public class HJ37 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(getRabbitNum(num));
    }

    /** 计算第 n 天兔子的数量
     * @description
     * @author HelloWorld
     * @create 2022/8/8 22:13
     * @param n
     * @return int
     */
    private static long getRabbitNum(int n) {
        // 大兔子：每个月都能生一只小兔子
        long rabbitOld = 0;
        // 年轻兔子：一个月后会生一只小兔子，并成为大兔子
        long rabbitYoung = 0;
        // 小兔子：一个月后会成为年轻兔子
        long rabbitChild = 1;
        while (n-- > 1) {
            // 每个月新出生的兔子数量 = 大兔子 + 年轻兔子
            long rabbitBirth = rabbitOld + rabbitYoung;
            // 每个月也总有小兔子成为年轻兔子，年轻兔子成为大兔子
            rabbitOld += rabbitYoung;
            rabbitYoung = rabbitChild;
            // 新出生兔子成长为小兔子
            rabbitChild = rabbitBirth;
        }

        return rabbitChild + rabbitYoung + rabbitOld;
    }
}
