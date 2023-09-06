package com.wy.leetcode.practise_30;

import com.wy.leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/9/6
 */
public class Day15 {

    private List<List<Integer>> result = new LinkedList<>();
    private LinkedList<Integer> path = new LinkedList();

    /**
     * @description  剑指 Offer 34. 二叉树中和为某一值的路径
     * @author yuyang.zhang
     * @date 2023/9/6 13:37
     * @param root
     * @param target
     * @return java.util.List<java.util.List<java.lang.Integer>>
     */
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        reduceAndRecord(root, target);
        return result;
    }

    private void reduceAndRecord(TreeNode node, int target) {
        if (null == node) {
            return;
        }

        target = target - node.val;
        path.add(node.val);

        if (node.left == null && node.right == null && target == 0) {
            result.add(new LinkedList<>(path));
        }

        reduceAndRecord(node.left, target);
        reduceAndRecord(node.right, target);

        path.removeLast();
    }


    private Node head;
    private Node tail = new Node();

    /**
     * @description 剑指 Offer 36. 二叉搜索树与双向链表
     * @author yuyang.zhang
     * @date 2023/9/6 14:39
     * @param root
     * @return com.wy.leetcode.practise_30.Day15.Node
     */
    public Node treeToDoublyList(Node root) {
        if (root == null) {return root;}
        dfs(root);
        head.left = tail;
        tail.right = head;
        return head;
    }


    private void dfs(Node node) {
        if (null == node) {
            return;
        }
        dfs(node.left);
        // 尾插法构建双链表
        Node temp = new Node(node.val);
        temp.left = tail;
        tail.right = temp;
        tail = temp;
        if (head == null) {
            head = tail;
        }
        dfs(node.right);
    }


    private Node initTree(Integer... values) {
        Node node = new Node(values[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        int index = 1;
        while (!queue.isEmpty() && index < values.length) {
            Node curNode = queue.poll();

            if (values[index] != null) {
                curNode.left = new Node(values[index]);
                queue.add(curNode.left);
            }
            index++;

            if (values[index] != null) {
                curNode.right = new Node(values[index]);
                queue.add(curNode.right);
            }
            index++;
        }

        return node;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }


    /**
     * @description 剑指 Offer 54. 二叉搜索树的第 k 大节点
     * @author yuyang.zhang
     * @date 2023/9/6 15:43
     * @param root
     * @param k
     * @return int
     *
     *  二叉搜索树的中序遍历结果是递增的
     */
    public int kthLargest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curNode = root;
        while (!stack.isEmpty() || null != curNode) {
            while (curNode!=null) {
                stack.push(curNode);
                curNode = curNode.right;
            }
            curNode = stack.pop();
            k--;
            if (k==0) {
                return curNode.val;
            }

            curNode = curNode.left;
        }

        return -1;
    }

    public static void main(String[] args) {
        Day15 day15 = new Day15();

        TreeNode treeNode = TreeNode.init(5, 3, 6, 2, 4, null, null, 1);

        System.out.println(day15.kthLargest(treeNode, 2));
    }
}
