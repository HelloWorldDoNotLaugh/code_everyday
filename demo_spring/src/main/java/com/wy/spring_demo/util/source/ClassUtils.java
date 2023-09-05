package com.wy.spring_demo.util.source;

import com.wy.spring_demo.entity.UserDO;

import java.lang.reflect.InvocationTargetException;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/9/5
 */
public class ClassUtils {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        UserDO userDO = new UserDO();

        UserDO.class.getDeclaredMethod("setUserName", String.class).invoke(userDO, "李华");
        System.out.println(userDO.getUserName());

        Class<?> aClass = org.springframework.util.ClassUtils.forName(UserDO.class.getName(), null);
        aClass.getDeclaredMethod("setUserName", String.class).invoke(userDO, "李阳");

        System.out.println(userDO.getUserName());

        System.out.println(org.springframework.util.ClassUtils.getPackageName(UserDO.class.getName()));

        org.springframework.util.ClassUtils.getMethodIfAvailable(UserDO.class, "setPassword", String.class).invoke(userDO, "1234");
        System.out.println(userDO.getPassword());
    }
}
