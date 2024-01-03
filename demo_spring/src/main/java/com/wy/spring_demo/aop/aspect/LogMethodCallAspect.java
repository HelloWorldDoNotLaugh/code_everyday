//package com.wy.spring_demo.aop.aspect;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
///**
// * @author HelloWorld
// * @date 2023/11/26 13:43
// * @email helloworld.dng@gmail.com
// */
//@Aspect()
//@Component
//@Slf4j
//public class LogMethodCallAspect {
//
//    @Pointcut("@annotation(com.wy.spring_demo.aop.annotation.Loggable)")
//    public void logMethodCall() {}
//
//    @AfterReturning(pointcut = "logMethodCall()", returning = "result")
//    public void logMethodCallAfterReturning(JoinPoint joinPoint, Object result) {
//        long startTime = System.currentTimeMillis();
//        long executionTime = System.currentTimeMillis() - startTime;
//
//        String className = joinPoint.getTarget().getClass().getSimpleName();
//        String methodName = joinPoint.getSignature().getName();
//
//        log.info("{}.{} params:{} results: {} execution time: {} ms,",
//                className,
//                methodName,
//                joinPoint.getArgs(),
//                result,
//                executionTime);
//    }
//
//}
