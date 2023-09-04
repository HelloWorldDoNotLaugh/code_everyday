package com.wy.spring_demo.service;

import com.wy.spring_demo.entity.UserDO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author HelloWorld
 * @date 2023/8/21 22:34
 * @email helloworld.dng@gmail.com
 */
public interface LoginService {
    UserDO login(HttpServletRequest var1, HttpServletResponse var2);
}
