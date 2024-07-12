package com.wy.thread;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author zhangyuyang
 * @create 2024/2/22 15:00
 */
public class BlockingQueueLearning {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    queue.put(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("生产者生产数据：" + i);
            }
        });

        Thread consumer = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("消费者消费数据：" + queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer2 = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("消费者2消费数据：" + queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();
        consumer2.start();

        producer.join();
        consumer.join();
        consumer2.join();
    }
}
