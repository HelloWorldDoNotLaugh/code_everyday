package com.wy.spring_demo.spi.service;

import com.wy.spring_demo.spi.SayHello;

public class HelloJavaService implements SayHello {
    @Override
    public void sayHello() {
        System.out.println("Hello Java");
    }
}
