package com.wy.thread;

/**
 * @author HelloWorld
 * @create 2023/4/10 15:48
 * @email helloworld.dng@gmail.com
 */
public class InterruptDemo {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            int count = 0;
            while (!Thread.currentThread().isInterrupted() && count < 30) {
                System.out.println(String.format("name: %s, interrupt: %s, %s", Thread.currentThread().getName(), Thread.currentThread().isInterrupted(), count++));
//                try {
//                    Thread.sleep(50);
//                } catch (InterruptedException e) {
//                    // 抛出异常的同时会清除中断标记位，即将 interrupt再设置为false
//                    System.out.println("thread1 sleep期间 被尝试中断了");
//                }
            }
        }, "thread1");
        System.out.println("准备开启子线程 thread1");

        thread1.start();

        System.out.println("thread1开始执行");

        while (!thread1.isInterrupted()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("休眠主线程异常");
            }finally {
                System.out.println("将thread1的interrupt设置为true");
                thread1.interrupt();
                System.out.println("thread1的 interrupt 状态为" + thread1.isInterrupted());
            }
        }

        System.out.println("thread1的 interrupt 状态为" + thread1.isInterrupted());

    }
}
