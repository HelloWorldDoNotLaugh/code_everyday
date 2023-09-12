package com.wy.leetcode.practise_30;

import com.wy.leetcode.tree.TreeNode;

import java.util.Arrays;


/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/9/6
 */
public class Day20 {

    /**
     * @description 剑指 Offer 07. 重建二叉树
     * @author yuyang.zhang
     * @date 2023/9/6 17:59
     * @param preorder
     * @param inorder
     * @return com.wy.leetcode.tree.TreeNode
     *
     *    preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
     *
     *    根据前序遍历的结果可以先确定  3 一定是根节点。
     *    再到中序遍历中可以确定 左子树 9， 右子树 15， 20，7
     *
     *    这个例子中整棵树的左子树就只有 9，所以左子树✅
     *
     *    对于右子树 15 20 7
     *    依据前序遍历：20是根节点，再根据中序确定 15在左子树，7在右子树。
     *
     *    整体思路还是递归，先找根节点，构建左子树，右子树
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length == 1) {
            return root;
        }

        // 找到根节点在中序遍历中的index
        int rootIndex = getRootIndex(inorder, root.val);

        int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] rightInorder = Arrays.copyOfRange(inorder, rootIndex+1, inorder.length);

        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, leftInorder.length+1);
        int[] rightPreorder = Arrays.copyOfRange(preorder, leftInorder.length + 1, preorder.length);

        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);

        return root;
    }

    private int getRootIndex(int[] inorder, int root) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root) {
                return i;
            }
        }

        throw new NullPointerException("Not Found Root");
    }


    public double myPow(double x, int n) {
        if (n == 0 || x == 1) {
            return 1;
        }

        if (n < 0) {
            n = n * -1;
            x = 1 / x;
        }


        double result = 1;
        for (int i = 0; i < n; i++) {
            result = result * x;
        }

        return result;
    }

    public static void main(String[] args) {
        Day20 day20 = new Day20();

        TreeNode treeNode = day20.buildTree(new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1});

        TreeNode.levelOrderTraversal(treeNode);
    }
}
