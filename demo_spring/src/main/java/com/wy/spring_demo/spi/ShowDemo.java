package com.wy.spring_demo.spi;

import java.util.ServiceLoader;

public class ShowDemo {
    public static void main(String[] args) {
        ServiceLoader<SayHello> sayHelloServiceLoader = ServiceLoader.load(SayHello.class);
        sayHelloServiceLoader.forEach(SayHello::sayHello);
    }
}
