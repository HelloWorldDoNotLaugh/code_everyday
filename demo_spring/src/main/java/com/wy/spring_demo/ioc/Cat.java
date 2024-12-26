package com.wy.spring_demo.ioc;

import org.springframework.stereotype.Component;

/**
 * @author zhangyuyang
 * @create 2024/7/22 14:24
 */
@Component
public class Cat implements Animal{
    @Override
    public String getName() {
        return "cat";
    }
}
