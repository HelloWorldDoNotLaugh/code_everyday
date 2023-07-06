package com.wy.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author HelloWorld
 * @create 2022/4/20 08:00
 * @email helloworld.dng@gmail.com
 */
public class ChorusSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 获取输入的数组长度
        int n = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        int i = n;
        while (i-- > 0) {
            list.add(scanner.nextInt());
        }


        System.out.println(doChorusSort(list, n));

    }

    /**
     * @param list int 集合
     * @param n    集合的长度
     * @return int
     * @description 合唱队
     * @author HelloWorld
     * @create 2022/4/22 19:11
     */
    public static int doChorusSort(List<Integer> list, int n) {
        /* 找到每一个位置的向左递减子序列和向右递减子序列的长度*/

        HashSet<Integer> results = new HashSet<>();

        List<Node> leftNodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int currentPosition = i;
            Integer currentSize = list.get(i);

            Node node = new Node(currentSize, currentPosition);
            leftNodes.add(node);
            Integer length = null;
            //  当前节点左递减子序列 为它右边值比它小的节点中 最长的节点长度 + 1
            try {
                length = leftNodes.stream()
                        .filter(node1 -> node1.getSize() < currentSize && node1.getPosition() < currentPosition)
                        .max(Comparator.comparing(Node::getLength))
                        .get()
                        .getLength();
            } catch (Exception e) {
                length = 0;
            }
            leftNodes.get(i).setLength(length + 1);
        }
        List<Node> rightNodes = new ArrayList<>();
        for (int i = n - 1; i >= 0 ; i--) {
            int currentPosition = i;
            Integer currentSize = list.get(i);

            Node node = new Node(currentSize, currentPosition);
            rightNodes.add(node);

            Integer length;
            try {
                length = rightNodes.stream()
                        .filter(node1 -> node1.getSize() < currentSize && node1.getPosition() > currentPosition)
                        .max(Comparator.comparing(Node::getLength))
                        .get()
                        .getLength();
            } catch (Exception e) {
                length = 0;
            }

            rightNodes.get(n - 1 -i).setLength(length + 1);
            results.add(leftNodes.get(i).getLength() + rightNodes.get(n - i -1).getLength() - 1);
        }

        // 减去最长队列长度得到就是最少出队人数
        return n - results.stream().max(Comparator.comparing(Integer::intValue)).get();

    }

}

class Node {
    private int size;
    private int position;
    private int length;

    public Node(Integer size, Integer position) {
        this.size = size;
        this.position = position;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}