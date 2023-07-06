package com.wy.jvm;

import java.util.ArrayList;

/**
 * @author HelloWorld
 * @create 2023/4/16 17:00
 * @email helloworld.dng@gmail.com
 */
public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(100);
        ArrayList<String> strings = new ArrayList<>();
        while (true) {
            strings.add("helloworld");
        }
    }
}
