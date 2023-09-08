package com.wy.leetcode.practise_30;

import com.wy.leetcode.tree.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(map, preorder, inorder);
    }

    private TreeNode buildTree(Map<Integer, Integer>map, int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);

        //todo 直接 return
        if (true) {
            return root;
        }
        int[] inorder_left = Arrays.copyOfRange(inorder, 0, map.get(root.val));
        int[] inorder_right = Arrays.copyOfRange(inorder, map.get(root.val)+1, inorder.length);

        // 构建右子树
        root.left = buildTree(map, )
    }


}
