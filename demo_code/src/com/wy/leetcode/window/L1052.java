package com.wy.leetcode.window;

/**
 * @author zhangyuyang
 * @since 2024/9/26 12:48
 */
public class L1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int windowCustomerNum = 0;
        int windowCustomerNumIfCalm = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                windowCustomerNum += customers[i];
            }

            windowCustomerNumIfCalm += customers[i];
        }

        int maxNum = windowCustomerNumIfCalm - windowCustomerNum;
        int maxLeft = 0;
        int left = 0;
        for (int right = minutes; right < customers.length; right++) {
            // 滑动窗口
            windowCustomerNumIfCalm -= customers[left];
            windowCustomerNumIfCalm += customers[right];

            if (grumpy[left] == 1) {
                windowCustomerNum -= customers[left];
            }

            if (grumpy[right] == 1) {
                windowCustomerNum += customers[right];
            }

            left++;
            if (maxNum < windowCustomerNumIfCalm - windowCustomerNum) {
                maxNum = windowCustomerNumIfCalm - windowCustomerNum;
                maxLeft = left;
            }
        }

        int result = 0;
        for (int i = 0; i < customers.length; i++) {
            if (i >= maxLeft && i < maxLeft + minutes) {
                // 老板能控制情绪
                grumpy[i] = 1;
            }

            if (grumpy[i] == 1) {
                result += customers[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        L1052 l1052 = new L1052();
        System.out.println(l1052.maxSatisfied(new int[]{1,0,1,2,1,1,7,5}, new int[]{0,1,0,1,0,1,0,1}, 3));
    }
}
