package com.ittao.mybatis.mapper;

import com.ittao.mybatis.domain.TestMybatis;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 测试表(TestMybatis)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-23 00:37:22
 */
@Mapper
public interface TestMybatisMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    TestMybatis queryById(Integer userId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TestMybatis> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param testMybatis 实例对象
     * @return 对象列表
     */
    List<TestMybatis> queryAll(TestMybatis testMybatis);

    /**
     * 新增数据
     *
     * @param testMybatis 实例对象
     * @return 影响行数
     */
    int insert(TestMybatis testMybatis);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TestMybatis> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TestMybatis> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TestMybatis> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<TestMybatis> entities);

    /**
     * 修改数据
     *
     * @param testMybatis 实例对象
     * @return 影响行数
     */
    int update(TestMybatis testMybatis);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 影响行数
     */
    int deleteById(Integer userId);

}

