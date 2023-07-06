package com.wy.leetcode.linkedlist;

import java.util.Objects;

import static java.util.Objects.nonNull;

/**
 * @author HelloWorld
 * @create 2022/9/4 10:17
 * @email helloworld.dng@gmail.com
 */
public class MyLinkedList {

    /** 链表长度 */
    private int size;
    /** 虚拟头节点 */
    private ListNode head;
    /** 尾节点 (真实尾节点，便于实现尾插法)*/
    private ListNode tail;

    public MyLinkedList() {
        this.size = 0;
        this.head = new ListNode(0);
    }


    /**
     * @description 获取链表中第 index 个节点的值。如果索引无效，则返回-1;  第一个节点的 index = 0
     * @author HelloWorld
     * @create 2022/9/4 10:19
     * @param index:  0 <= index <= size - 1
     * @return int
     */
    public int get(int index) {
        if (index >= size || index < 0) {
            return -1;
        }

        ListNode now = head;
        for (int i = 0; i <= index; i++) {
            now = now.next;
        }

        return now.val;
    }

    /**
     * @description 头插法
     * @author HelloWorld
     * @create 2022/10/30 15:45
     * @param val
     * @return void
     */
    public void addAtHead(int val) {
        ListNode listNode = new ListNode(val);
        listNode.next = head.next;
        head.next = listNode;
        this.size++;
        // 尾指针指向末尾节点
        if (size == 1) {
            tail = head.next;
        }
    }

    public void addAtTail(int val) {
        if (this.size == 0) {
            addAtHead(val);
            return;
        }
        ListNode listNode = new ListNode(val);
        tail.next = listNode;
        tail = listNode;
        this.size++;
    }

    /**
     * @description 在链表中的第 index 个节点之前添加值为 val  的节点。
     *              如果 index 等于链表的长度，则该节点将附加到链表的末尾。
     *              如果 index 大于链表长度，则不会插入节点。
     *              如果index小于0，则在头部插入节点。
     * @author HelloWorld
     * @create 2022/9/4 10:58
     * @param index 0 <= index <= size - 1
     * @param val
     * @return void
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }

        if (index <= 0) {
            addAtHead(val);
            return;
        }

        if (index == size) {
            addAtTail(val);
            return;
        }

        // 中间位置添加节点
        ListNode pre = head;
        for (int i = 0; i <= index - 1; i++) {
            pre = pre.next;
        }

        ListNode tempNode = new ListNode(val);
        tempNode.next = pre.next;
        pre.next = tempNode;
        this.size++;
    }

    /**
     * @description 如果索引 index 有效，则删除链表中的第 index 个节点。
     * @author HelloWorld
     * @create 2022/9/4 11:38
     * @param index 0 <= index <= size - 1
     * @return void
     */
    public void deleteAtIndex(int index) {
        /* 索引无效 */
        if (index < 0 || index >= size) {
            return;
        }

        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        if (index == size - 1) {
            tail = pre;
        }else {
            pre.next = pre.next.next;
        }
        this.size --;

    }

    /**
     * 删除链表中重复的节点
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode now = head;
        while (now != null) {
            ListNode temp = now.next;
            ListNode pre = now;
            int currentValue = now.val;
            while (temp != null) {
                if ((currentValue ^ temp.val) == 0){
                    pre.next = pre.next.next;
                    temp = pre.next;
                }else {
                    pre = temp;
                    temp = temp.next;
                }
            }
            now = now.next;
        }
        return head;
    }

    /**
     * 有序链表，删除所有val相同的节点  [1, 2, 2, 2, 3, 3, 4] -> [1, 4]
     * @param head
     * @return
     */
    public ListNode deleteDuplicatesOrderList(ListNode head) {
        ListNode currentNode = head;
        while (Objects.nonNull(currentNode.next) && Objects.nonNull(currentNode.next.next)) {
            ListNode tempNode = currentNode.next;
            if (tempNode.val == tempNode.next.val) {
                do {
                    tempNode = tempNode.next;
                }while (Objects.nonNull(tempNode) && Objects.nonNull(tempNode.next) && tempNode.val == tempNode.next.val);
                currentNode.next = tempNode.next;
            }else {
                currentNode = currentNode.next;
            }
        }
        return head;
    }

    /**
     * @description 反转链表；[1,2,3,4,5] -> [5,4,3,2,1]
     * @author HelloWorld
     * @create 2022/9/18 15:58
     * @param head
     * @return com.wy.leetcode.linkedlist.ListNode
     */
    private ListNode reverseList(ListNode head) {
        MyLinkedList resultList = new MyLinkedList();
        while (Objects.nonNull(head.next)) {
            head = head.next;
            resultList.addAtHead(head.val);
        }

        return resultList.head;
    }


    /**
     * @description 反转指定位置的节点  [1,2,3,4,5]，start=2, end=4 -> [1,4,3,2,5]
     * @author HelloWorld
     * @create 2022/10/30 16:15
     * @param head
     * @param start
     * @param end
     * @return com.wy.leetcode.linkedlist.ListNode
     */
    private ListNode reverseList(ListNode head, int start, int end) {
        ListNode cur;
        ListNode temp = head;
        // 1.先找到要开始反转定节点；
        int i = 0;
        while (i < start - 1) {
            temp = temp.next;
            i++;
        }
        cur = temp;
        temp = temp.next;
        i++;

        // 2.反转链表
        MyLinkedList linkedList = new MyLinkedList();
        while (i <= end) {
            linkedList.addAtHead(temp.val);
            temp = temp.next;
            i++;
        }

        // 3.组装节点
        cur.next = linkedList.head.next;
        linkedList.tail.next = temp;


        return head;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtTail(1);
        myLinkedList.addAtTail(2);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtTail(4);
        myLinkedList.addAtTail(5);
        myLinkedList.addAtTail(6);
        myLinkedList.addAtTail(7);

        ListNode listNode = myLinkedList.reverseList(myLinkedList.head, 1, 7);


        while (listNode.next != null) {
            listNode = listNode.next;
            System.out.println(listNode.val);
        }
    }
}

