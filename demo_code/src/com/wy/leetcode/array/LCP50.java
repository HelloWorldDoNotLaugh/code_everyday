package com.wy.leetcode.array;

import com.wy.util.DataUtil;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/9/15
 */
public class LCP50 {
    public int giveGem(int[] gem, int[][] operations) {
        for (int[] operation : operations) {
            int giver = operation[0];
            int accepter = operation[1];
            int giveNum = gem[giver] / 2;

            gem[giver] = gem[giver] - giveNum;
            gem[accepter] = gem[accepter] + giveNum;
        }

        int max = -1;
        int min = Integer.MAX_VALUE;

        for (int i : gem) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        return max - min;
    }

    public static void main(String[] args) {
        LCP50 lcp50 = new LCP50();
        System.out.println(lcp50.giveGem(new int[]{100,0,50,100}, DataUtil.getDouArray("[[0,2],[0,1],[3,0],[3,0]]")));
    }
}
