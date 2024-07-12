package com.wy.leetcode.tree;

/**
 * @author zhangyuyang
 * @create 2024/4/11 12:38
 */
public class L105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length <= 0 || inorder.length <= 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        int index = findIndex(inorder, root.val, 0, inorder.length - 1);
        int leftChildNums = Math.max(index - 1, 0);
        root.left = buildTree(preorder, index+1, index+leftChildNums, inorder, 0, leftChildNums);
        root.right = buildTree(preorder, index+leftChildNums+1, preorder.length - 1, inorder, index+1, inorder.length - 1);
        return root;
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[preStart]);
        int index = findIndex(inorder, node.val, inStart, inEnd);
        int leftChildNums = Math.max(index - 1, 0);
        node.left = buildTree(preorder, preStart+1, preStart+leftChildNums, inorder, inStart, index-1);
        node.right = buildTree(preorder, preStart+leftChildNums+1, preEnd, inorder, index+1, inEnd);

        return node;
    }

    private int findIndex(int[] inorder, int value, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == value) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode treeNode = new L105().buildTree(preorder, inorder);
        System.out.println(TreeNode.preOrderTraversal(treeNode));
    }
}
