package com.wy.huaiwei;

import java.util.Scanner;

/**
 * @author HelloWorld
 * @create 2023/7/9 10:03
 * @email helloworld.dng@gmail.com
 */
public class HJ42 {
    private static final String[] NUM_TO_ENGLISH = {"zero", "one", "two", "three", "four", "five", "six", "seven",
            "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen", "twenty"};
    private static final String[] TENS_TO_ENGLISH = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private static final String[] BIT_TO_ENGLISH = {"", "thousand", "million", "billion"};
    private static String switchToEnglish(long num) {
        StringBuilder result = new StringBuilder();
        int bitCount = 0;
        while (num > 0) {
            StringBuilder tempResult = new StringBuilder();
            long n = num % 1000;

            int count = 0;
            while (n > 0) {
                long l = n % 10;
                switch (count) {
                    case 0:
                        if (((n % 100) <= 20) && ((n % 100) > 0)) {
                            l = n % 100;
                            tempResult.append(NUM_TO_ENGLISH[(int) l]);
                            count++;
                            n = n / 10;
                            break;
                        }

                        if (l == 0) {
                            tempResult = new StringBuilder();
                        } else {
                            tempResult = new StringBuilder(NUM_TO_ENGLISH[(int) l]);
                        }
                        break;
                    case 1:
                        if(tempResult.length() > 0 && l != 0) {
                            tempResult.insert(0, " ");
                        }
                        tempResult.insert(0, TENS_TO_ENGLISH[(int) l]);
                        break;
                    case 2:
                        if (tempResult.length() > 0) {
                            tempResult.insert(0, " and ");
                        }
                        tempResult.insert(0, NUM_TO_ENGLISH[(int) l] + " hundred");
                        break;
                    default:break;
                }
                count++;
                n = n / 10;
            }

            tempResult.append(" ").append(BIT_TO_ENGLISH[bitCount]);
            if (result.length() > 0 ) {
                tempResult.append(" ");
            }
            result.insert(0, tempResult);
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
