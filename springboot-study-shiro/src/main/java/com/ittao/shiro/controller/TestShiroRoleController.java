package com.ittao.shiro.controller;

import com.ittao.shiro.domain.TestShiroRole;
import com.ittao.shiro.service.TestShiroRoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 测试角色表(TestShiroRole)表控制层
 *
 * @author makejava
 * @since 2021-07-25 01:43:25
 */
@RestController
@RequestMapping("/api/testShiroRole")
public class TestShiroRoleController {
    /**
     * 服务对象
     */
    @Resource
    private TestShiroRoleService testShiroRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TestShiroRole selectOne(Integer id) {
        return this.testShiroRoleService.getById(id);
    }

}
