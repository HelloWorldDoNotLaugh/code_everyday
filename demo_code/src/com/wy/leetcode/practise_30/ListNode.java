package com.wy.leetcode.practise_30;

/**
 * @author HelloWorld
 * @date 2023/7/16 11:13
 * @email helloworld.dng@gmail.com
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    ListNode() {}

    public static ListNode initListNode(int... values) {
        ListNode tail = new ListNode();
        tail.next = null;
        ListNode head = tail;
        for (int value : values) {
            ListNode tempNode = new ListNode(value);
            tempNode.next = null;
            tail.next = tempNode;
            tail = tempNode;
        }

        return head.next;
    }

    public static void printNode(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode node = initListNode(1, 2, 3, 4, 5);
        printNode(node);
    }
}
