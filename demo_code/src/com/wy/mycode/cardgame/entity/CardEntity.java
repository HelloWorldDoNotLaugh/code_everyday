package com.wy.mycode.cardgame.entity;

/**
 * @author HelloWorld
 * @create 2022/9/18 17:02
 * @email helloworld.dng@gmail.com
 */
public class CardEntity {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "CardEntity{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
