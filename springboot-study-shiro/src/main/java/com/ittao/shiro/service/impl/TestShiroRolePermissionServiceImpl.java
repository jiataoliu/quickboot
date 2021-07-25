package com.ittao.shiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ittao.shiro.domain.TestShiroRolePermission;
import com.ittao.shiro.mapper.TestShiroRolePermissionMapper;
import com.ittao.shiro.service.TestShiroRolePermissionService;
import org.springframework.stereotype.Service;

/**
 * 测试角色权限关联表(TestShiroRolePermission)表服务实现类
 *
 * @author makejava
 * @since 2021-07-25 01:43:24
 */
@Service("testShiroRolePermissionService")
public class TestShiroRolePermissionServiceImpl extends ServiceImpl<TestShiroRolePermissionMapper, TestShiroRolePermission> implements TestShiroRolePermissionService {
}
