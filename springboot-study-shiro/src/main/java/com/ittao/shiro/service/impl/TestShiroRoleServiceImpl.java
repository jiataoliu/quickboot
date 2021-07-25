package com.ittao.shiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ittao.shiro.domain.TestShiroRole;
import com.ittao.shiro.mapper.TestShiroRoleMapper;
import com.ittao.shiro.service.TestShiroRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 测试角色表(TestShiroRole)表服务实现类
 *
 * @author makejava
 * @since 2021-07-25 01:43:25
 */
@Service("testShiroRoleService")
public class TestShiroRoleServiceImpl extends ServiceImpl<TestShiroRoleMapper, TestShiroRole> implements TestShiroRoleService {
    @Autowired
    private TestShiroRoleMapper testShiroRoleMapper;

    /**
     * 根据用户 id 获取用户的角色集合
     *
     * @param userId
     * @return
     */
    @Override
    public List<TestShiroRole> getRolesByUserId(Integer userId) {
        return testShiroRoleMapper.getRolesByUserId(userId);
    }

}
