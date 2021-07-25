package com.ittao.shiro.controller;

import com.ittao.shiro.domain.TestShiroUserRole;
import com.ittao.shiro.service.TestShiroUserRoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 测试用户角色关联表(TestShiroUserRole)表控制层
 *
 * @author makejava
 * @since 2021-07-25 01:43:22
 */
@RestController
@RequestMapping("/api/testShiroUserRole")
public class TestShiroUserRoleController {
    /**
     * 服务对象
     */
    @Resource
    private TestShiroUserRoleService testShiroUserRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TestShiroUserRole selectOne(Integer id) {
        return this.testShiroUserRoleService.getById(id);
    }

}
