package com.wy.spring_demo.skill.taskChain.impl;

import com.wy.spring_demo.skill.taskChain.MoveEleTaskChain;
import org.springframework.stereotype.Component;

/**
 * @author HelloWorld
 * @date 2023/10/7 18:03
 * @email helloworld.dng@gmail.com
 */
@Component("openDoorTaskChainImpl")
public class OpenDoorTaskChainImpl implements MoveEleTaskChain {
    @Override
    public void execute() {
        System.out.println("打开冰箱门");
    }
}
