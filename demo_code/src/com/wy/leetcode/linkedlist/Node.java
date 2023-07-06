package com.wy.leetcode.linkedlist;

import java.util.Objects;

/**
 * @author HelloWorld
 * @create 2022/10/30 16:49
 * @email helloworld.dng@gmail.com
 */
public class Node {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode cur = new ListNode();
        cur.next = head;

        // 1.先找到开始反转定节点； 让temp指向要开始反转定节点， cur.next = temp;
        ListNode pre = cur;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }
        head = pre.next;

        // 2.反转
        // 反转后的头节点
        ListNode reversedHead = new ListNode();
        // 反转后的头节点的尾节点
        ListNode reversedTail = new ListNode();
        for (int i = left; i <= right ; i++) {
            ListNode temp = new ListNode(head.val);
            if (i == left) {
                reversedTail = temp;
            }
            temp.next = reversedHead;
            reversedHead = temp;

            head = head.next;
        }

        // 3.组装
        pre.next = reversedHead;
        reversedTail.next = head;

        return cur.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode tail = new ListNode();
        for (int i = 1; i <= 3; i++) {
            ListNode temp = new ListNode(i);
            if (i == 1) {
                head = temp;
            }

            tail.next = temp;
            tail = temp;
        }

        Node node = new Node();
        head = node.reverseBetween(head, 2, 3);

        while (Objects.nonNull(head)) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
