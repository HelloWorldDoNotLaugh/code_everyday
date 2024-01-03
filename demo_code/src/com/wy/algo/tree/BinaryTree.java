package com.wy.algo.tree;

import cn.hutool.core.lang.Assert;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author HelloWorld
 * @date 2024/1/2 18:32
 * @email helloworld.dng@gmail.com
 */
public class BinaryTree<E> {
    public static void main(String[] args) {
        System.out.println(getHeight(15));
    }
    Node<E> root;

    /**
     * @description 初始化二叉树(层次便利)
     * @author HelloWorld
     * @create 2024/1/2 18:57
     * @param elements
     * @return com.wy.algo.tree.BinaryTree<E>
     */
    @SafeVarargs
    public static<E> BinaryTree<E> init(E... elements) {
        Assert.notEmpty(elements, "elements must not be empty");
        BinaryTree<E> tree = new BinaryTree<>();
        tree.root = new Node<>(elements[0]);

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(tree.root);
        int index = 1;
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            if (index < elements.length) {
                node.left = new Node<>(elements[index]);
                queue.offer(node.left);
            }
            index++;

            if (index < elements.length) {
                node.right = new Node<>(elements[index]);
                queue.offer(node.right);
            }
            index++;
        }

        return tree;
    }


    public static<E> void print(BinaryTree<E> tree) {
        List<Node<E>> nodeList = levelOrderTraversal(tree);
        int height = getHeight(nodeList.size());
        int maxNodeLevels = (int) Math.pow(2, height - 1);

        // 打印每层节点

    }


    /**
     * @description 根据节点个数，计算完全二叉树的高度
     * @author HelloWorld
     * @create 2024/1/2 19:48
     * @param nodeNums
     * @return int
     */
    public static int getHeight(int nodeNums) {
        int level = 1;
        while (!(Math.pow(2, level - 1) <= nodeNums && Math.pow(2, level) > nodeNums)) {
            level++;
        }
        return level;
    }

    public static<E>List<Node<E>> levelOrderTraversal(BinaryTree<E> tree) {
        List<Node<E>> nodes = new ArrayList<>();
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(tree.root);

        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            nodes.add(node);

            if (node.left!= null) {
                queue.offer(node.left);
            }
            if (node.right!= null) {
                queue.offer(node.right);
            }
        }

        return nodes;
    }

    static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;

        public Node(E element) {
            this.element = element;
            this.left = null;
            this.right = null;
        }
    }
}
