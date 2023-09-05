package com.wy.mycode;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/9/5
 */
public class ThrowTest {

    /**
     * @description
     * @author yuyang.zhang
     * @date 2023/9/5 15:23
     * @param args
     * @return void
     *
     *  question：在catch中throw异常，之后的逻辑还会运行吗？
     *  answer：不会，throw后当前逻辑结束
     */
    public static void main(String[] args) {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("还会运行");
    }
}
