package com.wy.mycode.algorithm.linknode;

import java.util.ArrayList;
import java.util.List;
/**
 * @author HelloWorld
 * @create 2022/6/6 20:49
 * @email helloworld.dng@gmail.com
 */
public class HeadInsert {
    /**
     * @description 头插法，每次都从头插入；
     * @author HelloWorld
     * @create 2022/6/6 21:30
     * @param data
     * @return com.wy.mycode.algorithm.linknode.Node
     */
    public static Node getLinkList(List<?> data){
        int length = data.size();
        Node head = new Node<>();
        head.item = null;
        head.next = null;
        while (length-- > 0) {
            Node node = new Node<>();
            node.item = data.get(length);
            node.next = head;
            head = node;
        }
        return head;
    }

    public static void main(String[] args) {
        ArrayList<Integer> dataList = new ArrayList<>();
        dataList.add(1);
        dataList.add(2);
        dataList.add(3);
        dataList.add(4);
        dataList.add(5);
        Node<Integer> node = getLinkList(dataList);
        while (node.next != null) {
            System.out.println(node.item);
            node = node.next;
        }
    }
}
