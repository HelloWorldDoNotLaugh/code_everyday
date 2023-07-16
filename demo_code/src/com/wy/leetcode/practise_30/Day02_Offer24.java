package com.wy.leetcode.practise_30;

/**
 * @author HelloWorld
 * @date 2023/7/16 13:42
 * @email helloworld.dng@gmail.com
 */
public class Day02_Offer24 {
    public ListNode reverseList(ListNode head) {
        ListNode resultNode = null;
        while (head != null) {
            ListNode tempNode = new ListNode(head.val);
            tempNode.next = resultNode;
            resultNode = tempNode;

            head = head.next;
        }

        return resultNode;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.initListNode(1, 2, 3, 4, 5);

        Day02_Offer24 day02Offer24 = new Day02_Offer24();
        ListNode reverseNodes = day02Offer24.reverseList(node);

        ListNode.printNode(reverseNodes);
    }


}
