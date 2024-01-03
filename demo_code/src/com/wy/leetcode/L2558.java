package com.wy.leetcode;

import java.util.Arrays;

/**
 * @author HelloWorld
 * @date 2023/10/28 18:39
 * @email helloworld.dng@gmail.com
 */
public class L2558 {
    public long pickGifts(int[] gifts, int k) {
        for (int i = 0; i < k; i++) {
            pick(gifts);
        }

        return Arrays.stream(gifts).mapToLong(gift -> gift).sum();
    }

    private void pick(int[] gifts) {
        int max = gifts[0];
        int index = 0;
        for (int i = 1; i < gifts.length; i++) {
            if (max < gifts[i]) {
                index = i;
                max = gifts[i];
            }
        }

        gifts[index] = (int)Math.floor(Math.sqrt(max));
    }
}
