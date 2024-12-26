package com.wy.thread;

import cn.hutool.core.util.RandomUtil;

import java.util.Random;

/**
 * @author zhangyuyang
 * @create 2024/7/22 13:45
 */
public class PublicPropertiesTest {

    private Student student;

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                PublicPropertiesTest publicPropertiesTest = new PublicPropertiesTest();
                publicPropertiesTest.student = new Student();
                publicPropertiesTest.student.setName(RandomUtil.randomString(2));
                System.out.println(Thread.currentThread().getName() + " " + publicPropertiesTest.student.name);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " " + publicPropertiesTest.student.name);
            }).run();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                PublicPropertiesTest publicPropertiesTest = new PublicPropertiesTest();
                publicPropertiesTest.student = new Student();
                publicPropertiesTest.student.setName(RandomUtil.randomString(2));
                System.out.println(Thread.currentThread().getName() + " " + publicPropertiesTest.student.name);
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " " + publicPropertiesTest.student.name);
            }).run();
        }


    }

    static class Student {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
