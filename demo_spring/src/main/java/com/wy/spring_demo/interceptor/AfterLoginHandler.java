package com.wy.spring_demo.interceptor;

import com.wy.spring_demo.entity.UserDO;

/**
 * @author HelloWorld
 * @date 2023/8/21 23:23
 * @email helloworld.dng@gmail.com
 */
public interface AfterLoginHandler {
    void handler(UserDO var1);
}
