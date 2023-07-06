package com.wy.leetcode.array.doubleprint;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class L349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        int point1 = 0;
        int point2 = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        while (point1 < nums1.length && point2 < nums2.length) {
            if (nums1[point1] == nums2[point2]) {
                set.add(nums1[point1]);
                point1++;
                point2++;
            } else if (nums1[point1] > nums2[point2]) {
                point2++;
            } else {
                point1++;
            }
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        L349 l349 = new L349();
        int[] ints = {4, 9, 5};
        int[] ints1 = {9,4,9,8,4};

        System.out.println(l349.intersection(ints1, ints));
    }
}
