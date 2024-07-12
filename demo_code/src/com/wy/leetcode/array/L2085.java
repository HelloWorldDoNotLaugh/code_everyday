package com.wy.leetcode.array;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class L2085 {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String, Integer> countHashMap1 = new HashMap<>();
        HashMap<String, Integer> countHashMap2 = new HashMap<>();

        for (String word : words1) {
            countHashMap1.put(word, countHashMap1.getOrDefault(word, 0) + 1);
        }

        for (String word : words2) {
            countHashMap2.put(word, countHashMap2.getOrDefault(word, 0) + 1);
        }

        AtomicInteger result = new AtomicInteger();
        countHashMap1.forEach((key, value) -> {
            if (countHashMap1.get(key) == 1 && countHashMap2.getOrDefault(key, 0) == 1){
                result.getAndIncrement();
            }
        });

        return result.get();
    }

    public static void main(String[] args) {
        String[] words1 = new String[]{"leetcode","is","amazing","as","is"};
        String[] words2 = new String[]{"amazing","leetcode","is"};

        L2085 l2085 = new L2085();
        System.out.println(l2085.countWords(words1, words2));
    }
}
