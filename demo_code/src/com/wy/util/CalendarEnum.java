package com.wy.util;

import java.util.Arrays;
import java.util.Calendar;

/**
 * @author HelloWorld
 * @date 2023/8/17 13:43
 * @email helloworld.dng@gmail.com
 */
public enum CalendarEnum {
    YEAR("y", Calendar.YEAR),
    MONTH("M", Calendar.MONTH),
    DATE("d", Calendar.DATE),
    HOUR("h", Calendar.HOUR),
    MINUTE("m", Calendar.MINUTE),
    SECOND("s", Calendar.SECOND);
    private String code;
    private int value;

    public String getCode() {
        return code;
    }

    public int getValue() {
        return value;
    }


    CalendarEnum(String code, int value) {
        this.code = code;
        this.value = value;
    }

    public static int matchCalendarValue(String code) {
        if ("m".equalsIgnoreCase(code)) {
            return getValueByCode(code);
        }

        return getValueByCode(code.toLowerCase());
    }



    private static int getValueByCode(String code) {
        return Arrays.stream(CalendarEnum.values())
                .filter(calendarEnum -> code.equals(calendarEnum.code))
                .findFirst().orElseThrow(NullPointerException::new).value;
    }
}
