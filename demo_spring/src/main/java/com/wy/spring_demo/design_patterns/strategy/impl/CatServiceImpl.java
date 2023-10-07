package com.wy.spring_demo.design_patterns.strategy.impl;

import com.wy.spring_demo.design_patterns.strategy.AnimalService;
import org.springframework.stereotype.Service;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/8/21
 */
@Service("catServiceImpl")
public class CatServiceImpl implements AnimalService {
    @Override
    public String  eat() {
        return  ("cat can eat");
    }

    @Override
    public String  run() {
        return  ("cat can run");
    }

    @Override
    public String  sleep() {
        return  ("cat can sleep");
    }
}
