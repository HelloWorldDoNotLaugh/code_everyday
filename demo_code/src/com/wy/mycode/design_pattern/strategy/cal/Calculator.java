package com.wy.mycode.design_pattern.strategy.cal;

import java.math.BigDecimal;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/8/21
 */
public interface Calculator {

    BigDecimal cal(BigDecimal a, BigDecimal b);
}
