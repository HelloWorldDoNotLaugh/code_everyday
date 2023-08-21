package com.wy.spring_demo.design_patterns.strategy.impl;

import com.wy.spring_demo.design_patterns.strategy.AnimalService;
import org.springframework.stereotype.Service;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/8/21
 */
@Service("dogServiceImpl")
public class DogServiceImpl implements AnimalService {
    @Override
    public String eat() {
        return ("dog can eat");
    }

    @Override
    public String run() {
        return ("dog can run");
    }

    @Override
    public String sleep() {
        return ("dog can sleep");
    }
}
