package com.wy.algo.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhangyuyang
 * @create 2024/2/12 09:37
 */
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        // 如果为空，直接返回
        if (null == root) {
            return new ArrayList<>();
        }

        // 如果有左子树，先遍历出所有左子树
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
        }

        return null;
    }
}
