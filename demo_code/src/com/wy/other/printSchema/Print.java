package com.wy.other.printSchema;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author HelloWorld
 * @create 2023/4/4 22:54
 * @email helloworld.dng@gmail.com
 */
@Slf4j
public class Print {
    private static final Set<String> excludes = new HashSet<>(Arrays.asList("class", "modifyDate", "modifyTime"));
    private static final List<String> priorityList;
    static {
        priorityList = Arrays.asList("Name", "IdNo", "Age", "ClassName").stream()
                .map(str -> str.substring(0, 1).toLowerCase() + str.substring(1))
                .sorted(((o1, o2) -> -1))
                .collect(Collectors.toList());
    }

    /**
     * @description 将实体按照 属性名：值 拼串，并用逗号隔开
     * @author HelloWorld
     * @create 2023/4/5 09:02
     * @param studentSchema
     * @return java.lang.String
     */
    public String getInfo(StudentSchema studentSchema) {
        PropertyDescriptor[] propertyDescriptors;
        try {
            propertyDescriptors = Introspector.getBeanInfo(studentSchema.getClass()).getPropertyDescriptors();
        } catch (IntrospectionException e) {
            log.error("实体解析异常，只打印简单信息", e);
            return getSimpleInfo(studentSchema);
        }
        String resultStr = Arrays.stream(propertyDescriptors)
                .map(PropertyDescriptor::getName)
                .filter(name -> !excludes.contains(name))
                .sorted((o1, o2) -> priorityList.indexOf(o2) - priorityList.indexOf(o1))
                .map(name -> {
                    Object value;
                    try {
                        value = new PropertyDescriptor(name, studentSchema.getClass()).getReadMethod().invoke(studentSchema);
                    } catch (Exception e) {
                        log.error(String.format("获取属性值-%s异常", name), e);
                        return null;
                    }
                    if (value instanceof Date) {
                        value = ((Date) value).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    }
                    return name + ": " + value;
                })
                .filter(StrUtil::isNotBlank)
                .collect(Collectors.joining(", "));
        return String.format("StudentSchema: {%s}", resultStr);
    }


    /**
     * @description 返回简要信息串
     * @author HelloWorld
     * @create 2023/4/5 09:04
     * @param studentSchema
     * @return java.lang.String
     */
    public String getSimpleInfo(StudentSchema studentSchema) {
        return String.format("StudentSchema: {name: %s, idType: %s, idNo: %s}",
                studentSchema.getName(),
                studentSchema.getIdType(),
                studentSchema.getIdNo());
    }

    public static void main(String[] args) {
        Print print = new Print();
        System.out.println(print.getInfo(getTestData()));
    }


    private static StudentSchema getTestData() {
        StudentSchema studentSchema = new StudentSchema();
        studentSchema.setName("李白");
        studentSchema.setAge(19);
        studentSchema.setBirthday("2001-08-01");
        studentSchema.setCountry("China");
        studentSchema.setIdNo("4112991729102121");
        studentSchema.setIdType("00");
        studentSchema.setMakeDate(new Date());
        studentSchema.setMakeTime(DateUtil.formatTime(new Date()));
        studentSchema.setModifyDate(new Date());
        studentSchema.setModifyTime(DateUtil.formatTime(new Date()));
        studentSchema.setClassName("六年级");

        return studentSchema;
    }
}
