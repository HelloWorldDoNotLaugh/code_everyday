package com.wy.leetcode;

import com.wy.util.DataUtil;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author HelloWorld
 * @date 2023/10/29 16:23
 * @email helloworld.dng@gmail.com
 */
public class L274 {
    public int hIndex(int[] citations) {
        // 使用自定义的Comparator进行从大到小排序
        Arrays.sort(citations);
        int nums = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] > nums) {
                nums++;
            } else {
                break;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        L274 l274 = new L274();

        System.out.println(l274.hIndex(DataUtil.getArray("[3,0,6,1,5]")));
    }
}