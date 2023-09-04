package com.wy.spring_demo.interceptor.config;

import com.wy.spring_demo.interceptor.AppInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author HelloWorld
 * @date 2023/8/21 22:56
 * @email helloworld.dng@gmail.com
 */
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

    @Resource
    private AppInterceptor appInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(appInterceptor).addPathPatterns("/api/**");
    }
}
