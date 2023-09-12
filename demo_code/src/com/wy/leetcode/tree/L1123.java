package com.wy.leetcode.tree;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/9/6
 *
 * 1123. 最深叶节点的最近公共祖先
 */
public class L1123 {
    private TreeNode result;
    private int maxDepth = -99;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        return result;
    }


    private int dfs(TreeNode node, int depth) {
        if (null == node) {
            maxDepth = Math.max(depth, maxDepth);
            return depth;
        }
        int leftChildDepth = dfs(node.left, depth+1);
        int rightChildDepth = dfs(node.right, depth+1);

        if (leftChildDepth == rightChildDepth && leftChildDepth == maxDepth) {
            result = node;
        }

        return Math.max(leftChildDepth, rightChildDepth);
    }

}
