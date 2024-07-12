package com.wy.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;

public class L2744 {
    public int maximumNumberOfStringPairs(String[] words) {
        HashSet<String> rightHalfWordsSet = new HashSet<>(Arrays.asList(words));

        int result = 0;
        for (int i = 0; i < words.length; i++) {
            String reversedWord = new StringBuffer(words[i]).reverse().toString();
            if (rightHalfWordsSet.contains(reversedWord)) {
                result++;
            }
        }
        return result / 2;
    }


    public static void main(String[] args) {
        String[] words = {"cd", "ac", "dc", "ca", "zz", "qq"};
        L2744 l2744 = new L2744();
        System.out.println(l2744.maximumNumberOfStringPairs(words));
    }

}
