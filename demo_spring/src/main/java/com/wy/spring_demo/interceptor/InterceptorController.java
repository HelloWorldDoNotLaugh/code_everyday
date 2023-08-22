package com.wy.spring_demo.interceptor;

import com.wy.spring_demo.entity.UserDO;
import org.springframework.web.bind.annotation.*;

/**
 * @author HelloWorld
 * @date 2023/8/21 22:59
 * @email helloworld.dng@gmail.com
 */

@RestController
@RequestMapping("/api/login")
public class InterceptorController {

    @PostMapping(value = "login")
    public String login(@SessionAttribute("loginUser") UserDO currentUser) {
        return currentUser.getUserName() + " login";
    }
}
