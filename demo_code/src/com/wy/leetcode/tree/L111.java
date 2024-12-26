package com.wy.leetcode.tree;

/**
 * @author zhangyuyang
 * @since 2024/12/16 13:08
 */
public class L111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 如果左子树为空, 最小深度即右子树的高度 + 1
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }

        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

}
