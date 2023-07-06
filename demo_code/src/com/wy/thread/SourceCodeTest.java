package com.wy.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author HelloWorld
 * @create 2022/10/24 19:18
 * @email helloworld.dng@gmail.com
 */
public class SourceCodeTest {
    public static void main(String[] args) {
        System.out.println(1111);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,
                3,
                100L,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(500),
                new NameThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 10; i++) {
            MyTask myTask = new MyTask(String.valueOf(i));
            executor.execute(myTask);
        }

        System.out.println(">>>>>>>>>>>>over");
        Thread thread = new Thread();

    }

    static class NameThreadFactory implements ThreadFactory {
        private final AtomicInteger atomicInteger = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, "my-thread-" + atomicInteger.getAndIncrement());
            System.out.println(t.getName() + "被创建");
            return t;
        }
    }



    static class MyTask implements Runnable {
        private String name;

        public MyTask(String name) {
            this.name = name;
        }
        @Override
        public void run() {
            System.out.println(this.toString() + "正在运行");
            System.out.println(this.toString() + "执行完毕");
        }

        @Override
        public String toString() {
            return "MyTask [name=" + name + "]";
        }
    }
}
