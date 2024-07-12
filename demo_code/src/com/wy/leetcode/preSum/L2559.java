package com.wy.leetcode.preSum;

import com.alibaba.fastjson.JSON;
import com.wy.util.DataUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhangyuyang
 * @create 2024/6/4 12:47
 */
public class L2559 {
    private static final List<Character> VOWEL_LIST = Arrays.asList('a', 'e', 'i', 'o', 'u');
    private int[] preSum;

    public int[] vowelStrings(String[] words, int[][] queries) {
        initPreSum(words);

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int right = queries[i][1] + 1;
            int left = queries[i][0];

            result[i] = preSum[right] - preSum[left];
        }

        return result;
    }

    private void initPreSum(String[] words) {
        preSum = new int[words.length+1];
        preSum[0] = 0;

        for (int i = 0; i < words.length; i++) {
            char[] charArray = words[i].toCharArray();
            if (VOWEL_LIST.contains(charArray[0]) && VOWEL_LIST.contains(charArray[charArray.length-1])) {
                preSum[i+1] = preSum[i] + 1;
            } else{
                preSum[i+1] = preSum[i];
            }
        }
    }

    public static void main(String[] args) {
        L2559 l2559 = new L2559();
        String[] words = {"aba","bcb","ece","aa","e"};
        int[][] queries = DataUtil.getDouArray("[[0,2],[1,4],[1,1]]");

        System.out.println(JSON.toJSONString(l2559.vowelStrings(words, queries)));
    }
}
