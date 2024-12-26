package com.wy.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhang Yuyang
 * @create 2024/12/25 13:05
 */
public class L17 {
    String[] letterMap = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }

        char[] path = new char[digits.length()];
        dfs(digits, 0, path, result);
        return result;
    }

    private void dfs(String digits, int index, char[] path, List<String> result) {
        if (index == digits.length()) {
            result.add(new String(path));
            return;
        }

        String letter = letterMap[digits.charAt(index) - '0'];
        for (char c : letter.toCharArray()) {
            path[index] = c;
            dfs(digits, index + 1, path, result);
        }
    }

}
