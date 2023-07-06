package com.wy.leetcode.linkedlist;

public class L25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dumpyHead = new ListNode();
        dumpyHead.next = head;
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode current = head;
        int index = 1;
        while (current.next != null) {
            ListNode next = current.next;
            current.next = next.next;
            next.next = current;
            pre.next = next;
            if (++index % k == 0) {
                pre = current;
                current = current.next;
            }
        }

        return dumpyHead.next;
    }

    public static void main(String[] args) {
        ListNode p = ListNode.initLinkedList(1, 2, 3, 4, 5, 6);
        L25 l25 = new L25();
        ListNode.print(l25.reverseKGroup(p, 2));
    }
}
