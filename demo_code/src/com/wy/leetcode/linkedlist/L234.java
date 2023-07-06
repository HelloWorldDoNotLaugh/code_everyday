package com.wy.leetcode.linkedlist;

public class L234 {
    // https://leetcode.cn/problems/palindrome-linked-list/
    public boolean isPalindrome(ListNode head) {
        // 使用头插法得到一个新的倒序链表。
        ListNode reverseHead = new ListNode();
        reverseHead.next = null;
        ListNode current = head;
        while (current != null) {
            ListNode tempNode = new ListNode(current.val);
            tempNode.next = reverseHead;
            reverseHead = tempNode;
            current = current.next;
        }
        reverseHead = reverseHead.next;
        while (reverseHead != null && head != null) {
            if (reverseHead.val != head.val) {
                return false;
            }
            reverseHead = reverseHead.next;
            head = head.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.initLinkedList(1, 2, 2, 1);
        L234 l234 = new L234();
        System.out.println(l234.isPalindrome(listNode));
    }
}
