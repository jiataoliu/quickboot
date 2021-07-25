package com.ittao.shiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ittao.shiro.domain.TestShiroUserRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * 测试用户角色关联表(TestShiroUserRole)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-25 01:43:21
 */
@Mapper
public interface TestShiroUserRoleMapper extends BaseMapper<TestShiroUserRole> {
}
