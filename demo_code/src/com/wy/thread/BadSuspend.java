package com.wy.thread;

import java.util.Objects;

/**
 * @author HelloWorld
 * @create 2022/11/13 08:44
 * @email helloworld.dng@gmail.com
 */
public class BadSuspend {
    public static Object oj = new Object();

    public static class ChangeObjectThread extends Thread {
        public ChangeObjectThread(String name) {
            super.setName(name);
        }

        @Override
        public void run() {
            synchronized (oj) {
                System.out.println("in " + getName());
                Thread.currentThread().suspend();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ChangeObjectThread t1 = new ChangeObjectThread("t1");
        ChangeObjectThread t2 = new ChangeObjectThread("t2");

        t1.start();
        Thread.sleep(1000);

        t2.start();

        t1.resume();
        t2.resume();

        t1.join();
        t2.join();

        // 程序不会退出，会被挂起
    }

}
