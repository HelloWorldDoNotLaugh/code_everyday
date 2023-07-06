package com.wy.leetcode.search;

import static com.wy.leetcode.search.VersionControl.isBadVersion;

/**
 * @author HelloWorld
 * @create 2023/4/5 18:06
 * @email helloworld.dng@gmail.com
 */
public class L278 {

    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        // 找最后一个未出错的
        while (start < end) {
            int current = start + (end - start) / 2;
            if (isBadVersion(current)) {
                end = current;
            } else {
                start = current + 1;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        System.out.println(new L278().firstBadVersion(2126753390));
    }
}

class VersionControl{
    private static final int bad = 1702766719;
    public static boolean isBadVersion(int version){
        return version >= bad;
    }
}
