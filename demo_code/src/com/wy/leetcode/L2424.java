package com.wy.leetcode;

import org.testng.annotations.Test;
public class L2424 {
    class LUPrefix {
        private int maxPrefix;
        private int[] array;
        public LUPrefix(int n) {
            array = new int[n];
            maxPrefix = 0;
        }

        public void upload(int video) {
            array[video - 1] = 1;

            while (maxPrefix <= array.length - 1 && array[maxPrefix] != 0) {
                maxPrefix++;
            }
        }

        public int longest() {
            return maxPrefix;
        }

    }

    @Test
    public void test() {
        LUPrefix luPrefix = new LUPrefix(4);
        luPrefix.upload(3);
        System.out.println(luPrefix.longest());
        luPrefix.upload(1);
        System.out.println(luPrefix.longest());
        luPrefix.upload(2);
        System.out.println(luPrefix.longest());
    }
}

