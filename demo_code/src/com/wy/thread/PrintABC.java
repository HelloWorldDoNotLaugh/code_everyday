package com.wy.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangyuyang
 * @since 2024/9/9 14:08
 */
public class PrintABC {


    static class LockAndCondition {
        private static final Lock lock = new ReentrantLock();

        private static final Condition conditionA = lock.newCondition();
        private static final Condition conditionB = lock.newCondition();
        private static final Condition conditionC = lock.newCondition();

        private static int state = 0;

        public static void main(String[] args) {
            Thread aThread = new Thread(new PrintTask("A", 0, conditionA, conditionB));
            Thread bThread = new Thread(new PrintTask("B", 1, conditionB, conditionC));
            Thread cThread = new Thread(new PrintTask("C", 2, conditionC, conditionA));

            aThread.start();
            bThread.start();
            cThread.start();
        }

        static class PrintTask implements Runnable{

            private String letter;

            private int threadId;

            private Condition currentCondition;

            private Condition nextCondition;

            public PrintTask(String letter, int threadId, Condition currentCondition, Condition nextCondition) {
                this.letter = letter;
                this.threadId = threadId;
                this.currentCondition = currentCondition;
                this.nextCondition = nextCondition;
            }

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    lock.lock();
                    try {
                        while (state % 3 != threadId) {
                            currentCondition.await();
                        }
                        System.out.println(letter);
                        state++;
                        nextCondition.signal();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }finally {
                        lock.unlock();
                    }
                }
            }
        }
    }

    static class waitAndNotify {

    }

}
