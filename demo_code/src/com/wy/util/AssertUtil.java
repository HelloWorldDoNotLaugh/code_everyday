package com.wy.util;

/**
 * @author HelloWorld
 * @date 2023/9/1 20:10
 * @email helloworld.dng@gmail.com
 */


import java.time.format.DateTimeFormatter;
import java.util.Date;


/**
 * 输入验证类，该类的验证中不符合规则就抛异常，用于强制性约束
 *
 * @author wang xiaobo
 */
public class AssertUtil {

    /**
     * 判定输入不为空，如为空则抛异常
     *
     * @param input
     * @param fieldName 字段名
     */
    public static void isNotNull(Object input, String fieldName) {
        if (input instanceof String) {
            if (input.toString().matches("\\s*")) {
                throw new IllegalArgumentException(fieldName + " 不能为空");
            }
        } else {
            if (input == null) {
                throw new IllegalArgumentException(fieldName + "不能为空");
            }
        }
    }

    public static void main(String[] args) {
        String a = null;
        AssertUtil.isNotNull(a, "a");
    }
}
