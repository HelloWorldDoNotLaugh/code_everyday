package com.wy.leetcode.practise_30;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/7/27
 */
public class Day12 {
    /**
     * @description 剑指 Offer 25. 合并两个排序的链表
     * @author yuyang.zhang
     * @date 2023/7/27 13:02
     * @param l1
     * @param l2
     * @return com.wy.leetcode.practise_30.ListNode
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tail = new ListNode();
        ListNode resultNode = tail;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                ListNode temp = new ListNode(l1.val);
                tail.next = temp;
                tail = temp;
                l1 = l1.next;
            } else {
                ListNode temp = new ListNode(l2.val);
                tail.next = temp;
                tail = temp;
                l2 = l2.next;
            }
        }
        tail.next = l1 != null ? l1 : l2;

        return resultNode.next;
    }

    /**
     * @description 剑指 Offer 52. 两个链表的第一个公共节点
     * @author yuyang.zhang
     * @date 2023/7/27 13:46
     * @param headA
     * @param headB
     * @return com.wy.leetcode.practise_30.ListNode
     */
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return null;
    }

    public static void main(String[] args) {
        Day12 day12 = new Day12();
        ListNode l1 = ListNode.initListNode(4, 1, 8, 4, 5);
        ListNode l2 = ListNode.initListNode(5, 0,1, 8, 4, 5);

        ListNode.printNode(day12.getIntersectionNode(l1, l2));
    }
}
