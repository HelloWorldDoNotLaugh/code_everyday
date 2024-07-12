package com.wy.leetcode;


import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangyuyang
 * @create 2024/3/22 13:28
 */
public class L467 {
    public static void main(String[] args) {
        L467 l467 = new L467();
        List<Integer> anagrams = l467.findAnagrams("bababa", "ab");
        System.out.println(JSON.toJSONString(anagrams));
    }
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen) {
            return new ArrayList<>();
        }

        // 维护一个窗口
        int[] window = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++window[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }
        List<Integer> result = new ArrayList<>();
        if (Arrays.equals(window, pCount)) {
            result.add(0);
        }

        for (int i = 0; i < sLen - pLen; i++) {
            // 窗口弹出一个元素，因为前 plen个元素已经统计了
            --window[s.charAt(i) - 'a'];
            // 将下一个元素放入窗口
            ++window[s.charAt(i + pLen) - 'a'];
            if (Arrays.equals(window, pCount)) {
                result.add(i + 1);
            }
        }

        return result;
    }

    public List<Integer> findAnagramsTemplate(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<>();
        }

        List<Integer> ans = new ArrayList<>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        // 统计 s，p 中每个字符的个数 => 理解的不对，这里实际上是维护了一个 窗口，并统计 p 中的字符。
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        // todo 为什么是 slen - plen => 因为在 S 中，减去前 slen-plen 的字符，剩下的部分一定不是 p 的子串
        for (int i = 0; i < sLen - pLen; ++i) {
            // todo 将当前字符减去，可以理解，但是下一步为什么是 i + plen => 因为 sCount 中一开时维护的窗口就是 plen 的长度，i 从 0 开始，i+len 刚好就是下一个字符的位置
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            // 为什么还可以通过比较两个数组是否相等判定子串？=> 要理解此处的 sCount，它恰好就是一个窗口，这个窗口很巧妙
            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }
}
