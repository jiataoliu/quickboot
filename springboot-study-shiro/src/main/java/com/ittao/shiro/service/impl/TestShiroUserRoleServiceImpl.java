package com.ittao.shiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ittao.shiro.domain.TestShiroUserRole;
import com.ittao.shiro.mapper.TestShiroUserRoleMapper;
import com.ittao.shiro.service.TestShiroUserRoleService;
import org.springframework.stereotype.Service;

/**
 * 测试用户角色关联表(TestShiroUserRole)表服务实现类
 *
 * @author makejava
 * @since 2021-07-25 01:43:21
 */
@Service("testShiroUserRoleService")
public class TestShiroUserRoleServiceImpl extends ServiceImpl<TestShiroUserRoleMapper, TestShiroUserRole> implements TestShiroUserRoleService {
}
