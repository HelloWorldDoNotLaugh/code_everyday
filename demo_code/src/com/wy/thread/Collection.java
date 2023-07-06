package com.wy.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author HelloWorld
 * @create 2023/5/10 20:44
 * @email helloworld.dng@gmail.com
 */
public class Collection {

    public static void main(String[] args) {
        List<Object> objects = Collections.synchronizedList(new ArrayList<>());
        CopyOnWriteArrayList<Integer> integers = new CopyOnWriteArrayList<>();

    }
}
