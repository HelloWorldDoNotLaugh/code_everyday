package com.wy.spring_demo.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author zhangyuyang
 * @create 2024/7/22 14:25
 */
@RestController
@RequestMapping("/ioc")
public class Test {
    @Autowired
    private Map<String, Animal> animalMap;

    @Value("${a.ba.c:}")
    private String name;

    @GetMapping("/test")
    public void test() {
        for (Animal animal : animalMap.values()) {
            System.out.println(animal.getName());
            System.out.println(name);
        }
    }
}
