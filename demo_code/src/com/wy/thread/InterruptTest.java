package com.wy.thread;

/**
 * @author HelloWorld
 * @create 2022/11/12 10:15
 * @email helloworld.dng@gmail.com
 */
public class InterruptTest {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("线程中断");
                        break;
                    }
                    Thread.yield();
                }
            }
        };
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 只是 interrupt只是设置了线程中断标志位，但并不能停止线程
        thread.interrupt();
    }
}
