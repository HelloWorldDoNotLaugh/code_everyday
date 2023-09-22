package com.wy.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/9/15
 */
public class DataUtil {
    public static int[][] getDouArray(String data) {
        List<List<Integer>> list = new ArrayList<>();
        for (String s : data.split("],")) {
            List<Integer> integers = Arrays.stream(s.replace("[", "").replace("]", "").split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            list.add(integers);
        }

        int[][] result = new int[list.size()][list.get(0).size()];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(0).size(); j++) {
                result[i][j] = list.get(i).get(j);
            }
        }

        return result;
    }

    public static int[] getArray(String data) {
        String[] split = data.replace("[", "").replace("]", "").split(",");
        int[] result = new int[split.length];

        int index = 0;
        for (String s : split) {
            result[index++] = Integer.parseInt(s.trim());
        }

        return result;
    }
}
