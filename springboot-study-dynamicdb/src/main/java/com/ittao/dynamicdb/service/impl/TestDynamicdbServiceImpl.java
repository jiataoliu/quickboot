package com.ittao.dynamicdb.service.impl;

import com.ittao.dynamicdb.annotation.DataSource;
import com.ittao.dynamicdb.domain.TestDynamicdb;
import com.ittao.dynamicdb.mapper.TestDynamicdbMapper;
import com.ittao.dynamicdb.service.TestDynamicdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 测试表(TestDynamicdb)表服务实现类
 *
 * @author makejava
 * @since 2021-07-23 00:37:23
 */
@Service("testDynamicdbService")
public class TestDynamicdbServiceImpl implements TestDynamicdbService {
    @Autowired
    private TestDynamicdbMapper testDynamicdbMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public TestDynamicdb queryById(Integer userId) {
        return this.testDynamicdbMapper.queryById(userId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TestDynamicdb> queryAllByLimit(int offset, int limit) {
        return this.testDynamicdbMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param testDynamicdb 实例对象
     * @return 实例对象
     */
    @Override
    public TestDynamicdb insert(TestDynamicdb testDynamicdb) {
        this.testDynamicdbMapper.insert(testDynamicdb);
        return testDynamicdb;
    }

    /**
     * 修改数据
     *
     * @param testDynamicdb 实例对象
     * @return 实例对象
     */
    @Override
    public TestDynamicdb update(TestDynamicdb testDynamicdb) {
        this.testDynamicdbMapper.update(testDynamicdb);
        return this.queryById(testDynamicdb.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer userId) {
        return this.testDynamicdbMapper.deleteById(userId) > 0;
    }

    /**
     * 查询 Master 多条数据
     *
     * @return 对象列表
     */
    @Override
    @Transactional
    public List<TestDynamicdb> queryAllMaster() {
        return this.testDynamicdbMapper.queryAll(null);
    }

    /**
     * 查询 Slave1 多条数据
     *
     * @return 对象列表
     */
    @Override
    @Transactional
    @DataSource("slave1")
    public List<TestDynamicdb> queryAllSlave1() {
        return this.testDynamicdbMapper.queryAll(null);
    }

    /**
     * 查询 Slave2 多条数据
     *
     * @return 对象列表
     */
    @Override
    @Transactional
    @DataSource("slave2")
    public List<TestDynamicdb> queryAllSlave2() {
        return this.testDynamicdbMapper.queryAll(null);
    }
}
