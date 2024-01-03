package com.wy;

/**
 * @author HelloWorld
 * @date 2023/10/23 13:12
 * @email helloworld.dng@gmail.com
 */
public class L2678 {
    public int countSeniors(String[] details) {
        int result = 0;

        for (String detail : details) {
            int age = Integer.parseInt(detail.substring(11, 13));
            if (age > 60) {
                result++;
            }
        }

        return result;
    }
}
