package com.ittao.shiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ittao.shiro.domain.TestShiroPermission;
import com.ittao.shiro.mapper.TestShiroPermissionMapper;
import com.ittao.shiro.service.TestShiroPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 测试权限表(TestShiroPermission)表服务实现类
 *
 * @author makejava
 * @since 2021-07-25 01:43:20
 */
@Service("testShiroPermissionService")
public class TestShiroPermissionServiceImpl extends ServiceImpl<TestShiroPermissionMapper, TestShiroPermission> implements TestShiroPermissionService {
    @Autowired
    private TestShiroPermissionMapper testShiroPermissionMapper;

    /**
     * 根据角色 id 获取角色的权限集合
     *
     * @param roleId
     * @return
     */
    @Override
    public List<TestShiroPermission> getPermissionsByRoleId(Integer roleId) {
        return testShiroPermissionMapper.getPermissionsByRoleId(roleId);
    }
}
