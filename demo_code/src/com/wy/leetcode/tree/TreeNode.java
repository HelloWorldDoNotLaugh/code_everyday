package com.wy.leetcode.tree;

import java.util.*;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/7/21
 */
public class TreeNode {
    public int val;
    public TreeNode left;

    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }



    /**
     * @description 根据层次遍历的结果还原二叉树
     *  层次遍历结果：3,9,20,null,null,15,7
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * @author HelloWorld
     * @create 2023/7/22 09:16
     * @param values
     * @return com.wy.leetcode.tree.TreeNode
     */
    public static TreeNode init(Integer ...values) {
        TreeNode root = new TreeNode(values[0]);

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);

        int i = 1;
        while (!treeNodeQueue.isEmpty() && i < values.length) {
            TreeNode treeNode = treeNodeQueue.poll();
            // 左孩子是否存在
            if (values[i] != null) {
                treeNode.left = new TreeNode(values[i]);
                treeNodeQueue.add(treeNode.left);
            }
            i++;

            if (i < values.length && values[i] != null) {
                treeNode.right = new TreeNode(values[i]);
                treeNodeQueue.add(treeNode.right);
            }

            i++;
        }

        return root;
    }


    /**
     * @description 层次遍历
     * @author HelloWorld
     * @create 2023/7/23 08:56
     * @param root
     * @return java.util.List<java.lang.Integer>
     */
    public static List<Integer> levelOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            result.add(treeNode.val);

            addIfNotNull(queue, treeNode.left);
            addIfNotNull(queue, treeNode.right);
        }

        return result;
    }

    /**
     * @description 前序遍历：根，左，右
     * @author HelloWorld
     * @create 2023/7/23 08:58
     * @param root
     * @return void
     */
    public static List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            addIfNotNull(stack, node.right);
            addIfNotNull(stack, node.left);
        }

        return result;
    }

    /**
     * @description 中序遍历 左根右
     * @author HelloWorld
     * @create 2023/7/23 09:20
     * @param root
     * @return java.util.List<java.lang.Integer>
     */
    public static List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (null != node || !stack.isEmpty()) {
            while (null != node) {
                stack.push(node);
                node = node.left;
            }

            node= stack.pop();
            result.add(node.val);
            node = node.right;
        }

        return result;
    }

    /**
     * @description 后续遍历
     * @author HelloWorld 左右根
     * @create 2023/7/23 09:09
     * @param node
     * @return java.util.List<java.lang.Integer>
     */
    public static List<Integer> postOrderTraversal(TreeNode node) {
        Stack<TreeNode> resultStack = new Stack<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(node);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            resultStack.push(treeNode);

            addIfNotNull(stack, treeNode.left);
            addIfNotNull(stack, treeNode.right);
        }

        List<Integer> result = new ArrayList<>();
        while (!resultStack.isEmpty()) {
            result.add(resultStack.pop().val);
        }

        return result;
    }


    private static void addIfNotNull(Collection<TreeNode> collection, TreeNode node) {
        if (null != node) {
            collection.add(node);
        }
    }

    public static void preTraversal(TreeNode root) {
        if (null == root) {
            return;
        }

        printValue(root);
        preTraversal(root.left);
        preTraversal(root.right);
    }

    public static void preTraversalByStack(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            printValue(node);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        printValue(root);
        inorderTraversal(root.right);
    }
    public static void inorderTraversalByStack(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            printValue(node);
            node = node.right;
        }
    }

    public static void postTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postTraversal(root.left);
        postTraversal(root.right);
        printValue(root);
    }

    public static void postTraversalByStack(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode pre = null;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            // 到这，可以判定已经到了最左边的子节点，但是不能保证该节点是否具有右孩子节点
            node = stack.pop();
            // 如果 pre == node.right 说明右孩子已经被访问了
            if (node.right == null || pre == node.right) {
                pre = node;
                printValue(node);
                node = null;
            } else {
                stack.push(node);
                node = node.right;
            }
        }
    }

    private static void printValue(TreeNode node) {
        if (null == node) {
            return;
        }

        System.out.print(node.val + "\t");
    }

    public static void levelTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            printValue(node);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public static int getLength(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getLength(root.left);
        int rightHeight = getLength(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }


    public static void main(String[] args) {
        TreeNode node = init(1, 2, 3, 4, 5, 6, 7, 8, 9);

        System.out.println(getLength(node));
    }
}
