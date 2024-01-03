package com.wy.leetcode;

/**
 * @author HelloWorld
 * @date 2023/10/24 19:20
 * @email helloworld.dng@gmail.com
 */
public class L1155 {
    private static final int MOD = 1_000_000_007;


    public int numRollsToTarget(int n, int k, int target) {
        if (target < 0 || target > n*k) {
            return 0;
        }

        /*
            假设 n=3，k=6，target=17
            掷第一个：
                假如为1：问题转化为 n=2，k=6 target=16的次数
                假如为2: n=2，k=6, target=15
                ...
            因此：当i个k面的骰子，要掷出n
            则有dfs(i,n)种可能：dfs(i,n)=dfs(i-1,n-1) + dfs(i-1, n-2) + ... + dfs(i-1, n-k)
        */

        return dfs(n, k, target);
    }

    private int dfs(int n, int k, int target) {
        if (k < 0) {
            return 0;
        }

        if (n == 0) {
            return k == 0 ? 1 : 0;
        }

        int res = 0;
        for (int i = 1; i <= k ; i++) {
            res = (res + dfs(i-1, k, target-i)) % MOD;
        }

        return res;
    }
}
