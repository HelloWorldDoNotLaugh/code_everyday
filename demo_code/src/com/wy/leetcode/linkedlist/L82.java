package com.wy.leetcode.linkedlist;

import lombok.val;

/**
 * @author HelloWorld
 * @create 2023/4/22 16:20
 * @email helloworld.dng@gmail.com
 */
public class L82 {
    //https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/

    // 一个指针发生了断链所有都会断链
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dumpyHead = new ListNode(101, head);
        ListNode pre = dumpyHead;
        ListNode cur = pre.next;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                int temp = cur.val;
                while (cur != null && temp == cur.val) {
                    cur = cur.next;
                }
                // 不等后断链
                pre.next = cur;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }

        return dumpyHead.next;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.initLinkedList(1, 2, 2,3, 3, 4);
        L82 l82 = new L82();
        node = l82.deleteDuplicates(node);
        ListNode.print(node);
    }
}
