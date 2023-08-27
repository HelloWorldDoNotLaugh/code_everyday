package com.wy.spring_demo.interceptor;

import com.wy.spring_demo.entity.UserDO;
import com.wy.spring_demo.service.LoginService;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author HelloWorld
 * @date 2023/8/21 22:23
 * @email helloworld.dng@gmail.com
 */
@Component
public class AppInterceptor implements HandlerInterceptor {
    @Resource
    private LoginService loginService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        if (StringUtils.startsWithIgnoreCase(uri, "/api")) {
            UserDO login = loginService.login(request, response);
            request.getSession().setAttribute("loginUser", login);
        }
        return true;
    }

}
