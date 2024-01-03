package com.wy.spring_demo.interceptor.config;

import com.wy.spring_demo.interceptor.AppInterceptor;
import com.wy.spring_demo.interceptor.LogInterceptor;
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

    @Resource
    private LogInterceptor logInterceptor;
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(appInterceptor).addPathPatterns("/api/**");
        registry.addInterceptor(logInterceptor);
    }
}
