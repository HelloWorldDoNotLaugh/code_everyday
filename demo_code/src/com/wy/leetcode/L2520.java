package com.wy.leetcode;

/**
 * @author HelloWorld
 * @date 2023/10/26 21:07
 * @email helloworld.dng@gmail.com
 */
public class L2520 {
    public int countDigits(int num) {
        int tmp = num;
        int result = 0;
        while (tmp > 0){
            int i = tmp % 10;
            if (num % i == 0) {
                result++;
            }
/**/
            tmp /= 10;
        }

        return result;
    }

    public static void main(String[] args) {
        L2520 l2520 = new L2520();
        System.out.println(l2520.countDigits(7));
    }
}
