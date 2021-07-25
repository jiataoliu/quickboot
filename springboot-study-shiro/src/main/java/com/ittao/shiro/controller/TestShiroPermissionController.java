package com.ittao.shiro.controller;

import com.ittao.shiro.domain.TestShiroPermission;
import com.ittao.shiro.service.TestShiroPermissionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 测试权限表(TestShiroPermission)表控制层
 *
 * @author makejava
 * @since 2021-07-25 01:43:20
 */
@RestController
@RequestMapping("/api/testShiroPermission")
public class TestShiroPermissionController {
    /**
     * 服务对象
     */
    @Resource
    private TestShiroPermissionService testShiroPermissionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TestShiroPermission selectOne(Integer id) {
        return this.testShiroPermissionService.getById(id);
    }

}
