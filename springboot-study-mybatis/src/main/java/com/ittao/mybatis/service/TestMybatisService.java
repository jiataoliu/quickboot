package com.ittao.mybatis.service;

import com.ittao.mybatis.domain.TestMybatis;

import java.util.List;

/**
 * 测试表(TestMybatis)表服务接口
 *
 * @author makejava
 * @since 2021-07-23 00:37:23
 */
public interface TestMybatisService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    TestMybatis queryById(Integer userId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TestMybatis> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param testMybatis 实例对象
     * @return 实例对象
     */
    TestMybatis insert(TestMybatis testMybatis);

    /**
     * 修改数据
     *
     * @param testMybatis 实例对象
     * @return 实例对象
     */
    TestMybatis update(TestMybatis testMybatis);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer userId);

}
