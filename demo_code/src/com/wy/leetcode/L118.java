package com.wy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zhangyuyang
 * @since 2024/10/11 13:05
 */
public class L118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 1) {
            result.add(Collections.singletonList(1));
            return result;
        }
        if (numRows == 2) {
            result.add(Arrays.asList(1, 1));
            return result;
        }

        result.add(Collections.singletonList(1));
        result.add(Arrays.asList(1, 1));
        for (int i = 3; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i - 1; j++) {
                int value = result.get(i-2).get(j-1) + result.get(i-2).get(j);
                row.add(value);
            }
            row.add(1);

            result.add(row);
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
