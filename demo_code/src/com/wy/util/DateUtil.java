package com.wy.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author HelloWorld
 * @date 2023/8/17 13:42
 * @email helloworld.dng@gmail.com
 */
public class DateUtil {
    private static final String REGEX = "(.+)([+-]\\d+[yYmMdDhHsS])";

    public static String format2String(String format) {
        Matcher matcher = Pattern.compile(REGEX).matcher(format);
        boolean isRelativeDate = matcher.find();
        // 相对日期处理
        if (isRelativeDate) {
            return getRelativeDateString(matcher.group(1), matcher.group(2));
        }

        return getDateString(format);
    }

    private static String getRelativeDateString(String dateFormat, String relativeRule) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        int calNum = Integer.parseInt(relativeRule.substring(1, relativeRule.length()-1));
        if (relativeRule.startsWith("-")) {
            calNum = calNum * -1;
        }

        String calUnit = relativeRule.substring(relativeRule.length() - 1);
        calendar.add(CalendarEnum.matchCalendarValue(calUnit), calNum);

        return new SimpleDateFormat(dateFormat).format(calendar.getTime());
    }


    private static String getDateString(String dateFormat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        return simpleDateFormat.format(new Date());
    }
}
