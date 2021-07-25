package com.ittao.shiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ittao.shiro.constant.ShiroConstant;
import com.ittao.shiro.domain.TestShiroUser;
import com.ittao.shiro.mapper.TestShiroRolePermissionMapper;
import com.ittao.shiro.mapper.TestShiroUserMapper;
import com.ittao.shiro.mapper.TestShiroUserRoleMapper;
import com.ittao.shiro.service.TestShiroUserService;
import com.ittao.shiro.util.SaltUtils;
import com.ittao.shiro.util.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 测试用户表(TestShiroUser)表服务实现类
 *
 * @author makejava
 * @since 2021-07-25 01:43:23
 */
@Service("testShiroUserService")
public class TestShiroUserServiceImpl extends ServiceImpl<TestShiroUserMapper, TestShiroUser> implements TestShiroUserService {
    @Autowired
    private TestShiroUserMapper testShiroUserMapper;

    @Autowired
    private TestShiroUserRoleMapper testShiroUserRoleMapper;

    @Autowired
    private TestShiroRolePermissionMapper testShiroRolePermissionMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(TestShiroUser testShiroUser) {
        // 生成随机盐
        String salt = SaltUtils.getSalt(ShiroConstant.SALT_LENGTH);
        // 保存随机盐
        testShiroUser.setSalt(salt);
        // 生成密码
        String password = ShiroUtils.sha256(testShiroUser.getPassword(), salt);
        // 保存密码
        testShiroUser.setPassword(password);
        // 保存用户
        boolean insertFlag = (this.testShiroUserMapper.insert(testShiroUser) > 0);

        testShiroUser.getUserId();

        return insertFlag;
    }
}
