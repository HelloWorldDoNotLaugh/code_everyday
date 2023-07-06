package com.wy.leetcode;

import java.util.Scanner;

/**
 * @author HelloWorld
 * @create 2022/8/3 22:26
 * @email helloworld.dng@gmail.com
 */
public class SwitchIP {

    /** 转义后的点 */
    private static final String POINT_SYMBOL_TRANS = "\\.";

    private static final String POINT_SYMBOL = ".";

    private static final String ZERO_SYMBOL = "0";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String inputStr = scanner.next();
            String result = dealInput(inputStr);
            System.out.println(result);
        }
    }

    /**
     * @description 如果含有 点，即需要将ip转为十进制数，反之 十进制数转ip
     * @author HelloWorld
     * @create 2022/8/3 22:35
     * @param inputStr
     * @return java.lang.String
     */
    private static String dealInput(String inputStr) {
        // 含有 点 说明是 ip地址
        if (inputStr.contains(POINT_SYMBOL)) {
            return switchIp2Num(inputStr);
        }
        return switchNum2Ip(inputStr);
    }

    /**
     * @description 将ip地址转为10进制数
     * @author HelloWorld
     * @create 2022/8/3 22:37
     * @param ip
     * @return java.lang.String
     */
    private static String switchIp2Num(String ip) {
        String binaryString = "";
        /* 坑: 用点分隔字符串需要转义 */
        for (String s : ip.split(POINT_SYMBOL_TRANS)) {
            String tempStr = Integer.toBinaryString(Integer.parseInt(s));
            // 不满足8位时补0
            binaryString += appendZero(tempStr, 8);
        }
        return Long.parseLong(binaryString, 2) + "";
    }

    /**
     * @description 用0补全字符串到期望到长度
     * @author HelloWorld
     * @create 2022/8/3 22:59
     * @param str
     * @param expectLength
     * @return java.lang.String
     */
    private static String appendZero(String str, int expectLength) {
        while (str.length() < expectLength) {
            str = ZERO_SYMBOL + str;
        }
        return str;
    }

    /**
     * @description 将10进制数转ip
     * @author HelloWorld
     * @create 2022/8/3 22:37
     * @param num
     * @return java.lang.String
     */
    private static String switchNum2Ip(String num) {
        String ip = "";
        String binaryString = appendZero(Long.toBinaryString(Long.parseLong(num)), 32);
        for (int i = 0; i < binaryString.length(); i = i + 8) {
            ip += Integer.parseInt(binaryString.substring(i, i + 8), 2) + POINT_SYMBOL;
        }
        // 去掉最后一个点
        return ip.substring(0, ip.length() - 1);
    }
}
