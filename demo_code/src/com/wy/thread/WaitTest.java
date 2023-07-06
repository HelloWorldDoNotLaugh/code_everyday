package com.wy.thread;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author HelloWorld
 * @create 2023/5/2 11:19
 * @email helloworld.dng@gmail.com
 */
public class WaitTest {
    private Queue<String> buffer = new LinkedList<>();

    public void give(String data) {
       synchronized (this) {
           buffer.add(data);
           notify();
       }
    }

    public String take() throws Exception{
        synchronized (this) {
            while (buffer.isEmpty()) {
                wait();
            }
        }
        String poll = buffer.poll();
        System.out.println(poll);
        return poll;
    }

    public static void main(String[] args) {
        WaitTest waitTest = new WaitTest();
        Thread consumer = new Thread(() -> {
            try {
                waitTest.take();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        Thread producer = new Thread(() -> waitTest.give("1"));

        consumer.start();
        producer.start();


    }
}
