package com.wy;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * @author HelloWorld
 * @date 2023/9/24 09:29
 * @email helloworld.dng@gmail.com
 */
public class LRUCache {

    private LinkedList<Integer> rateList;
    private LinkedHashMap<Integer, Integer> map;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>(capacity);
        rateList = new LinkedList<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        refreshRate(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if (!map.containsKey(key) && capacity ==  map.size()) {
            removeLessRate();
        }

        refreshRate(key);
        map.put(key, value);
    }

    private void removeLessRate() {
        Integer value = rateList.getLast();
        rateList.removeLast();
        map.remove(value);
    }

    private void refreshRate(int key) {
        int index = rateList.indexOf(key);
        if (index != -1) {
            rateList.remove(index);
        }

        rateList.addFirst(key);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.get(2);
        lruCache.put(2,6);
        lruCache.get(1);
        lruCache.put(1,5);
        lruCache.put(1,2);

        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));

        System.out.println(lruCache);
    }

}
