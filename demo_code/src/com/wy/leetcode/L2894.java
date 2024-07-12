package com.wy.leetcode;

public class L2894 {
    public int differenceOfSums(int n, int m) {
        return sumDivNumbers(n, m, false) - sumDivNumbers(n, m, true);
    }

    private int sumDivNumbers(int num, int divisor, boolean ifDivisor) {
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            if (divByRule(i, divisor, ifDivisor)) {
                sum += i;
            }
        }
        return sum;
    }

    private boolean divByRule(int n, int m, boolean isDivisor) {
        if (isDivisor) {
            return n % m == 0;
        }

        return n % m != 0;
    }
    public static void main(String[] args) {
        System.out.println(new L2894().differenceOfSums(5, 6));
    }

}
