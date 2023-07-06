package com.wy.leetcode;

/**
 * @author HelloWorld
 * @create 2022/4/15 21:06
 * @email helloworld.dng@gmail.com
 */
public class PrintStar {
    public static void main(String[] args) {
        int n = 31;
        // 上半部分
        for (int i = 1; i <= n; i = i + 2) {
            printStar(i, (n - i) / 2);
        }
        // 下半部分
        for (int i = n - 2; i >= 0; i = i - 2) {
            printStar(i, (n - i) / 2);
        }
    }

    /**
     * @description 拼接字符串  将拼接的结果n个str返回
     * @author HelloWorld
     * @create 2022/4/16 09:04
     * @param str
     * @param n
     * @return java.lang.String
     */
    public static String multiString(String str, int n) {
        String newStr = "";
        for (int i = 0; i < n; i++) {
            newStr += str;
        }
        return newStr;
    }

    /**
     * @description 打印字符串
     * @author HelloWorld
     * @create 2022/4/16 09:05
     * @param starNum
     * @param blankNum
     * @return void
     */
    public static void printStar(int starNum, int blankNum) {
        String star = multiString("*", starNum);
        String blank = multiString(" ", blankNum);
        System.out.println(blank + star + blank);
    }
}
