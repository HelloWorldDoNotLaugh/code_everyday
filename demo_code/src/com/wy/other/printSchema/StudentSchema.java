package com.wy.other.printSchema;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author HelloWorld
 * @create 2023/4/4 22:51
 * @email helloworld.dng@gmail.com
 */

public class StudentSchema {
    private String Name;
    private String IdType;

    private String IdNo;

    private String ClassName;

    private String Country;

    private Integer Age;

    private String Birthday;

    private String Happy;

    private String Sex;

    private BigDecimal Score;

    private Date MakeDate;

    private String MakeTime;

    private Date ModifyDate;

    private String ModifyTime;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getIdType() {
        return IdType;
    }

    public void setIdType(String idType) {
        IdType = idType;
    }

    public String getIdNo() {
        return IdNo;
    }

    public void setIdNo(String idNo) {
        IdNo = idNo;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public String getHappy() {
        return Happy;
    }

    public void setHappy(String happy) {
        Happy = happy;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public BigDecimal getScore() {
        return Score;
    }

    public void setScore(BigDecimal score) {
        Score = score;
    }

    public Date getMakeDate() {
        return MakeDate;
    }

    public void setMakeDate(Date makeDate) {
        MakeDate = makeDate;
    }

    public String getMakeTime() {
        return MakeTime;
    }

    public void setMakeTime(String makeTime) {
        MakeTime = makeTime;
    }

    public Date getModifyDate() {
        return ModifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        ModifyDate = modifyDate;
    }

    public String getModifyTime() {
        return ModifyTime;
    }

    public void setModifyTime(String modifyTime) {
        ModifyTime = modifyTime;
    }
}
