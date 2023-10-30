package com.wy.spring_demo.skill.taskChain.impl;

import com.wy.spring_demo.skill.taskChain.MoveEleTaskChain;
import org.springframework.stereotype.Component;

/**
 * @author HelloWorld
 * @date 2023/10/7 19:24
 * @email helloworld.dng@gmail.com
 */
@Component("closeDoorTaskChainImpl")
public class CloseDoorTaskChainImpl implements MoveEleTaskChain {
    @Override
    public void execute() {
        System.out.println("关闭冰箱门");
    }
}
