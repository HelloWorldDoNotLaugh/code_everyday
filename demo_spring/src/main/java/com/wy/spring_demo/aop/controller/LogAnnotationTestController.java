package com.wy.spring_demo.aop.controller;

import com.wy.spring_demo.aop.annotation.Loggable;
import org.springframework.aop.framework.AopContext;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author HelloWorld
 * @date 2023/11/26 13:53
 * @email helloworld.dng@gmail.com
 */
@RestController
@RequestMapping("/log")
public class LogAnnotationTestController {

    @Resource
    private ApplicationContext applicationContext;
    @Loggable
    @GetMapping("/test/{name}/{age}")
    public String test(@PathVariable("name") String name, @PathVariable("age") int age) {
        return testService(name, age, "boy");
    }


    @Loggable
    public String testService(String name, int age, String sex) {
        return String.format("%s is %s years old; wy is a %s", name, age, sex);
    }
}
