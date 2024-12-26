package com.wy.spring_demo.ioc;

import org.springframework.stereotype.Component;

/**
 * @author zhangyuyang
 * @create 2024/7/22 14:23
 */
@Component("huahua")
public class Dog implements Animal{
    @Override
    public String getName() {
        return "huahua";
    }
}
