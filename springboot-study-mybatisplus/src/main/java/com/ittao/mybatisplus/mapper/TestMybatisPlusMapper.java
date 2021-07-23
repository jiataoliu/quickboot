package com.ittao.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ittao.mybatisplus.domain.TestMybatisPlus;
import org.apache.ibatis.annotations.Mapper;

/**
 * 测试表(TestMybatisPlus)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-23 00:37:22
 */
@Mapper
public interface TestMybatisPlusMapper extends BaseMapper<TestMybatisPlus> {
}
