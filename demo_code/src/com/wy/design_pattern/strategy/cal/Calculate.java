package com.wy.design_pattern.strategy.cal;

import java.math.BigDecimal;

/**
 * @author yuyang.zhang
 * @Description 策略模式实现简易计算器
 * @date 2023/8/21
 */
public class Calculate {

    public static BigDecimal cal(BigDecimal a, BigDecimal b, String calRule) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String className = CalRuleEnum.getClassName(calRule);
        Calculator calculator = (Calculator)Class.forName(className).newInstance();
        return calculator.cal(a, b);
    }
}
