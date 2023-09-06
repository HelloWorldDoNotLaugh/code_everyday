package com.wy.leetcode.practise_30;

import com.wy.leetcode.tree.TreeNode;

import java.util.*;

/**
 * @author HelloWorld
 * @date 2023/7/23 06:55
 * @email helloworld.dng@gmail.com
 */
public class Day07 {

    /**
     * @param A
     * @param B
     * @return boolean
     * @description 剑指 Offer 26. 树的子结构
     * @author HelloWorld
     * @create 2023/7/23 06:56
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        boolean result = false;
        if (null == A || null == B) {
            return result;
        }

        return compare(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean compare(TreeNode A, TreeNode B) {
        if (null == B) {
            return true;
        }
        if (null == A) {
            return false;
        }

        if (A.val != B.val) {
            return false;
        }

        return compare(A.left, B.left) && compare(A.right, B.right);
    }

    /**
     * @description 剑指 Offer 26. 树的子结构 非递归实现
     * @author HelloWorld
     * @create 2023/7/23 10:21
     * @param A
     * @param B
     * @return boolean
     */
    public boolean isSubStructureIter(TreeNode A, TreeNode B) {
        if (null == A || null == B) {
            return false;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(A);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            if (treeNode.val == B.val && compareIter(treeNode, B)) {
                return true;
            }

            addIfNotNull(stack, treeNode.right);
            addIfNotNull(stack, treeNode.left);
        }

        return false;
    }

    private boolean compareIter(TreeNode A, TreeNode B) {
        Stack<TreeNode> stackA = new Stack<>();
        Stack<TreeNode> stackB = new Stack<>();
        stackA.push(A);
        stackB.push(B);

        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            TreeNode treeNodeA = stackA.pop();
            TreeNode treeNodeB = stackB.pop();

            if (null == treeNodeB) {
                continue;
            }

            if (null == treeNodeA || treeNodeA.val != treeNodeB.val) {
                return false;
            }

            stackA.push(treeNodeA.left);
            stackA.push(treeNodeA.right);

            stackB.push(treeNodeB.left);
            stackB.push(treeNodeB.right);
        }

        return true;
    }





    /**
     * @description 二叉树的镜像
     * @author HelloWorld
     * @create 2023/7/23 10:26
     * @param root
     * @return com.wy.leetcode.tree.TreeNode
     *
     *  本质是交换每一层级的左右节点
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (null == root) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                // 交换左右节点
                TreeNode temp = treeNode.left;
                treeNode.left = treeNode.right;
                treeNode.right = temp;

                if (null != treeNode.left) { queue.offer(treeNode.left);}
                if (null != treeNode.right) { queue.offer(treeNode.right);}
            }
        }

        return root;
    }


    /**
     * @description 剑指 Offer 28. 对称的二叉树
     * @author HelloWorld
     * @create 2023/7/23 14:28
     * @param root
     * @return boolean
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queueA = new LinkedList<>();
        Queue<TreeNode> queueB = new LinkedList<>();

        queueA.offer(root.left);
        queueB.offer(root.right);

        while (!queueA.isEmpty() && !queueB.isEmpty()) {
            int size = queueA.size();

            if (size != queueB.size()) {
                return false;
            }

            for (int i = 0; i < size; i++) {
                TreeNode treeNodeA = queueA.poll();
                TreeNode treeNodeB = queueB.poll();
                if (treeNodeB == null && treeNodeA == null) {
                    continue;
                }

                if (treeNodeB == null || treeNodeA == null || treeNodeA.val != treeNodeB.val) {
                    return false;
                }

                queueA.offer(treeNodeA.left);
                queueA.offer(treeNodeA.right);

                queueB.offer(treeNodeB.right);
                queueB.offer(treeNodeB.left);
            }
        }

        return queueA.isEmpty() && queueB.isEmpty();
    }


    private void addIfNotNull(List<TreeNode> list, TreeNode node) {
        if (null != node) {
            list.add(node);
        }
    }

    public static void main(String[] args) {
        Day07 day07 = new Day07();
        System.out.println(day07.isSymmetric(TreeNode.init(9,-42,-42,null,76,76,null,null,13,null,13)));
    }
}
