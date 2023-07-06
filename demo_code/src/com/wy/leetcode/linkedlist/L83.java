package com.wy.leetcode.linkedlist;

/**
 * @author HelloWorld
 * @create 2023/4/22 16:10
 * @email helloworld.dng@gmail.com
 */
public class L83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode val = head;
        while (val != null && val.next != null) {
            if (val.val == val.next.val) {
                val.next = val.next.next;
            }else {
                val = val.next;
            }
        }

        return head;
    }


}
