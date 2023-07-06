package com.wy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author HelloWorld
 * @create 2023/5/13 09:46
 * @email helloworld.dng@gmail.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {
    private String sid;
    private String name;
    private String classId;
    private String className;
    private String sex;
    private Integer age;
    private Date makeDate;
    private Date modifyDate;
}
