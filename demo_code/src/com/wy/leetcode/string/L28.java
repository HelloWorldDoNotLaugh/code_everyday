package com.wy.leetcode.string;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/9/6
 */
public class L28 {
    public int strStr(String haystack, String needle) {
        char[] haystackCharArray = haystack.toCharArray();
        char[] needleCharArray = needle.toCharArray();

        for (int i = 0; i < haystackCharArray.length; i++) {
            int indexA = i;
            boolean matchFlag = true;
            for (int j = 0; j < needleCharArray.length && indexA < haystackCharArray.length; j++) {
                if (needleCharArray[j] != haystackCharArray[indexA]) {
                    matchFlag = false;
                    break;
                }
                indexA++;
            }
            if (matchFlag) {
                return i;
            }
        }

        return -1;
    }
}
