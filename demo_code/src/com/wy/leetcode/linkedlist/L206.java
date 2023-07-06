package com.wy.leetcode.linkedlist;

public class L206 {
    public ListNode reverseList(ListNode head) {
        ListNode result = null;
        while (head != null) {
            ListNode listNode = new ListNode(head.val, null);
            listNode.next = result;
            result = listNode;
            head = head.next;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.initLinkedList(1, 2, 3, 4, 5);
        L206 l206 = new L206();
        ListNode.print(l206.reverseList(listNode));
    }


}
