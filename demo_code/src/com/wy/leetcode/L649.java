package com.wy.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhangyuyang
 * @since 2024/9/24 12:52
 */
public class L649 {
    public String predictPartyVictory(String senate) {
        Deque<Character> deque = new LinkedList<>();
        int dNum = 0;
        int rNum = 0;

        for (char c : senate.toCharArray()) {
            deque.addLast(c);
            if (c == 'D') {
                dNum++;
            } else {
                rNum++;
            }
        }

        int dOut = 0;
        int rOut = 0;
        while (dNum > 0 && rNum > 0) {
            Character c = deque.pollFirst();
            if (c == 'D') {
                dNum--;
                if (dOut > 0) {
                    dOut--;
                } else {
                    rOut++;
                    dNum++;
                    deque.addLast(c);
                }
            }

            if (c == 'R') {
                rNum--;
                if (rOut > 0) {
                    rOut--;
                } else {
                    dOut++;
                    rNum++;
                    deque.addLast(c);
                }
            }
        }

        return dNum > 0 ? "Dire" : "Radiant";
    }

    public static void main(String[] args) {
        L649 l649 = new L649();
        System.out.println(l649.predictPartyVictory("DDRRR"));
    }
}
