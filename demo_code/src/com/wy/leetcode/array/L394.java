package com.wy.leetcode.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhangyuyang
 * @since 2024/10/8 13:42
 */
public class L394 {
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        LinkedList<Integer> numberStack = new LinkedList<>();
        LinkedList<String> strStack = new LinkedList<>();

        char[] charArray = s.toCharArray();
        int i = 0;
        while (i < charArray.length) {
            char c = charArray[i];
            if (Character.isDigit(c)) {
                int number = Integer.parseInt(String.valueOf(c));
                i++;
                while (i < charArray.length && Character.isDigit(charArray[i])) {
                    number = number * 10 + Integer.parseInt(String.valueOf(charArray[i]));
                    i++;
                }

                numberStack.offer(number);
                continue;
            }

            if (Character.isLetter(c)) {
                StringBuilder str = new StringBuilder();
                str.append(c);
                i++;
                while (i  < charArray.length && Character.isLetter(charArray[i])) {
                    str.append(charArray[i]);
                    i++;
                }

                strStack.offer(str.toString());
                continue;
            }

            if (c == '[') {
                i++;
                continue;
            }

            if (c == ']') {
                String str = strStack.removeLast();
                int repeat = numberStack.isEmpty() ? 1 : numberStack.removeLast();
                String s1 = addStr(str, repeat);

                if (!strStack.isEmpty()) {
                    s1 = strStack.removeLast() + s1;
                    strStack.offer(s1);
                } else {
                    result.append(s1);
                }
                i++;
            }
        }
        while (!strStack.isEmpty()) {
            result.append(strStack.poll());
        }
        return result.toString();
    }

    private String addStr(String str, int repeat) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < repeat; i++) {
            sb.append(str);
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        String s = "abc3[cd]xyz";
        System.out.println(new L394().decodeString(s));
    }
}
