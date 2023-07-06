package com.wy.leetcode;

import java.util.Scanner;

/**
 * @author HelloWorld
 * @create 2022/8/2 22:06
 * @email helloworld.dng@gmail.com
 */
public class SubPassword {

    /* 华为机试 HJ32 密码截取 */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(doSubPassword(str.toCharArray()));
    }

    /**
     * @description 密码截取
     * @author HelloWorld
     * @create 2022/8/2 22:06
     * @param
     * @return java.lang.String
     */
    private static int doSubPassword(char[] charArray) {
        /*
            主要分为 ABA 和 ABBA 两种，但是无论处理哪种，都一定从第二个字符开始
        */
        int maxCount = 0;
        for (int i = 1; i < charArray.length - 1; i++) {
            int right = i -1, left = i + 1;
            int countABA = 1, countABBA = 2;
            countABA += countLength(right, left, charArray);
            // 判断是什么类型
            if (charArray[i] == charArray[i+1]) {
                // ABBA
                left = i + 2;
                countABBA +=  countLength(right, left, charArray);
            }else {
                countABBA = 0;
            }
            // 如果既符合ABA，又符合ABBA则取一个最大的
            int matchCount = countABA > countABBA ? countABA : countABBA;
            maxCount = maxCount >  matchCount ? maxCount : matchCount;

        }
        return maxCount;
    }

    /**
     * @description 判断charArray[right] 是否等于 charArray[left]
     * @author HelloWorld
     * @create 2022/8/2 22:33
     * @param right
     * @param left
     * @param charArray
     * @return int
     */
    private static int countLength(int right, int left, char[] charArray) {
        int count = 0;
        while (right >=0 && left <= charArray.length - 1) {
            if (charArray[right] == charArray[left]) {
                count += 2;
                // 指针移动
                right--;
                left++;
            } else {
                break;
            }
        }
        return count;
    }
}
