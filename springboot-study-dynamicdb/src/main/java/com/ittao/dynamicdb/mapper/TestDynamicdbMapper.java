package com.ittao.dynamicdb.mapper;

import com.ittao.dynamicdb.domain.TestDynamicdb;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 测试表(TestDynamicdb)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-23 00:37:22
 */
@Mapper
public interface TestDynamicdbMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    TestDynamicdb queryById(Integer userId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TestDynamicdb> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param testDynamicdb 实例对象
     * @return 对象列表
     */
    List<TestDynamicdb> queryAll(TestDynamicdb testDynamicdb);

    /**
     * 新增数据
     *
     * @param testDynamicdb 实例对象
     * @return 影响行数
     */
    int insert(TestDynamicdb testDynamicdb);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<testDynamicdb> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TestDynamicdb> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<testDynamicdb> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<TestDynamicdb> entities);

    /**
     * 修改数据
     *
     * @param testDynamicdb 实例对象
     * @return 影响行数
     */
    int update(TestDynamicdb testDynamicdb);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 影响行数
     */
    int deleteById(Integer userId);

}

