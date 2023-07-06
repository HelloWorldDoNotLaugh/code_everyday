package com.wy.leetcode;

/**
 * @author HelloWorld
 * @create 2023/4/1 07:30
 * @email helloworld.dng@gmail.com
 */
public class L831 {
    private static final String EMAIL_SYMBOL = "@";

    public String maskPII(String s) {
        if (s.contains(EMAIL_SYMBOL)) {
            return maskEmail(s);
        }
        return maskPhoneNo(s);
    }

    private String maskEmail(String email) {
        final String encode = "*****";

        email = email.toLowerCase();
        int index = email.lastIndexOf(EMAIL_SYMBOL);
        // 如果名字小于等于1位，不用处理直接返回
        if (index <= 1) {
            return email;
        }

        return email.substring(0, 1) + encode + email.substring(index - 1);
    }

    private String maskPhoneNo(String phoneNum) {
        final String[] CODE_STR_ARRAY = {"***-***-", "+*-***-***-", "+**-***-***-", "+***-***-***-"};

        phoneNum = getNumbers(phoneNum);
        return CODE_STR_ARRAY[phoneNum.length() - 10] + phoneNum.substring(phoneNum.length() - 4);
    }

    private String getNumbers(String str) {
        final String NUM_RULE = "[^\\d]";
        return str.replaceAll(NUM_RULE, "");
    }


    public static void main(String[] args) {
        L831 l831 = new L831();
        System.out.printf(l831.maskPII("AB@qq.com"));
    }

}
