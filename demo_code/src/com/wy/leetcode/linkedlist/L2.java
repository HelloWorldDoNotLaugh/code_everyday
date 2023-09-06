package com.wy.leetcode.linkedlist;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/9/6
 *
 *  两数相加
 */
public class L2 {

    ListNode tail;
    ListNode head;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int bit = 0;

        while (l1 != null && l2 != null) {
            int value = l1.val + l2.val + bit;
            insertFromTail(value%10);
            bit = value / 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode otherNode = l1 != null ? l1 : l2;
        while (otherNode != null) {
            int value = otherNode.val + bit;
            insertFromTail(value%10);
            bit = value / 10;
            otherNode = otherNode.next;
        }

        if (bit == 1) {
            insertFromTail(1);
        }

        return head;
    }

    private void insertFromTail(int value) {
        ListNode tempNode = new ListNode(value);
        if (head == null) {
            head = tempNode;
            tail = tempNode;
        } else {
            tail.next = tempNode;
            tail = tempNode;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = ListNode.initLinkedList(9,9,9,9,9,9,9);
        ListNode listNode2 = ListNode.initLinkedList(9,9,9,9);

        L2 l2 = new L2();

        ListNode.print(l2.addTwoNumbers(listNode1, listNode2));
    }

}
