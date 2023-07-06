package com.wy.invoke;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class InvokeUtil {
    public static <T>Map<String, Object> beanToMap(T bean) throws Exception{
        Map<String, Object> resultMap = new HashMap<>();

        PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(bean.getClass()).getPropertyDescriptors();
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            resultMap.put(propertyDescriptor.getName(), propertyDescriptor.getReadMethod().invoke(bean));
        }

        return resultMap;
    }

    public static Field[] getAllFields(Object bean) {
        return bean.getClass().getDeclaredFields();
    }

    public static  <T> T setValue(T t, String functionName, Object value) throws Exception{
        t.getClass().getMethod(functionName, value.getClass()).invoke(t, value);
        return t;
    }
}
