package com.wy.leetcode.tree;

/**
 * @author zhangyuyang
 * @since 2024/12/17 13:29
 */
public class L112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.right == null && root.left == null) {
            return root.val == targetSum;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
