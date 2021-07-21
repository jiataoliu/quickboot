package com.ittao.freemarker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @ClassName: IndexController
 * @Description: 一个普通的 Controller 类
 * @Author: it-code-liu
 * @CreateTime: 2021/7/22 0:12
 * @Version : V1.0.0
 */
@Controller
public class IndexController {
    /**
     * 路由 /index.do
     * 返回 index 这里默认配置自动映射到 templates/index
     */
    @RequestMapping("/index.do")
    public String index(Model model) {
        // 字符串类型
        model.addAttribute("msg", "Hello ");
        model.addAttribute("msg2", "freemarker");

        // 布尔类型
        model.addAttribute("flag", true);

        // 日期类型
        model.addAttribute("createDate", new Date());

        // 数值类型
        model.addAttribute("age", 18); // 数值型
        model.addAttribute("salary", 10000); // 数值型
        model.addAttribute("avg", 0.545); // 浮点型
        return "index";
    }
}
