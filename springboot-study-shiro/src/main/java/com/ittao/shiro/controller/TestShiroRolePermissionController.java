package com.ittao.shiro.controller;

import com.ittao.shiro.domain.TestShiroRolePermission;
import com.ittao.shiro.service.TestShiroRolePermissionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 测试角色权限关联表(TestShiroRolePermission)表控制层
 *
 * @author makejava
 * @since 2021-07-25 01:43:24
 */
@RestController
@RequestMapping("/api/testShiroRolePermission")
public class TestShiroRolePermissionController {
    /**
     * 服务对象
     */
    @Resource
    private TestShiroRolePermissionService testShiroRolePermissionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TestShiroRolePermission selectOne(Integer id) {
        return this.testShiroRolePermissionService.getById(id);
    }

}
