package com.wy.leetcode;

import java.util.*;

/**
 * @author HelloWorld
 * @create 2022/4/19 22:02
 * @email helloworld.dng@gmail.com
 */
public class DeleteMinTimeLetter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(delete(str));

    }

    /**
     * @description HJ23 删除字符串中出现次数最少的字符
     * @author HelloWorld
     * @create 2022/4/19 23:09
     * @param str
     * @return java.lang.String
     */
    public static String delete(String str) {
        TreeMap<Character, Integer> map = new TreeMap<>();

        // 记录每个字符出现的次数
        for (char c : str.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }else {
                map.put(c, 1);
            }
        }

        // 将 map 按 value升序排序
        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, Comparator.comparing(Map.Entry::getValue));

        String newStr = str;
        for (int i = 0; i < list.size(); i++) {
            Map.Entry<Character, Integer> entry = list.get(i);
            newStr = newStr.replace(entry.getKey() + "", "");
            if (i != list.size() - 1 && entry.getValue().equals(list.get(i+1).getValue())) {
                continue;
            }
            return newStr;
        }
        return newStr;
    }

}
