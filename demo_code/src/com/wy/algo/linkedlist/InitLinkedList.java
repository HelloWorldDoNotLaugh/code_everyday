package com.wy.algo.linkedlist;

import cn.hutool.core.lang.Assert;

/**
 * @author HelloWorld
 * @date 2024/1/2 16:22
 * @email helloworld.dng@gmail.com
 */
public class InitLinkedList<E> {
    public static void main(String[] args) {
        Node<Integer> head = initAtHead(1, 2, 3, 4, 5);

        while (head != null) {
            System.out.println(head.element);
            head = head.next;
        }
    }

    /**
     * 头插法 构建链表
     *
     * @param elements not empty
     * @return
     */
    @SafeVarargs
    public static<E> Node<E> initAtHead(E... elements) {
        Assert.notEmpty(elements);

        // 1. 构建一个头节点
        Node<E> head = new Node<>(elements[0]);
        for (int i = 1; i < elements.length; i++) {
            // 2. 从头部插入新节点
            Node<E> node = new Node<>(elements[i]);
            node.next = head;
            // 3. 重新设置头节点
            head = node;
        }

        return head;
    }


    /**
     * 尾插法 构建链表
     *
     * @param elements not empty
     * @return
     */
    @SafeVarargs
    public static<E> Node<E> initAtTail(E... elements) {
        Assert.notEmpty(elements);

        // 1. 初始化头节点，尾节点
        Node<E> head = new Node<>(elements[0]);
        Node<E> tail = head;
        for (int i = 1; i < elements.length; i++) {
            // 2. 从尾部插入节点
            tail.next = new Node<>(elements[i]);
            // 3. 重新设置尾节点
            tail = tail.next;
        }

        return head;
    }


    static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
            this.next = null;
        }
    }
}
