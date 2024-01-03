package com.wy.algo.linkedlist;

import cn.hutool.core.lang.Assert;

/**
 * @author HelloWorld
 * @date 2024/1/2 12:46
 * @email helloworld.dng@gmail.com
 */
public class LinkedList<E> {
    /** 头节点*/
    private Node<E> first;

    /** 尾节点*/
    private Node<E> last;

    public LinkedList() {
    }

    /**
     * 初始化链表
     * @param elements 列表元素 not empty
     * @return
     */
    @SafeVarargs
    public static<E> LinkedList<E> init(E... elements) {
        return initAtTail(elements);
    }

    public static<E> LinkedList<E> initAtTail(E... elements) {
        Assert.notEmpty(elements, "elements must not be empty");

        LinkedList<E> linkedList = new LinkedList<>();
        linkedList.first = new Node<>(elements[0]);
        linkedList.last = linkedList.first;
        for (int i = 1; i < elements.length; i++) {
            linkedList.addAtTail(linkedList, elements[i]);
        }

        return linkedList;
    }

    @SafeVarargs
    public static<E> LinkedList<E> initAtHead(E... elements) {
        Assert.notEmpty(elements, "elements must not be empty");

        LinkedList<E> linkedList = new LinkedList<>();
        linkedList.first = new Node<>(elements[0]);
        for (int i = 1; i < elements.length; i++) {
            linkedList.addAtHead(linkedList, elements[i]);
        }

        return linkedList;
    }


    /**
     * 头插法
     * @param linkedList
     * @param e
     */
    public void addAtHead(LinkedList<E> linkedList, E e) {
        Node<E> temp = new Node<> (e);
        temp.next = linkedList.first;
        linkedList.first = temp;
    }

    /**
     * 尾插法
     * @param linkedList
     * @param e
     */
    public void addAtTail(LinkedList<E> linkedList, E e) {
        linkedList.last.next = new Node<>(e);
        linkedList.last = linkedList.last.next;
    }

    /**
     * 打印链表
     * @param linkedList
     * @param <E>
     */
    public static<E> void print(LinkedList<E> linkedList) {
        Node<E> cur = linkedList.first;
        StringBuilder printResult = new StringBuilder();
        while (cur!= null) {
            printResult.append(cur.element).append("->");
            cur = cur.next;
        }

        System.out.println(printResult.substring(0, printResult.length() - 2));
    }


    public static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;

        public Node(E element) {
            this.element = element;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = LinkedList.initAtHead(1, 2, 3, 4, 5);
        print(linkedList);

        linkedList = LinkedList.initAtTail(1, 2, 3, 4, 5);
        print(linkedList);
    }
}
