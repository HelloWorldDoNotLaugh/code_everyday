package com.wy.leetcode;


/**
 * @author HelloWorld
 * @create 2023/3/7 21:07
 * @email helloworld.dng@gmail.com
 */
public class L1694 {

    public static void main(String[] args) {
        L1694 l1694 = new L1694();
        System.out.println(l1694.reformatNumber("121-121 -  - - "));
    }

    public String reformatNumber(String number) {
        // 1. 删除 所有的空格和破折号
        number = removeElement(number);
        // 2. 拆分
        number = splitStr(number);
        return number;
    }


    private String removeElement(String str) {
        return str.replace("-", "").replace(" ", "");
    }

    private String splitStr(String str) {
        StringBuilder resultsBuilder = new StringBuilder();
        final int ruleLength = 4;
        while (str.length() > ruleLength) {
            resultsBuilder.append(str, 0, 3).append("-");
            str = str.substring(3);
        }

        if (str.length() == ruleLength) {
            resultsBuilder.append(str, 0, 2).append("-");
            resultsBuilder.append(str, 2, 4);
        } else {
            resultsBuilder.append(str);
        }

        return resultsBuilder.toString();
    }


}
