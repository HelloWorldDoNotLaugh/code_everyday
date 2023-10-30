package com.wy.spring_demo.skill;

import cn.hutool.core.map.MapUtil;
import lombok.Data;

import java.util.Map;
import java.util.function.Consumer;

/**
 * @author HelloWorld
 * @date 2023/10/7 15:06
 * @email helloworld.dng@gmail.com
 */
public class FunctionMap {

    private Student student;

    private Map<ActionEnum, Consumer<Student>> getActionMap() {
        return MapUtil.<ActionEnum, Consumer<Student>>builder()
                .put(ActionEnum.SET_NAME, this::setName)
                .put(ActionEnum.SET_AGE, this::setAge)
                .put(ActionEnum.SET_SEX, this::setSex)
                .map();
    }

    public FunctionMap() {
        this.student = new Student();
    }


    public static void main(String[] args) {
        FunctionMap functionMap = new FunctionMap();
        Map<ActionEnum, Consumer<Student>> actionMap = functionMap.getActionMap();
        actionMap.get(ActionEnum.SET_AGE).accept(functionMap.student);

        System.out.println(functionMap.student.age);
    }

    private void setName(Student student) {
        student.setName("张三");
    }

    private void setSex(Student student) {
        student.setSex("男");
    }

    private void setAge(Student student) {
        student.setAge(18);
    }

    @Data
    class Student{
        private String name;
        private String sex;
        private int age;
    }

    enum ActionEnum {
        SET_NAME("setName", "设置姓名"),
        SET_SEX("setSex", "设置性别"),
        SET_AGE("setAge", "设置年龄");

        private String code;
        private String desc;

        ActionEnum(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }
    }
}
