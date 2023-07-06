package com.wy.leetcode.search;

/**
 * @author HelloWorld
 * @create 2023/4/5 16:42
 * @email helloworld.dng@gmail.com
 */
public class L704 {
    private int TARGET_VALUE;
    private int[] NUMS;
    public int search(int[] nums, int target) {
        NUMS = nums;
        TARGET_VALUE = target;
        return binarySearch();
    }

    private int binarySearch(int start, int end) {
        if (start > end) {
            return -1;
        }
        int currentIndex = (start+end) / 2;
        int now = NUMS[currentIndex];

        if (now == TARGET_VALUE) {
            return currentIndex;
        }

        if (now > TARGET_VALUE) {
            return binarySearch(start, currentIndex-1);
        }

        return binarySearch(currentIndex+1, end);
    }

    private int binarySearch() {
        int start = 0;
        int end = NUMS.length - 1;
        while (start < end) {
            int current = end + (start - end) / 2;
            if (NUMS[current] == TARGET_VALUE) {
                return current;
            } else if (NUMS[current] > TARGET_VALUE) {
                end = current - 1;
            } else {
                start = current + 1;
            }
        }
        // 未查到
        return -1;
    }

    public static void main(String[] args) {
        L704 l704 = new L704();
        int target = 19;
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int index = l704.search(nums, target);
        System.out.println(index);
    }
}
