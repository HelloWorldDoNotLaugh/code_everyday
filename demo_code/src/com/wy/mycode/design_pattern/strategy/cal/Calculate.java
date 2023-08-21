package com.wy.mycode.design_pattern.strategy.cal;

import com.wy.mycode.design_pattern.strategy.cal.Calculator;

import java.math.BigDecimal;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/8/21
 */
public class Calculate {

    public static BigDecimal cal(BigDecimal a, BigDecimal b, String calRule) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String className = CalRuleEnum.getClassName(calRule);
        Calculator calculator = (Calculator)Class.forName(className).newInstance();
        return calculator.cal(a, b);
    }
}
