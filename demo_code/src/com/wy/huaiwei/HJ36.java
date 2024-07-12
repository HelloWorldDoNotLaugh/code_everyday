package com.wy.huaiwei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author HelloWorld
 * @create 2022/8/7 10:27
 * @email helloworld.dng@gmail.com
 * HJ36 字符串加密
 */
public class HJ36 {
    /*
            1. 获得新的字母表。输入的 key + [a-z] 并去重得到新的字母表
            2. 取出明文对应的字母得到密文
    */

    /** 标准字母表 */
    private static final String STANDARD_TABLE = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String key = scanner.next();
        String msg = scanner.next();

        doDealInput(key, msg);
    }

    private static void doDealInput(String key, String msg) {
        // 1. 获取新的字母表
        String newTable = getNewTable(key);
        // 2. 获取密文
        String keyword = getKeyword(msg, newTable);

        System.out.println(keyword);
    }

    /**
     * @description 获取新的字母表
     * @author HelloWorld
     * @create 2022/8/7 10:39
     * @param key
     * @return java.lang.String
     */
    private static String getNewTable(String key) {
        String temp = "";
        String table = STANDARD_TABLE;
        for (char c : key.toCharArray()) {
            // key 中字母去重
            if (!temp.contains(c + "")) {
                temp += c;
            }
            table = table.replace(c + "", "");
        }
        return temp + table;
    }

    /**
     * @description 加密明文
     * @author HelloWorld
     * @create 2022/8/7 10:41
     * @param msg
     * @param newTable
     * @return java.lang.String
     */
    private static String getKeyword(String msg, String newTable) {
        String keyword = "";
        for (char c : msg.toCharArray()) {
            int index = c - 'a';
            keyword += newTable.toCharArray()[index];
        }

        return keyword;
    }
}
