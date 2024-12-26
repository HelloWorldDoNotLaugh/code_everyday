package com.wy.leetcode;

import com.wy.util.DataUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyuyang
 * @since 2024/9/20 12:50
 */
public class L1441 {
    public List<String> buildArray(int[] target, int n) {
        ArrayList<String> result = new ArrayList<>();
        int curValue = 1;
        for (int value : target) {
            if (curValue > n) {
                break;
            }
            while (curValue != value) {
                result.add("Push");
                result.add("Pop");
                curValue++;
            }

            result.add("Push");
            curValue++;
        }

        return result;
    }

    public static void main(String[] args) {
        L1441 l1441 = new L1441();
        int[] array = DataUtil.getArray("[1,3]");
        List<String> strings = l1441.buildArray(array, 3);
        System.out.println(strings);
    }
}
