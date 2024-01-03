package com.wy;


import java.util.Arrays;
import java.util.List;

/**
 * @author HelloWorld
 * @date 2023/11/7 13:07
 * @email helloworld.dng@gmail.com
 */
public class L2586 {
    public int vowelStrings(String[] words, int left, int right) {
        int result = 0;
        List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u');
        for (int i = left; i <= right; i++) {
            String word = words[i];
            char head = word.charAt(0);
            char tail = word.charAt(word.length() - 1);
            if (list.contains(head) && list.contains(tail)) {
                result++;
            }
        }

        return result;
    }
}
