package com.wy.leetcode.linkedlist;

public class L328 {
    // https://leetcode.cn/problems/odd-even-linked-list/
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(0, null);
        ListNode oddTail = new ListNode(0, null);
        oddHead.next = oddTail;

        ListNode evenHead = new ListNode(0, null);
        ListNode evenTail = new ListNode(0, null);
        evenHead.next = evenTail;

        int index = 1;
        while (head != null) {
            ListNode tempNode = new ListNode(head.val);
            tempNode.next = null;
            if (index % 2 == 0) {
                evenTail.next = tempNode;
                evenTail = tempNode;
            }else {
                oddTail.next = tempNode;
                oddTail = tempNode;
            }
            head = head.next;
            index++;
        }

        // 去除 空元素
        oddTail.next = evenHead.next.next;
        return oddHead.next.next;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.initLinkedList(1, 2, 3, 4, 5, 6, 7);
        L328 l328 = new L328();
        ListNode.print(l328.oddEvenList(listNode));
    }
}
