package com.wy.spring_demo.service.impl;

import com.wy.spring_demo.entity.UserDO;
import com.wy.spring_demo.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author HelloWorld
 * @date 2023/8/21 22:33
 * @email helloworld.dng@gmail.com
 */
public class NoLoginServiceImpl implements LoginService {
    @Override
    public UserDO login(HttpServletRequest request, HttpServletResponse response) {
        UserDO userDO = new UserDO();
        userDO.setPassword("password");
        userDO.setUserName("admin");
        userDO.setNickName("管理员");

        return userDO;
    }
}
