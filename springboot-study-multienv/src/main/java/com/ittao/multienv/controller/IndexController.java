package com.ittao.multienv.controller;

import com.ittao.multienv.config.MultienvConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: IndexController
 * @Description: TODO
 * @Author: it-code-liu
 * @CreateTime: 2021/7/16 3:31
 * @Version : V1.0.0
 */
@Controller
public class IndexController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MultienvConfig multienvConfig;

    @RequestMapping("/")
    String index() {
        logger.info(multienvConfig.getEnvironment());
        return "index";
    }
}
