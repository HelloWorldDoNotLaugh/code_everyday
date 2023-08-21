package com.wy.mycode.design_pattern.strategy.cal;

import cn.hutool.core.math.Calculator;

import java.math.BigDecimal;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/8/21
 */
public class CalTest {
    public static void main(String[] args) throws Exception{
        BigDecimal a = new BigDecimal("3");
        BigDecimal b = new BigDecimal("5");

        BigDecimal add = Calculate.cal(a, b, "div");

        System.out.println(add.toString());
    }
}
