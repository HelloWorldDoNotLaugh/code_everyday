package com.wy.thread;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

/**
 * 累积相加
 *
 * @author HelloWorld
 * @date 2023/12/24 21:45
 * @email helloworld.dng@gmail.com
 */
public class CumulativeAddition {
    private static final BigInteger NUM = new BigInteger("1000000000");

    public static void main(String[] args) {
        int[] threadNums = {5, 10, 15, 20, 30, 50, 60, 70, 100, 200, 500, 1000, 10000};
        //int[] threadNums = {15};
        for (int threadNum : threadNums) {
            Long start = System.currentTimeMillis();
            //parallelAdd(NUM, threadNum);
            completableFuture(NUM, threadNum);
            Long end = System.currentTimeMillis();
            System.out.println(threadNum + "线程耗时：" + (end - start));
        }
    }

    private static void serialAdd(BigInteger n) {
        BigInteger sum = BigInteger.ZERO;
        for (BigInteger i = BigInteger.ONE; i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
            sum = sum.add(i);
        }

        System.out.println(sum);
    }

    private static void parallelAdd(BigInteger n, int m) {
        /* 起m个线程并行计算*/

        // 1. 先分割,将n分成m份 4, 8, 12 16 20
        BigInteger[][] tasks;
        BigInteger part = n.divide(BigInteger.valueOf(m));

        BigInteger partSum = part.multiply(BigInteger.valueOf(m));
        if (partSum.compareTo(n) != 0) {
            tasks = new BigInteger[m + 1][2];
            tasks[m][0] = partSum.add(BigInteger.ONE);
            tasks[m][1] = n;
        } else {
            tasks = new BigInteger[m][2];
        }

        for (int i = 1; i <= m; i++) {
            tasks[i - 1][1] = part.multiply(BigInteger.valueOf(i));
            tasks[i - 1][0] = tasks[i - 1][1].subtract(part).add(BigInteger.ONE);
        }

        m = tasks.length;

        // 2. 启动m个线程，执行计算
        BigInteger[] results = new BigInteger[m];
        CountDownLatch countDownLatch = new CountDownLatch(m);
        for (int i = 0; i < m; i++) {
            int finalI = i;
            new Thread(() -> {
                BigInteger sum = BigInteger.ZERO;
                for (BigInteger j = tasks[finalI][0]; j.compareTo(tasks[finalI][1]) <= 0; j = j.add(BigInteger.ONE)) {
                    sum = sum.add(j);
                }
                results[finalI] = sum;
                countDownLatch.countDown();
            }).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        BigInteger sum = BigInteger.ZERO;
        for (BigInteger result : results) {
            sum = sum.add(result);
        }

        System.out.println(sum);
    }


    private static void completableFuture(BigInteger n, int m) {
        //1. 还是先将任务拆分，一定要考虑除不尽的情况
        BigInteger part = n.divide(BigInteger.valueOf(m));
        LinkedList<BigInteger[]> taskList = new LinkedList<>();
        if (part.multiply(BigInteger.valueOf(m)).compareTo(n) != 0) {
            taskList.addLast(new BigInteger[]{part.multiply(BigInteger.valueOf(m)).add(BigInteger.ONE), n});
        }

        for (int i = 1; i <= m; i++) {
            BigInteger bigInteger = part.multiply(BigInteger.valueOf(i));
            taskList.addLast(new BigInteger[]{bigInteger.subtract(part).add(BigInteger.ONE), bigInteger});
        }

        // 2. 利用CompletableFuture实现并行，并调用 CompletableFuture.join获取结果
        Optional<BigInteger> result = taskList.stream().map(bigIntegerArray -> CompletableFuture.supplyAsync(() -> {
            BigInteger sum = BigInteger.ZERO;
            for (BigInteger i = bigIntegerArray[0]; i.compareTo(bigIntegerArray[1]) <= 0; i = i.add(BigInteger.ONE)) {
                sum = sum.add(i);
            }
            return sum;
        })).collect(Collectors.toList()).stream().map(CompletableFuture::join).reduce(BigInteger::add);

        result.ifPresent(System.out::println);
    }

}
