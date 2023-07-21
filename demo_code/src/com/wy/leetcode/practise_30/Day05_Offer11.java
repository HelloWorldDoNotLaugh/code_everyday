package com.wy.leetcode.practise_30;

/**
 * @author HelloWorld
 * @date 2023/7/21 06:45
 * @email helloworld.dng@gmail.com
 */
public class Day05_Offer11 {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            // 恒有 left <= mid < right
            int mid = (right + left) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                right--;
            }
        }

        return numbers[right];
    }

    public static void main(String[] args) {
        Day05_Offer11 day05Offer11 = new Day05_Offer11();
        System.out.println(day05Offer11.minArray(new int[]{3, 1, 3}));
    }

}
