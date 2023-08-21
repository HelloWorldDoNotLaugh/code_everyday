package com.wy.spring_demo.design_patterns.strategy;

import com.wy.spring_demo.util.SpringContextUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/8/21
 */

@RestController
@RequestMapping("/animal")
public class AnimalController {

    @GetMapping("get")
    public String get(@RequestParam("type") String animalType) {
        AnimalService service = (AnimalService) SpringContextUtil.getBean(animalType);
        return service.run();
    }
}
