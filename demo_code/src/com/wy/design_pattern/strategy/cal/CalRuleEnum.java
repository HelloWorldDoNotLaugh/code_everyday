package com.wy.design_pattern.strategy.cal;

import com.wy.design_pattern.strategy.cal.impl.Mult;
import com.wy.design_pattern.strategy.cal.impl.Sub;
import com.wy.design_pattern.strategy.cal.impl.Add;
import com.wy.design_pattern.strategy.cal.impl.Div;

import java.util.Arrays;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/8/21
 */
public enum CalRuleEnum {
    ADD("add", Add.class.getName()),
    SUB("sub", Sub.class.getName()),
    MULT("mult", Mult.class.getName()),
    DIV("div", Div.class.getName());


    private String code;
    private String className;

    CalRuleEnum(String code, String className) {
        this.code = code;
        this.className = className;
    }


    public String getCode() {
        return code;
    }

    public String getClassName() {
        return className;
    }

    public static String getClassName(String calRule) {
        return Arrays.stream(CalRuleEnum.values())
                .filter(calRuleEnum -> calRuleEnum.code.equalsIgnoreCase(calRule))
                .map(CalRuleEnum::getClassName)
                .findAny().orElseThrow(NoClassDefFoundError::new);
    }

}
