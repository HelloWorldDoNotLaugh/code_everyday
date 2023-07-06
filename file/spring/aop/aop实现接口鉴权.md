## 实现效果

给需要鉴权的请求方法上加上注解，通过AOP实现增强，检测校验请求中的token

## 1. 创建注解

创建一个加在方法上的注解

```java
package com.wy.spring_demo.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author HelloWorld
 * @create 2023/5/20 19:42
 * @email helloworld.dng@gmail.com
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthChecker {

}

```

## 2. 定义切面

实现解析请求中的token并校验

```java
package com.wy.spring_demo.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
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
```

## 3. 给请求方法中加入注解

```java
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
```

## 4. 测试

### 1）token错误的时候

![image-20230520213015076](/Users/helloworld/Library/Application Support/typora-user-images/image-20230520213015076.png)

![image-20230520213041278](/Users/helloworld/Library/Application Support/typora-user-images/image-20230520213041278.png)

### 2）token正确登录成功

![image-20230520213142548](/Users/helloworld/Library/Application Support/typora-user-images/image-20230520213142548.png)