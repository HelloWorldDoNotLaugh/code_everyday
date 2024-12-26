package com.wy.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        dfs(root, targetSum, path, result);
        return result;
    }

    private void dfs (TreeNode root, int sum, LinkedList<Integer> path, List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        path.add(root.val);
        sum -= root.val;

        if (sum == 0 && root.left == null && root.right == null) {
            result.add(new LinkedList<>(path));
        }

        dfs(root.left, sum, path, result);
        dfs(root.right, sum, path, result);

        path.removeLast();
    }
}
