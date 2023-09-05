package com.wy.design_pattern.strategy.cal;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/8/21
 */
public class CalTest {
    private static final Pattern PROPERTY_PATTERN = Pattern.compile("^[a-z][a-z0-9_]{0,49}$");
    public static void main(String[] args) throws Exception{
        String value = "id";
        Matcher matcher = PROPERTY_PATTERN.matcher(value);
        if (!matcher.matches()) {
            System.out.println(matcher.toString());
        }
    }
}
