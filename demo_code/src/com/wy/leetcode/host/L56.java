package com.wy.leetcode.host;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * @author zhangyuyang
 * @create 2024/7/24 12:49
 */
public class L56 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{};
        }

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }

            return a[1] - b[1];
        });

        ArrayList<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length - 1; i++) {
            int[] pre = intervals[i];
            int[] next = intervals[i + 1];

            if (next[0] >= pre[0]) {
                next[0] = pre[0];
            }

            if (next[1] <= pre[1]) {
                next[1] = pre[1];
            }

            result.add(next);
        }

        dealLast(intervals, result);

        return result.toArray(new int[result.size()][]);
    }

    private void dealLast(int[][] intervals, ArrayList<int[]> result) {
        int[] pre = result.get(result.size() - 1);
        int[] last = intervals[intervals.length - 1];

        if (pre[1] < last[1]) {
            result.add(last);
        }
    }

    public static void main(String[] args) {
        Map<String, String> map = null;

        System.out.println(map.getOrDefault("1", "1"));
    }
}
