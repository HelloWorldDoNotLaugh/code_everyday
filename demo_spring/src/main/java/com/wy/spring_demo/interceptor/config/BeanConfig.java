package com.wy.spring_demo.interceptor.config;

import com.wy.spring_demo.service.LoginService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author HelloWorld
 * @date 2023/8/21 23:13
 * @email helloworld.dng@gmail.com
 */

@Configuration
public class BeanConfig {

    @Value("${login.service}")
    private String loginServiceClassName;

    @Bean
    public LoginService loginService() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        return (LoginService)Class.forName(loginServiceClassName).newInstance();
    }
}
