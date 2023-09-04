package com.wy.mycode.algorithm.string;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/8/28
 */
public class MinEditCost {

    public int solution(String str1, String str2, int ic, int dc, int rc) {
        int modifyCost = Math.min(ic + dc, rc);
        int length = Math.min(str1.length(), str2.length());
        int result = 0;
        for (int i = 0; i < length; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                result += modifyCost;
            }
        }

        if (str2.length() > str1.length()) {
            result += (str2.length() - str1.length()) * ic;
        }

        if (str1.length() > str2.length()) {
            result += (str1.length() - str2.length()) * dc;
        }
        return result;
    }


    public static void main(String[] args) {
        MinEditCost minEditCost = new MinEditCost();
        System.out.println(minEditCost.solution("aebdc", "abc", 5, 3, 100));
    }
}
