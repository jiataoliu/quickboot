package com.ittao.mybatis.controller;

import com.ittao.mybatis.domain.TestMybatis;
import com.ittao.mybatis.service.TestMybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 测试表(TestMybatis)表控制层
 *
 * @author makejava
 * @since 2021-07-23 00:37:23
 */
@RestController
@RequestMapping("testMybatis")
public class TestMybatisController {
    /**
     * 服务对象
     */
    @Autowired
    private TestMybatisService testMybatisService;

    /**
     * http://localhost:9000/testMybatis/selectOne?id=1
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TestMybatis selectOne(Integer id) {
        return this.testMybatisService.queryById(id);
    }

}
