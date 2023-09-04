package com.wy.spring_demo.service.impl;

import com.wy.spring_demo.entity.UserDO;
import com.wy.spring_demo.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author HelloWorld
 * @date 2023/8/21 22:44
 * @email helloworld.dng@gmail.com
 */
public class LoginServiceImpl implements LoginService {

    @Override
    public UserDO login(HttpServletRequest request, HttpServletResponse response) {
        String user = request.getSession().getAttribute("user").toString();

        UserDO userDO = new UserDO();
        userDO.setUserName(user);

        return userDO;
    }
}
