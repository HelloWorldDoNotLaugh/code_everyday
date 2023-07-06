package com.wy.spring_demo.aop.controller;

import com.wy.spring_demo.aop.annotation.AuthChecker;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HelloWorld
 * @create 2023/5/20 20:18
 * @email helloworld.dng@gmail.com
 */
@RestController
public class DemoController {

    @AuthChecker
    @RequestMapping("/aop/logging")
    public String login() {
        return "用户登录成功";
    }
}
