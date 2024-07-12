package com.wy.json;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author zhangyuyang
 * @create 2024/3/7 17:54
 */
public class TestJSON {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Student> students = new ArrayList<>();

        students.add(Student.builder().name("11").age(2).build());
        students.add(Student.builder().name("11").age(3).build());
        students.add(Student.builder().name("11").age(4).build());

        ArrayList<Student> students1 = new ArrayList<>(students.stream()
                .collect(Collectors.toMap(Student::getName, Function.identity(), (existing, replacement) -> existing))
                .values());
        System.out.println(students1);
    }

    private static String getSetFunName(String fieldName) throws Exception{
        Student student = new Student();

        Method method = student.getClass().getMethod(getSetFunName(Student.Fields.name), String.class);
        method.invoke(student,"1111");

        System.out.println(student.getName());
        return "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    }
}


