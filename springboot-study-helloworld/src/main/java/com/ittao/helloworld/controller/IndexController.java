package com.ittao.helloworld.controller;

import com.ittao.helloworld.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: IndexController
 * @Description: TODO
 * @Author: it-code-liu
 * @CreateTime: 2021/7/16 1:23
 * @Version : V1.0.0
 */
@RestController
public class IndexController {
    @Autowired
    SimpleService simpleService;

    @GetMapping("/say")
    public String say() {
        return simpleService.message();
    }
}
