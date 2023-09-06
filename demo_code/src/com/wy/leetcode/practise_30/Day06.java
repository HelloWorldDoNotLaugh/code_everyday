package com.wy.leetcode.practise_30;

import com.wy.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/7/21
 */
public class Day06 {
    public int[] levelOrder(TreeNode root) {
        if (null == root) {
            return new int[0];
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            result.add(treeNode.val);

            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }

            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }

        int[] array = new int[result.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = result.get(i);
        }

        return array;
    }

    public List<List<Integer>> levelOrderLists(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (null == root) {
            return lists;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();

            // 大坑：不能直接用queue.size, add后，size会变化
            int size = queue.size();
            for (int i = 1; i <= size; i++) {
                TreeNode treeNode = queue.poll();
                list.add(treeNode.val);
                if (null != treeNode.left) {
                    queue.add(treeNode.left);
                }
                if (null != treeNode.right) {
                    queue.add(treeNode.right);
                }
            }

            if (!list.isEmpty()) {
                lists.add(list);
            }
        }

        return lists;
    }


    public List<List<Integer>> levelOrderListsRight(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (null == root) {
            return lists;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int count = 0;
        while (!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();

            // 大坑：不能直接用queue.size, add后，size会变化
            int size = queue.size();
            for (int i = 1; i <= size; i++) {
                TreeNode treeNode = queue.poll();
                if (count % 2 == 0) {
                    list.addLast(treeNode.val);
                } else {
                    list.addFirst(treeNode.val);
                }

                if (null != treeNode.left) { queue.add(treeNode.left);}
                if (null != treeNode.right) { queue.add(treeNode.right);}

            }

            if (!list.isEmpty()) {
                lists.add(list);
            }
            count++;
        }

        return lists;
    }
    public static void main(String[] args) {
        Day06 day06 = new Day06();
        day06.levelOrderListsRight(TreeNode.init(3,9,20,null,null,15,7));
    }
}
