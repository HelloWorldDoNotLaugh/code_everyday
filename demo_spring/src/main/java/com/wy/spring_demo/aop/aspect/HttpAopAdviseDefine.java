package com.wy.spring_demo.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author HelloWorld
 * @create 2023/5/20 19:44
 * @email helloworld.dng@gmail.com
 */
@Component
@Aspect
public class HttpAopAdviseDefine {
    private static final String TOKEN_VALUE = "123456789";
    @Pointcut("@annotation(com.wy.spring_demo.aop.annotation.AuthChecker)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object checkAuth(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("开始鉴权");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = getUserToken(request);
        if (!token.equalsIgnoreCase(TOKEN_VALUE)) {
            throw new RuntimeException("token错误或缺失，鉴权不通过");
        }

        return joinPoint.proceed();
    }

    private String getUserToken(HttpServletRequest request) {
        return Arrays.stream(request.getCookies())
                .filter(cookie -> cookie.getName().equalsIgnoreCase("user_token"))
                .map(cookie -> cookie.getValue())
                .findFirst()
                .orElse("");
    }
}
