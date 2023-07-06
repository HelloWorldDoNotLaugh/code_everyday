package com.wy.huaiwei;

import java.util.Scanner;

/**
 * @author HelloWorld
 * @create 2023/7/6 17:29
 * @email helloworld.dng@gmail.com
 */
public class HJ40 {
    private static void countCharacter(String str) {
        int numCount = 0;
        int engCount = 0;
        int spaCount = 0;
        int otherCount = 0;

        str = str.toLowerCase();

        for (char c : str.toCharArray()) {
            if (c - '9' <= 0 && c - '0' >= 0) {
                // 数字
                numCount++;
            } else if (c - 'a' >= 0 && c - 'z' <= 0) {
                // 英文字母
                engCount++;
            } else if (c == ' ') {
                // 空格
                spaCount++;
            } else {
                otherCount++;
            }
        }

        System.out.println(engCount);
        System.out.println(spaCount);
        System.out.println(numCount);
        System.out.println(otherCount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        countCharacter(str);
    }
}
