package com.ittao.thymeleaf.controller;

import com.ittao.thymeleaf.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: IndexController
 * @Description: TODO
 * @Author: it-code-liu
 * @CreateTime: 2021/7/21 3:49
 * @Version : V1.0.0
 */
@Controller
public class IndexController {
    /**
     * http://localhost:9000/index.do
     *
     * @param model
     * @return
     */

    @RequestMapping("/index.do")
    public String sample(Model model) {
        model.addAttribute("user", getUserData());
        List<User> users = new ArrayList<User>();
        users.add(new User("张三", "男", new Date()));
        users.add(new User("李四", "女", new Date()));
        users.add(new User("王五", "女", new Date()));
        users.add(new User("赵六", "男", new Date()));
        model.addAttribute("users", users);
        return "/sample";
    }

    /**
     * 构造一个 user 对象
     */
    private User getUserData() {
        User user = new User();
        user.setUsername("王婆");
        user.setSex("女");
        user.setBirthday(new Date());
        return user;
    }
}
