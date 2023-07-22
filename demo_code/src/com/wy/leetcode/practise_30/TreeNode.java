package com.wy.leetcode.practise_30;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/7/21
 */
public class TreeNode {
    public int val;
    public TreeNode left;

    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }



    /**
     * @description 根据层次遍历的结果还原二叉树
     *  层次遍历结果：3,9,20,null,null,15,7
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * @author HelloWorld
     * @create 2023/7/22 09:16
     * @param values
     * @return com.wy.leetcode.practise_30.TreeNode
     */
    public static TreeNode init(Integer ...values) {
        TreeNode root = new TreeNode(values[0]);

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);

        int i = 1;
        while (!treeNodeQueue.isEmpty() && i < values.length) {
            TreeNode treeNode = treeNodeQueue.poll();
            // 左孩子是否存在
            if (values[i] != null) {
                treeNode.left = new TreeNode(values[i]);
                treeNodeQueue.add(treeNode.left);
            }
            i++;

            if (i < values.length && values[i] != null) {
                treeNode.right = new TreeNode(values[i]);
                treeNodeQueue.add(treeNode.right);
            }

            i++;
        }

        return root;
    }

    public static List<Integer> levelOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            result.add(treeNode.val);
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            } else {
                result.add(null);
            }

            if (treeNode.right != null) {
                queue.add(treeNode.right);
            } else {
                result.add(null);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode node = init(3, 9, 20, null, null, 15, 7);
        List<Integer> integers = levelOrderTraversal(node);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
