package com.wy.thread;

import java.util.concurrent.Semaphore;


/**
 * 按须打印
 * @author HelloWorld
 * @create 2022/11/3 21:20
 * @email helloworld.dng@gmail.com
 */
public class T1114 {
    private final Semaphore first_to_second =new Semaphore(0);

    private final Semaphore second_to_third =new Semaphore(0);

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        first_to_second.release();//通知第二个线程
    }

    public void second(Runnable printSecond) throws InterruptedException {
        first_to_second.acquire();//收到第一个线程的信息
        printSecond.run();
        second_to_third.release();//通知第三个线程
    }

    public void third(Runnable printThird) throws InterruptedException {
        second_to_third.acquire();//收到第二个线程的信息
        printThird.run();
    }

    public static void main(String[] args) {
        T1114 t1114 = new T1114();
        //boolean b = t1114.tryTest(2);
        Thread t2 = new Thread(() -> {
            try {
                t1114.second(() -> System.out.println("2"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t1 = new Thread(() -> {
            try {
                t1114.first(() -> System.out.println("1"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                t1114.third(() -> System.out.println("3"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t3.start();

        t2.start();

        t1.start();
    }

    private boolean tryTest(int v) {
        throw new UnsupportedOperationException();
    }

}
