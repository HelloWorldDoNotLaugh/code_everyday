package com.wy.leetcode.linkedlist;

import java.util.Arrays;

/**
 * @author HelloWorld
 * @create 2023/4/22 16:09
 * @email helloworld.dng@gmail.com
 */
public class ListNode {
    int val;
    ListNode next;

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
        final ListNode[] head = {new ListNode()};
        Arrays.stream(values)
                .mapToObj(Integer::new)
                .sorted(((a,b) -> -1))
                .forEach(value -> {
                    ListNode node = new ListNode(value);
                    node.next = head[0];
                    head[0] = node;
                });
        return head[0];
    }

    public static void print(ListNode head) {
        while (head.next != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
