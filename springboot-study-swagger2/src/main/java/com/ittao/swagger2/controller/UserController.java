package com.ittao.swagger2.controller;

import com.ittao.swagger2.domain.User;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: UserController
 * @Description: RESTful API 风格示例 对资源 user 进行操作；
 * 本示例没有使用数据库，也没有使用 service 类来辅助完成，所有操作在本类中完成。
 * @Author: it-code-liu
 * @CreateTime: 2021/7/17 20:00
 * @Version : V1.0.0
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户接口")
public class UserController {
    /**
     * 模拟一组数据
     */
    private List<User> getData() {
        List<User> list = new ArrayList<>();

        User User = new User();
        User.setUserId(1);
        User.setUserName("张三");
        list.add(User);

        User = new User();
        User.setUserId(2);
        User.setUserName("李四");
        list.add(User);

        User = new User();
        User.setUserId(3);
        User.setUserName("王五");
        list.add(User);

        User = new User();
        User.setUserId(4);
        User.setUserName("赵六");
        list.add(User);

        return list;
    }

    /**
     * SELECT 查询操作，返回一个JSON数组
     * 具有幂等性
     */
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "获取用户全部信息", tags = "查询用户", notes = "注意这里没有分页")
    public Object getUsers() {
        List<User> list = new ArrayList<>();

        list = getData();

        return list;
    }

    /**
     * SELECT 查询操作，返回一个新建的JSON对象
     * 具有幂等性
     */
    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "获取指定ID用户信息", tags = "查询用户", notes = "注意这里的参数id")
    public Object getUser(@PathVariable("id") @ApiParam(name = "id", value = "用户ID") String id) {
        if (null == id) {
            return null;
        }

        List<User> list = getData();
        User user = null;

        for (User u : list) {
            if (id.equals(u.getUserId().toString())) {
                user = u;
                break;
            }
        }

        return user;
    }

    /**
     * 新增一个用户对象
     * 非幂等
     * 返回 201 HttpStatus.CREATED 对创建新资源的 POST 操作进行响应。应该带着指向新资源地址的 Location 头
     */
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "新增一个用户", tags = "操作用户", notes = "客户端提供用户实体Json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
    })
    public Object addUser(@RequestBody User user) {
        List<User> list = getData();
        list.add(user);// 模拟向列表中增加数据

        return user;
    }

    /**
     * 编辑一个用户对象
     * 幂等性
     * 返回 201 HttpStatus.CREATED 对创建新资源的 POST 操作进行响应。应该带着指向新资源地址的 Location 头
     */
    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "更新一个用户", tags = "操作用户", notes = "客户端提供用户实体Json")
    public Object editUser(@PathVariable("id") @ApiParam(name = "id", value = "用户ID") String id, @RequestBody User user) {
        List<User> list = getData();

        for (User u : list) {
            if (id.equals(u.getUserId().toString())) {
                u = user;
                break;
            }
        }

        return user;
    }

    /**
     * 删除一个用户对象
     * 幂等性
     * 返回 HttpStatus.NO_CONTENT 表示无返回内容
     */
    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "删除用户", tags = "操作用户", notes = "客户端提供用户实体Json")
    public void deleteUser(@PathVariable("id") @ApiParam(name = "id", value = "用户ID") String id) {
        if (null == id) {
            return;
        }

        List<User> list = getData();
        User user = null;

        for (int i = 0; i < list.size(); i++) {
            User u = list.get(i);

            if (id.equals(u.getUserId().toString())) {
                list.remove(i);// 删除用户
                i--;// 不减减不行，list元素在减少

                user = u;
                break;
            }
        }
    }
}
