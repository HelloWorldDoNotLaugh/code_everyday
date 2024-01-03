package com.wy.leetcode;

/**
 * @author HelloWorld
 * @date 2023/10/30 19:08
 * @email helloworld.dng@gmail.com
 */
public class L275 {
    public int hIndex(int[] citations) {
        // 在区间 [left, right] 内询问
        int n = citations.length;
        int left = 1;
        int right = n;
        while (left <= right) { // 区间不为空
            // 循环不变量：
            // left-1 的回答一定为「是」
            // right+1 的回答一定为「否」
            int mid = (left + right) >>> 1;
            // 引用次数最多的 mid 篇论文，引用次数均 >= mid
            if (citations[n - mid] >= mid) {
                left = mid + 1; // 询问范围缩小到 [mid+1, right]
            } else {
                right = mid - 1; // 询问范围缩小到 [left, mid-1]
            }
        }
        // 循环结束后 right 等于 left-1，回答一定为「是」
        // 根据循环不变量，right 现在是最大的回答为「是」的数
        return right;
    }

}
