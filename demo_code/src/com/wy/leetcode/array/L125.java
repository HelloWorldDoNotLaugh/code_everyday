package com.wy.leetcode.array;

/**
 * @author HelloWorld
 * @create 2023/4/19 21:53
 * @email helloworld.dng@gmail.com
 */
public class L125 {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();

        while (left < right) {
            char leftChar = chars[left];
            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
                continue;
            }
            char rightChar = chars[right];
            if (!Character.isLetterOrDigit(rightChar)) {
                right--;
                continue;
            }
            if (Character.toLowerCase(rightChar) != Character.toLowerCase(leftChar)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }


    public static void main(String[] args) {
        L125 l125 = new L125();
        System.out.println(l125.isPalindrome("A man, a plan, a canal: Panama"));
    }

}
