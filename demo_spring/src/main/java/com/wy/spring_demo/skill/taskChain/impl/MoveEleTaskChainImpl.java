package com.wy.spring_demo.skill.taskChain.impl;

import com.wy.spring_demo.skill.taskChain.MoveEleTaskChain;
import org.springframework.stereotype.Component;

/**
 * @author HelloWorld
 * @date 2023/10/7 18:05
 * @email helloworld.dng@gmail.com
 */
@Component("moveEleTaskChainImpl")
public class MoveEleTaskChainImpl implements MoveEleTaskChain {
    @Override
    public void execute() {
        System.out.println("将大象放进冰箱");
    }
}
