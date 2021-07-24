package com.ittao.dynamicdb.controller;

import com.ittao.dynamicdb.domain.TestDynamicdb;
import com.ittao.dynamicdb.service.TestDynamicdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 测试表(TestDynamicdb)表控制层
 *
 * @author makejava
 * @since 2021-07-23 00:37:23
 */
@RestController
@RequestMapping("/api/dynamicdb")
public class TestDynamicdbController {
    /**
     * 服务对象
     */
    @Autowired
    private TestDynamicdbService testDynamicdbService;

    /**
     * http://localhost:9000/api/dynamicdb/queryAllMaster
     * 查询 Master 多条数据
     *
     * @return 对象列表
     */
    @GetMapping("queryAllMaster")
    public List<TestDynamicdb> queryAllMaster() {

        return this.testDynamicdbService.queryAllMaster();
    }

    /**
     * http://localhost:9000/api/dynamicdb/queryAllSlave1
     * 查询 Slave1 多条数据
     *
     * @return 对象列表
     */
    @GetMapping("queryAllSlave1")
    public List<TestDynamicdb> queryAllSlave1() {

        return this.testDynamicdbService.queryAllSlave1();
    }

    /**
     * http://localhost:9000/api/dynamicdb/queryAllSlave2
     * 查询 Slave2 多条数据
     *
     * @return 对象列表
     */
    @GetMapping("queryAllSlave2")
    public List<TestDynamicdb> queryAllSlave2() {

        return this.testDynamicdbService.queryAllSlave2();
    }

}
