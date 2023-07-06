package com.wy.mycode.algorithm.linknode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HelloWorld
 * @create 2022/6/6 21:13
 * @email helloworld.dng@gmail.com
 */
public class TailInsert {
    /**
     * @description 尾插法
     * @author HelloWorld
     * @create 2022/6/6 21:31
     * @param data
     * @return com.wy.mycode.algorithm.linknode.Node
     */
    public static Node getLinkList(List<?> data){
        int length = data.size();
        Node head = new Node<>();
        Node tail = new Node<>();
        head = tail;
        while (length-- > 0) {
            Node node = new Node<>();
            node.item = data.get(length);
            tail.next = node;
            tail = node;
        }
        tail.next = null;
        return head.next;
    }

    public static void main(String[] args) {
        ArrayList<Integer> dataList = new ArrayList<>();
        dataList.add(1);
        dataList.add(2);
        dataList.add(3);
        dataList.add(4);
        dataList.add(5);
        Node<Integer> node = getLinkList(dataList);
        while (node != null) {
            System.out.println(node.item);
            node = node.next;
        }
    }
}
