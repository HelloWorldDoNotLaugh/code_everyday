package com.wy.leetcode;

import java.util.ArrayList;

/**
 * @author HelloWorld
 * @create 2022/2/22 19:22
 * @email helloworld.dng@gmail.com
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = new int[]{9, 9, 9, 9};
        for (int i : PlusOne.plusOne(digits)) {
            System.out.print(i);
        }

    }
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        // 全为9
        int[] temp = new int[digits.length + 1];
        temp[0] = 1;
        return temp;
    }
}
