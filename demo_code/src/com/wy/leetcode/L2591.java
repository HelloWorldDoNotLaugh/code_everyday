package com.wy.leetcode;

/**
 * @author HelloWorld
 * @date 2023/9/22 08:28
 * @email helloworld.dng@gmail.com
 */
public class L2591 {
    public int distMoney(int money, int children) {
        if (money < children) {
            return -1;
        }

        // 然后保证每人至少1美元
        money = money - children * 1;

        // 目前每个人都有1美元，再每7美元一分发
        int num = money / 7;
        int balance = money - num * (money / 7);

        if (balance == 4) {
            return num - 1;
        } 

        if (balance == 0) {
            return num;
        }

        return -1;
    }
}
