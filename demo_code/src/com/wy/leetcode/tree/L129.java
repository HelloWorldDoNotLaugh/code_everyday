package com.wy.leetcode.tree;

public class L129 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root,  int num) {
        if (root == null) {
            return 0;
        }

        num = num * 10 + root.val;
        if (root.left == null && root.right == null) {
            return num;
        }

        return dfs(root.left, num) + dfs(root.right, num);
    }
}
