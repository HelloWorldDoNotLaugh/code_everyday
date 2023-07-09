package com.wy.huaiwei;

import java.util.Scanner;

public class HJ42 {
    private static final String[] NUM_TO_ENGLISH = {"zero", "one", "two", "three", "four", "five", "six", "seven",
            "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen", "twenty"};
    private static final String[] TENS_TO_ENGLISH = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private static final String[] BIT_TO_ENGLISH = {"", "thousand", "million", "billion"};


    private static String switchToEnglish(long num) {
        if (num == 0) {
            return NUM_TO_ENGLISH[0];
        }

        StringBuilder result = new StringBuilder();
        int bitCount = 0;

        while (num > 0) {
            // 每三位一分离
            long n = num % 1000;

            if (n != 0) {
                StringBuilder tempResult = new StringBuilder();

                long doubleDigit = n % 100;
                if (doubleDigit > 0 && doubleDigit <= 20) {
                    tempResult.append(NUM_TO_ENGLISH[(int)doubleDigit]);
                } else {
                    long unitsDigit = n % 10;
                    long tensDigit = (n / 10) % 10;
                    if (unitsDigit != 0) {
                        tempResult.append(NUM_TO_ENGLISH[(int) unitsDigit]);
                    }
                    if (tensDigit != 0) {
                        if (tempResult.length() > 0) {
                            tempResult.insert(0, " ");
                        }
                        tempResult.insert(0, TENS_TO_ENGLISH[(int) tensDigit]);
                    }
                }

                long hundredsDigit = (n / 100) % 10;
                if (hundredsDigit != 0) {
                    if (tempResult.length() > 0) {
                        tempResult.insert(0, " and ");
                    }
                    tempResult.insert(0, NUM_TO_ENGLISH[(int) hundredsDigit] + " hundred");
                }

                tempResult.append(" ").append(BIT_TO_ENGLISH[bitCount]);
                if (result.length() > 0) {
                    tempResult.append(" ");
                }
                result.insert(0, tempResult);
            }

            bitCount++;
            num = num / 1000;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long nums = scanner.nextLong();
        System.out.println(switchToEnglish(nums));
    }
}
