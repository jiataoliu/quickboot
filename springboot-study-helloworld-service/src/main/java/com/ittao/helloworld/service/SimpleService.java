package com.ittao.helloworld.service;

import org.springframework.stereotype.Service;

/**
 * @ClassName: SimpleService
 * @Description: TODO
 * @Author: it-code-liu
 * @CreateTime: 2021/7/16 1:17
 * @Version : V1.0.0
 */
@Service
public class SimpleService {
    public String message() {
        return "SimpleService is module for helloworld.service method message!";
    }
}
