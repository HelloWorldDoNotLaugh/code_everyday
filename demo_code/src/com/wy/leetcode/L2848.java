package com.wy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author zhangyuyang
 * @since 2024/9/18 12:33
 */
public class L2848 {
    public int numberOfPoints(List<List<Integer>> nums) {
        // 1. 排序
        nums.sort((o1, o2) -> {
            if (!Objects.equals(o1.get(0), o2.get(0))) {
                return o1.get(0) - o2.get(0);
            }

            return o1.get(1) - o2.get(1);
        });

        // 2.合并
        for (int i = 1; i < nums.size(); i++) {
            List<Integer> cur = nums.get(i);
            List<Integer> pre = nums.get(i - 1);
            if (cur.get(0) <= pre.get(1) + 1) {
                cur.set(0, Math.min(pre.get(0), cur.get(0)));
                cur.set(1, Math.max(pre.get(1), cur.get(1)));
                // pre清空
                pre.set(0, -1);
            }
        }

        int count = 0;
        for (List<Integer> num : nums) {
            if (num.get(0).equals(-1)) {
                continue;
            }

            count += num.get(1) - num.get(0) + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        L2848 l2848 = new L2848();
        List<Integer> list0 = Arrays.asList(3, 6);
        List<Integer> list1 = Arrays.asList(1, 5);
        List<Integer> list2 = Arrays.asList(4, 7);
        List<List<Integer>> nums = Arrays.asList(list0, list1, list2);
        System.out.println(l2848.numberOfPoints(nums));
    }
}
