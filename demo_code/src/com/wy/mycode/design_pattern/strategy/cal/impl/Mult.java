package com.wy.mycode.design_pattern.strategy.cal.impl;

import com.wy.mycode.design_pattern.strategy.cal.Calculator;

import java.math.BigDecimal;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/8/21
 */
public class Mult implements Calculator {
    @Override
    public BigDecimal cal(BigDecimal a, BigDecimal b) {
        return a.multiply(b);
    }
}
