package com.wy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyuyang
 * @since 2024/10/10 14:02
 */
public class L763 {
    public List<Integer> partitionLabels(String s) {
        int[] lastIndexArray = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndexArray[getIndex(s.charAt(i))] = i;
        }

        ArrayList<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndexArray[getIndex(s.charAt(i))]);
            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }

        return result;
    }

    private static Integer getIndex(Character character) {
        return character - 'a';
    }

    public static void main(String[] args) {
        L763 l763 = new L763();
        System.out.println(l763.partitionLabels("adbabcbacadefegdehijhklij"));
    }
}
