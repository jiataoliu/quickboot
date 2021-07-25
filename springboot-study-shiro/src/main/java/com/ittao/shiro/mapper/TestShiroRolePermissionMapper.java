package com.ittao.shiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ittao.shiro.domain.TestShiroRolePermission;
import org.apache.ibatis.annotations.Mapper;

/**
 * 测试角色权限关联表(TestShiroRolePermission)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-25 01:43:23
 */
@Mapper
public interface TestShiroRolePermissionMapper extends BaseMapper<TestShiroRolePermission> {
}
