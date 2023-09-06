package com.wy.leetcode.practise_30;

import com.wy.leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/9/6
 */
public class Day18 {
    int maxDepth = 0;

    /**
     * @description 剑指 Offer 55 - I. 二叉树的深度
     * @author yuyang.zhang
     * @date 2023/9/6 16:26
     * @param root
     * @return int
     */
    public int maxDepth(TreeNode root) {
        calDepth(root, 0);
        return maxDepth;
    }

    private int calDepth(TreeNode node, int depth) {
        if (node == null) {
            maxDepth = Math.max(depth, maxDepth);
            return maxDepth;
        }

        int leftChildDepth = calDepth(node.left, depth + 1);
        int rightChildDepth = calDepth(node.right, depth + 1);

        return Math.max(leftChildDepth, rightChildDepth);
    }

    /**
     * @description 非递归实现求树最大深度
     * @author yuyang.zhang
     * @date 2023/9/6 16:28
     * @param root
     * @return int
     */
    public int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                addQueueIfNotNull(node.left, queue);
                addQueueIfNotNull(node.right, queue);
            }

            depth++;
        }

        return depth;
    }

    private void addQueueIfNotNull(TreeNode node, Queue<TreeNode> queue) {
        if (null != node) {
            queue.add(node);
        }
    }


    /**
     * @description 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * @author yuyang.zhang
     * @date 2023/9/6 17:04
     * @param root
     * @return boolean
     */
    public boolean isBalanced(TreeNode root) {
        return calTreeDepth(root) != -1;
    }

    private int calTreeDepth(TreeNode node) {
        if (null == node) {
            return 0;
        }

        int leftChildDepth = calTreeDepth(node.left);
        if (leftChildDepth == -1) {
            return -1;
        }

        int rightChildDepth = calTreeDepth(node.right);
        if (rightChildDepth == -1) {
            return -1;
        }

        if (Math.abs(leftChildDepth - rightChildDepth) > 1) {
            return -1;
        }

        return Math.max(rightChildDepth, leftChildDepth) + 1;
    }

}
