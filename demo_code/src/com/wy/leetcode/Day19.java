package com.wy.leetcode;

import com.wy.leetcode.tree.TreeNode;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/9/6
 */
public class Day19 {

    int result = 0;
    public int sumNums(int n) {
        boolean flag = (n > 1) && sumNums(n - 1) > 0;
        result += n;
        return result;
    }

    /**
     * @description 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
     * @author yuyang.zhang
     * @date 2023/9/6 17:27
     * @param root
     * @param p
     * @param q
     * @return com.wy.leetcode.tree.TreeNode
     *     当前节点是 null 返回 null
     *     当前节点是 p    不用再递归了，直接返回当前节点
     *     当前节点是 q    不用再递归了，直接返回
     *     当前节点是 其他：   pg不在同一侧 返回当前节点
     *                      都在左子树   返回左子树递归结果
     *                      都在右子树   返回递归结果
     *                      都不在
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        if (left != null) {
            return left;
        }

        if (right != null) {
            return right;
        }

        return null;
    }
}
