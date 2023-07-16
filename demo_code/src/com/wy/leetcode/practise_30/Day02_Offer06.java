package com.wy.leetcode.practise_30;

/**
 * @author HelloWorld
 * @date 2023/7/16 11:13
 * @email helloworld.dng@gmail.com
 */
public class Day02_Offer06 {

    public int[] reversePrint(ListNode head) {
        int count = 0;
        ListNode resultNode = new ListNode();
        while (head != null) {
            ListNode tempNode = new ListNode();
            tempNode.val = head.val;
            tempNode.next = resultNode;
            resultNode = tempNode;

            head = head.next;
            count++;
        }

        int[] ints = new int[count];
        for (int i = 0; i < count; i++) {
            ints[i] = resultNode.val;
            resultNode = resultNode.next;
        }

        return ints;
    }

    public static void main(String[] args) {
        Day02_Offer06 day02Offer06 = new Day02_Offer06();
        ListNode node = new ListNode(1);
        node.val = 1;

        ListNode node1 = new ListNode(2);
        node.next = node1;

        ListNode node2 = new ListNode(3);
        node1.next = node2;

        day02Offer06.reversePrint(node);
    }
}
