package com.wy.leetcode.linkedlist;

import java.util.HashMap;

public class L61 {
    // https://leetcode.cn/problems/rotate-list/\
    public ListNode rotateRight(ListNode head, int k) {
        ListNode cur = head;
        int length = 0;
        while (cur.next != null) {
            cur = cur.next;
            length++;
        }
        cur.next = head;
        k = k % length;
        // 断链
        int index = 1;
        //while ()
        return null;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.initLinkedList(1, 2, 3, 4, 5, 6);
        L61 l61 = new L61();
        ListNode.print(l61.rotateRight(listNode, 2));
    }
}
