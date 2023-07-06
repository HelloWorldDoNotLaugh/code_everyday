package com.wy.leetcode.linkedlist;

public class L203 {
    // https://leetcode.cn/problems/remove-linked-list-elements/
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                cur = cur.next;
                pre.next = cur;
            }else {
                cur = cur.next;
                pre = pre.next;
            }

        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.initLinkedList(1, 2, 3, 3, 4, 3, 5);
        L203 l203 = new L203();
        ListNode.print(l203.removeElements(listNode, 5));
    }
}
