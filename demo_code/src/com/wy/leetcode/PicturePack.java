package com.wy.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author HelloWorld
 * @create 2022/8/4 20:58
 * @email helloworld.dng@gmail.com
 */
public class PicturePack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.next();

        PicturePack picturePack = new PicturePack();
        System.out.println(picturePack.sort(inputStr));
    }

    private String sort(String inputStr) {
        String result = "";
        char[] charArray = inputStr.toCharArray();
        Arrays.sort(charArray);
        for (int i = 0; i < charArray.length; i++) {
            result += charArray[i];
        }
        return result;
    }

}
