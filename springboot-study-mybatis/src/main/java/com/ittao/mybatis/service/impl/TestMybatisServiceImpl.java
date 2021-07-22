package com.ittao.mybatis.service.impl;

import com.ittao.mybatis.domain.TestMybatis;
import com.ittao.mybatis.mapper.TestMybatisMapper;
import com.ittao.mybatis.service.TestMybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 测试表(TestMybatis)表服务实现类
 *
 * @author makejava
 * @since 2021-07-23 00:37:23
 */
@Service("testMybatisService")
public class TestMybatisServiceImpl implements TestMybatisService {
    @Autowired
    private TestMybatisMapper testMybatisMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public TestMybatis queryById(Integer userId) {
        return this.testMybatisMapper.queryById(userId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TestMybatis> queryAllByLimit(int offset, int limit) {
        return this.testMybatisMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param testMybatis 实例对象
     * @return 实例对象
     */
    @Override
    public TestMybatis insert(TestMybatis testMybatis) {
        this.testMybatisMapper.insert(testMybatis);
        return testMybatis;
    }

    /**
     * 修改数据
     *
     * @param testMybatis 实例对象
     * @return 实例对象
     */
    @Override
    public TestMybatis update(TestMybatis testMybatis) {
        this.testMybatisMapper.update(testMybatis);
        return this.queryById(testMybatis.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer userId) {
        return this.testMybatisMapper.deleteById(userId) > 0;
    }
}
