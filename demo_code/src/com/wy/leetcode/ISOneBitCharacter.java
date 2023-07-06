package com.wy.leetcode;

/**
 * @author HelloWorld
 * @create 2022/2/20 18:18
 * @email helloworld.dng@gmail.com
 */
public class ISOneBitCharacter {
    public static void main(String[] args) {
        int[] bites = {1, 1, 0};
        System.out.println(new ISOneBitCharacter().isOneBitCharacter(bites));
    }

    public boolean isOneBitCharacter(int[] bits) {
        int start = 0;
        while (start < bits.length - 1) {
            if (bits[start] == 0) {
                start++;
            } else {
                start += 2;
            }
        }

        return start == bits.length - 1;
    }
}