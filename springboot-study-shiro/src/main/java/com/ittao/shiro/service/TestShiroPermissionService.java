package com.ittao.shiro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ittao.shiro.domain.TestShiroPermission;

import java.util.List;

/**
 * 测试权限表(TestShiroPermission)表服务接口
 *
 * @author makejava
 * @since 2021-07-25 01:43:20
 */
public interface TestShiroPermissionService extends IService<TestShiroPermission> {
    /**
     * 根据角色 id 获取角色的权限集合
     * @param roleId
     * @return
     */
    List<TestShiroPermission> getPermissionsByRoleId(Integer roleId);
}
