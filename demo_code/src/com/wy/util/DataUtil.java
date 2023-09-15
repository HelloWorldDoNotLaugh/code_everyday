package com.wy.util;

import java.util.ArrayList;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/9/15
 */
public class DataUtil {
    public static int[][] getDouArray(String data) {
        ArrayList<int[]> list = new ArrayList<>();
        for (String s : data.split("],")) {
            String[] strings = s.replace("[", "").replace("]", "").split(",");
            int[] ints = {Integer.parseInt(strings[0]), Integer.parseInt(strings[1])};
            list.add(ints);
        }

        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
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
