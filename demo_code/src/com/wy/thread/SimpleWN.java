package com.wy.thread;

/**
 * @author HelloWorld
 * @create 2022/11/13 08:24
 * @email helloworld.dng@gmail.com
 */
public class SimpleWN {
    final static Object oj = new Object();
    public static class T1 extends Thread {
        @Override
        public void run(){
            synchronized (oj) {
                System.out.println(System.currentTimeMillis() + ": T1 start!");
                try {
                    System.out.println(System.currentTimeMillis() + ": T1 wait for object");
                    oj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ": T1 end!");
            }
        }
    }

    public static class T2 extends Thread {
        @Override
        public void run() {
            synchronized (oj) {
                System.out.println(System.currentTimeMillis() + ": T2 start! notify one thread");
                oj.notify();
                System.out.println(System.currentTimeMillis() + " T2 end!");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new T1();
        Thread t2 = new T2();
        t1.start();
        t2.start();
        // t2的run方法执行完成后，才会执行t1
    }
}
