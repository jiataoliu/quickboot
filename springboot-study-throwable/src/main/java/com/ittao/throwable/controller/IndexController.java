package com.ittao.throwable.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: IndexController
 * @Description: TODO
 * @Author: it-code-liu
 * @CreateTime: 2021/7/20 2:08
 * @Version : V1.0.0
 */
@Controller
public class IndexController {

    /**
     * 正常的页面 对应 /templates/index.html 页面
     */
    @RequestMapping("/index")
    public String index(Model model) {

        model.addAttribute("msg", "这是一个index页面的正常消息");
        return "index";
    }

    /**
     * 抛出一个 RuntimeException 异常
     */
    @RequestMapping("/index/err")
    public String err() {

        throw new RuntimeException("抛出一个 RuntimeException 异常");
    }

    /**
     * 抛出一个 RuntimeException 异常
     */
    @RequestMapping("/index/matherr")
    public String matherr(Model model) {

        int j = 0;
        int i = 0;
        i = 100 / j;

        return "index";
    }
}
