package com.wy.spring_demo.interceptor;


import cn.hutool.json.JSONUtil;
import com.wy.spring_demo.aop.annotation.Loggable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author HelloWorld
 * @date 2023/11/26 15:41
 * @email helloworld.dng@gmail.com
 */
@Deprecated
@Component("logInterceptor")
@Slf4j
public class LogInterceptor implements HandlerInterceptor {
    private static final String START_TIME_LOG_INTERCEPTOR = "START_TIME_LOG_INTERCEPTOR";
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (shouldNotLog(handler)) {
            return true;
        }

        request.setAttribute(START_TIME_LOG_INTERCEPTOR, System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        if (shouldNotLog(handler)) {
            return;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        String methodName = method.getName();
        String className = method.getDeclaringClass().getSimpleName();

        String params = JSONUtil.toJsonStr(request.getParameterMap());
        String result = JSONUtil.toJsonStr(null == modelAndView ? null : modelAndView.getModel());
        long executionTime = System.currentTimeMillis() - (long) request.getAttribute(START_TIME_LOG_INTERCEPTOR);

        log.info("{}.{}: params:{},  results: {},  execution time: {} ms,",
                className,
                methodName,
                params,
                result,
                executionTime);
    }


    private boolean shouldNotLog(Object handler) {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        return !method.isAnnotationPresent(Loggable.class);
    }

}
