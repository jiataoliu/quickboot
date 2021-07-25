package com.ittao.shiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ittao.shiro.domain.TestShiroUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * 测试用户表(TestShiroUser)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-25 01:43:22
 */
@Mapper
public interface TestShiroUserMapper extends BaseMapper<TestShiroUser> {
}
