package com.wy.thread;

/**
 * @author HelloWorld
 * @create 2023/4/10 17:05
 * @email helloworld.dng@gmail.com
 */
public class InterruptDemo1 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
        });
        thread.start();
        while (!thread.isInterrupted()){
            System.out.println("将线程标记为设置为true");
            thread.interrupt();
            System.out.println(thread.isInterrupted());
        }
    }
}
