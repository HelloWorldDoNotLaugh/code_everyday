package com.wy.leetcode.linkedlist;

/**
 * @author zhangyuyang
 * @since 2024/12/13 13:02
 */
public class L1290 {
    public int getDecimalValue(ListNode head) {
        StringBuilder stringBuilder = new StringBuilder();
        while (head != null) {
            stringBuilder.append(head.val);
            head = head.next;
        }

        return Integer.parseInt(stringBuilder.toString(), 2);
    }
}
