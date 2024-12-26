package com.wy.leetcode.tree;

import cn.hutool.json.JSON;

import java.util.ArrayList;
import java.util.List;

public class L257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        String path = "";
        dfs(root, path, result);
        return result;
    }

    private void dfs(TreeNode root, String path, List<String> result) {
        if (root == null) {
            return;
        }

        if (path.isEmpty()) {
            path = root.val + "";
        } else {
            path = path + "->" + root.val;
        }

        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }

        dfs(root.left, path, result);
        dfs(root.right, path, result);
    }

    public static void main(String[] args) {
        L257 l257 = new L257();
        TreeNode init = TreeNode.init(1, 2, 3, null, 5);
        List<String> result = l257.binaryTreePaths(init);
        System.out.println(result);
    }
}
