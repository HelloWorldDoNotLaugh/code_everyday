package com.wy.leetcode;

/**
 * @author HelloWorld
 * @date 2023/9/4 09:21
 * @email helloworld.dng@gmail.com
 */
public class L2240 {
    /*
            假设买了 x 个 cost1，那么能买到的 cost2 的个数一定为：(total-x*cost1)/cost2
    */
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        // 让cost1 为较大的值，减少下文中的遍历次数
        if (cost1 < cost2) {
            int tmp = cost2;
            cost2 = cost1;
            cost1 = tmp;
        }

        long result = 0;
        for (int i = 0; i <= total/cost1; i++) {
            result += (total - i*cost1)/cost2 + 1;
        }

        return result;
    }

    public static void main(String[] args) {
        L2240 l2240 = new L2240();
        System.out.println(l2240.waysToBuyPensPencils(20, 5, 10));
    }


}
