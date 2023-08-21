package com.wy.mycode.design_pattern.strategy.cal.impl;

import com.wy.mycode.design_pattern.strategy.cal.Calculator;

import java.math.BigDecimal;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/8/21
 */
public class Div implements Calculator {

    @Override
    public BigDecimal cal(BigDecimal a, BigDecimal b) {
        return a.divide(b);
    }
}
