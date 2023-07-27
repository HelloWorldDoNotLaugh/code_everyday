package com.wy.leetcode.practise_30;

import java.util.ArrayList;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/7/27
 */
public class Day11 {

    /**
     * @description 剑指 Offer 18. 删除链表的节点
     * @author yuyang.zhang
     * @date 2023/7/27 11:39
     * @param head
     * @param val
     * @return com.wy.leetcode.practise_30.ListNode
     *  a -> b -> c -> d -> e; del c
     *  pre = b, cur = c;
     *  pre.next = c.next;
     */
    public ListNode deleteNode(ListNode head, int val) {
        ListNode result = new ListNode();
        result.next = head;
        ListNode pre = result;
        ListNode cur = pre.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }

        return result.next;
    }



    /**
     * @description 剑指 Offer 22. 链表中倒数第 k 个节点
     * @author yuyang.zhang
     * @date 2023/7/27 12:48
     * @param head
     * @param k
     * @return com.wy.leetcode.practise_30.ListNode
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ArrayList<ListNode> listNodes = new ArrayList<>();
        while (head != null) {
            listNodes.add(head);
            head = head.next;
        }

        return listNodes.get(listNodes.size() - k);
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.initListNode(4,1, 5, 1, 1, 9);

        Day11 day11 = new Day11();
        ListNode kthFromEnd = day11.getKthFromEnd(listNode, 4);
        ListNode.printNode(kthFromEnd);
    }
}
