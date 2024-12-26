package com.wy.leetcode.window;

/**
 * @author zhangyuyang
 * @since 2024/9/25 13:01
 */
public class L1652 {
    public int[] decrypt(int[] code, int k) {
        int[] result = new int[code.length];
        if (k == 0) {
            return result;
        }

        if (k > 0) {
            return getPostSum(code, k);
        } else {
            return getPreSum(code, -k);
        }
    }

    private int[] getPostSum(int[] code, int k) {
        int[] result = new int[code.length];
        int left = 1;
        int right = 1;
        int windowSum = 0;
        while (right <= k) {
            windowSum += code[right % code.length];
            right++;
        }
        result[0] = windowSum;
        for (int i = 1; i < code.length; i++) {
            windowSum -= code[left % code.length];
            windowSum += code[right % code.length];
            result[i] = windowSum;
            left++;
            right++;
        }
        return result;
    }

    private int[] getPreSum(int[] code, int k) {
        int[] result = new int[code.length];
        int left = code.length - k;
        int right = code.length - k;

        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += code[right % code.length];
            right++;
        }

        result[0] = windowSum;
        for (int i = 1; i < code.length; i++) {
            windowSum -= code[left % code.length];
            windowSum += code[right % code.length];
            result[i] = windowSum;
            left++;
            right++;
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
