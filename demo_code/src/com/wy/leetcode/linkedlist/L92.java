package com.wy.leetcode.linkedlist;

public class L92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        L92 l92 = new L92();
        ListNode listNode = ListNode.initLinkedList(1, 2, 3, 4, 5, 6);
        ListNode.print(l92.reverseBetween(listNode, 2, 4));
    }
}
