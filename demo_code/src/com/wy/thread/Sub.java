package com.wy.thread;

import org.apache.poi.ss.formula.functions.T;

/**
 * @author HelloWorld
 * @date 2023/12/29 15:54
 * @email helloworld.dng@gmail.com
 */
public class Sub {

    // 假设有10张票
    private static int availableTickets = 10;

    public static void main(String[] args) {
        // 创建多个线程模拟多个用户购买票的情况
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                // 模拟用户购买票的操作
                purchaseTicket();
            }).start();
        }
    }

    private synchronized static void purchaseTicket() {
        // 检查是否还有票可售
        if (availableTickets > 0) {
            // 模拟购票的操作
            System.out.println("User " + Thread.currentThread().getId() + " purchases a ticket.");

            // 模拟耗时操作
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 减少可用票数
            availableTickets--;

            // 输出剩余票数
            System.out.println("Remaining tickets: " + availableTickets);
        } else {
            System.out.println("No more tickets available for user " + Thread.currentThread().getId());
        }
    }
}
