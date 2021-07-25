package com.ittao.shiro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ittao.shiro.domain.TestShiroRole;

import java.util.List;

/**
 * 测试角色表(TestShiroRole)表服务接口
 *
 * @author makejava
 * @since 2021-07-25 01:43:25
 */
public interface TestShiroRoleService extends IService<TestShiroRole> {
    /**
     * 根据用户 id 获取用户的角色集合
     * @param userId
     * @return
     */
    List<TestShiroRole> getRolesByUserId(Integer userId);
}
