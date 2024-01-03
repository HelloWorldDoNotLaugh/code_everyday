package com.wy.spring_demo.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author HelloWorld
 * @date 2023/11/26 11:26
 * @email helloworld.dng@gmail.com
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Loggable {

}
