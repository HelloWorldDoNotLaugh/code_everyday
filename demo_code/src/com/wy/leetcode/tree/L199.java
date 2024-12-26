package com.wy.leetcode.tree;

import java.util.*;

public class L199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> curLevelValue = new LinkedList<>();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                curLevelValue.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            if (!curLevelValue.isEmpty()) {
                result.add(curLevelValue.getLast());
            }
        }

        return result;
    }
}
