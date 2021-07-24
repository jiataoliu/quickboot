package com.ittao.dynamicdb.service;

import com.ittao.dynamicdb.domain.TestDynamicdb;

import java.util.List;

/**
 * 测试表(TestDynamicdb)表服务接口
 *
 * @author makejava
 * @since 2021-07-23 00:37:23
 */
public interface TestDynamicdbService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    TestDynamicdb queryById(Integer userId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TestDynamicdb> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param testDynamicdb 实例对象
     * @return 实例对象
     */
    TestDynamicdb insert(TestDynamicdb testDynamicdb);

    /**
     * 修改数据
     *
     * @param testDynamicdb 实例对象
     * @return 实例对象
     */
    TestDynamicdb update(TestDynamicdb testDynamicdb);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer userId);

    /**
     * 查询 Master 多条数据
     *
     * @return 对象列表
     */
    List<TestDynamicdb> queryAllMaster();

    /**
     * 查询 Slave1 多条数据
     *
     * @return 对象列表
     */
    List<TestDynamicdb> queryAllSlave1();

    /**
     * 查询 Slave2 多条数据
     *
     * @return 对象列表
     */
    List<TestDynamicdb> queryAllSlave2();
}
