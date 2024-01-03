package com.wy.leetcode;

/**
 * @author HelloWorld
 * @date 2023/11/8 22:21
 * @email helloworld.dng@gmail.com
 */
public class L2609 {
    public int findTheLongestBalancedSubstring(String s) {
        int result = 0;
        char[] charArray = s.toCharArray();
        int i = 0;
        while (isValidIndex(i, charArray.length-1)) {
            if (charArray[i] != '0') {
                i++;
                continue;
            }

            int zeroCount = 0;
            while (isValidIndex(i, charArray.length-1) && charArray[i] == '0') {
                zeroCount++;
                i++;
            }

            int oneCount = 0;
            while (isValidIndex(i, charArray.length-1) && charArray[i]== '1') {
                oneCount++;
                i++;
            }

            result = Math.max(result, Math.min(zeroCount, oneCount) * 2);
        }

        return result;
    }

    private boolean isValidIndex(int index, int lastIndex) {
        return index <= lastIndex;
    }

    public static void main(String[] args) {
        System.out.println(new L2609().findTheLongestBalancedSubstring("0001101000111"));
    }
}
