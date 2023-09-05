package com.wy.spring_demo.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/8/21
 */

@Component("springContextUtil")
public class SpringContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    private static void setContext(ApplicationContext applicationContext) {
        SpringContextUtil.applicationContext = applicationContext;
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        setContext(applicationContext);
    }


    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }

}
