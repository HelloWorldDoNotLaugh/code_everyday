package com.wy.leetcode;

import com.wy.leetcode.linkedlist.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author zhangyuyang
 * @since 2024/9/13 13:19
 */
public class L1019 {
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> resultList = new ArrayList<>();
        ArrayDeque<Integer> unKnowStack = new ArrayDeque<>();
        // 记录节点出现的位置与值的关系
        HashMap<Integer, Integer> nodeMap = new HashMap<>();
        int index = 0;
        while (head != null) {
            nodeMap.put(index, head.val);
            resultList.add(0);
            while (!unKnowStack.isEmpty() && head.val > nodeMap.get(unKnowStack.peek())) {
                resultList.set(unKnowStack.pop(), head.val);
            }
            unKnowStack.push(index);
            head = head.next;
            index++;
        }
        return resultList.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        ListNode head = ListNode.initLinkedList(5, 2, 6);

        L1019 l1019 = new L1019();
        System.out.println(l1019.nextLargerNodes(head));
    }
}
