package com.wy.leetcode.linkedlist;

import java.util.Arrays;

/**
 * @author HelloWorld
 * @create 2023/4/22 16:09
 * @email helloworld.dng@gmail.com
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(){}

    public static ListNode initLinkedList(int... values) {
        ListNode head = null;
        ListNode tail = null;
        for (int value : values) {
            ListNode tempNode = new ListNode(value);

            if (head == null) {
                head = tempNode;
                tail = tempNode;
            } else {
                tail.next = tempNode;
                tail = tempNode;
            }
        }
        return head;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
