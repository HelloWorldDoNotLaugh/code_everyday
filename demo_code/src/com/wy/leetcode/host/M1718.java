package com.wy.leetcode.host;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyuyang
 * @create 2024/7/10 16:18
 */
@Slf4j
public class M1718 {
    public int[] shortestSeq(int[] big, int[] small) {
        if (small.length > big.length) {
            return new int[0];
        }
        Map<Integer, Integer> window = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int value : small) {
            countMap.put(value, countMap.getOrDefault(value, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int [] res = new int[0];
        while (right < big.length) {
            window.put(big[right], window.getOrDefault(big[right], 0) + 1);
            while (contains(window, countMap)) {
                if (minLen > (right - left + 1)) {
                    minLen = right - left + 1;
                    res = new int[2];
                    res[0] = left;
                    res[1] = right;
                }
                window.put(big[left], window.getOrDefault(big[left], 0) - 1);
                left++;
            }

            right++;
        }

        return res;
    }

    private boolean contains(Map<Integer, Integer> window, Map<Integer, Integer> countMap) {
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            Integer key = entry.getKey();
            if (!window.containsKey(key)) {
                return false;
            }
            if (window.get(key) < entry.getValue()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        M1718 m1718 = new M1718();
        int[] big = {7,5,9,0,2,1,3, 5,7,9,1 ,1,5,8,8,9,7};
        int[] small = {1,5,9};

        System.out.println(JSON.toJSONString(m1718.shortestSeq(big, small)));
    }
}
