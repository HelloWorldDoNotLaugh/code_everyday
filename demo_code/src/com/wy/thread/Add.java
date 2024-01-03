//package com.wy.thread;
//
//import java.util.ArrayList;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.atomic.AtomicInteger;
//
///**
// * @author HelloWorld
// * @date 2023/12/29 15:17
// * @email helloworld.dng@gmail.com
// */
//public class Add {
//    private static int counter;
//    public static void main(String[] args) {
//        System.out.println(add(10000, 100));
//    }
//
//
//    private static int add(int nums, int n) {
//
//        final int[] result = {0};
//        ArrayList<int[]> tasks = splitTask(nums, n);
//        counter = n;
//        for (int[] task : tasks) {
//            System.out.println(Thread.currentThread().getName());
//                int partSum = 0;
//                for (int i = task[0]; i <= task[1] ; i++) {
//                    partSum += i;
//                }
//                result[0] += partSum;
//                counter--;
//            });
//        }
//
//        while (counter > 0) {
//        }
//        executor.shutdown();
//        return result[0];
//    }
//
//    /**
//     * @description 任务拆分
//     * @author HelloWorld
//     * @create 2023/12/29 15:21
//     * @param nums  int 总量
//     * @param n int 要拆分出的个数
//     * @return void
//     */
//    private static ArrayList<int[]>  splitTask(int nums, int n) {
//        ArrayList<int[]> tasks = new ArrayList<>();
//        int split = nums / n;
//        for (int i = 1; i <= n; i++) {
//            tasks.add(new int[]{split * i - split + 1, split * i});
//        }
//
//        // 如果除不尽，最后一个多分些
//        tasks.get(n-1)[1] = nums;
//
//        return tasks;
//    }
//}
