package com.wy.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author HelloWorld
 * @create 2023/4/10 14:42
 * @email helloworld.dng@gmail.com
 */
public class NewThreadDomnDemo {
    public static void main(String[] args) {
        new Thread(new Demo1()).start();

        FutureTask futureTask = new FutureTask<>(new Demo2());
        new Thread(futureTask).start();


        new Demo3().start();

    }
}


class Demo1 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Runnable: Hello World");
    }
}

class Demo2 implements Callable{
    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " Callable: Hello World");
        return "Hello World";
    }
}

class Demo3 extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Thread: Hello World");
    }
}