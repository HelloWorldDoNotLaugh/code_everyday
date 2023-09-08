package com.wy.leetcode.math;

/**
 * @author yuyang.zhang
 * @Description: 2651. 计算列车到站时间
 * @date 2023/9/8
 */
public class L2651 {

    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime+delayedTime) % 24;
    }
}
