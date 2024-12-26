package com.wy.leetcode.tree;

/**
 * @author zhangyuyang
 * @since 2024/12/16 13:03
 */
public class L104 {
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(dfs(root.left), dfs(root.right)) + 1;
    }
}
