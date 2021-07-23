package com.ittao.mybatisplus.controller;

import com.ittao.mybatisplus.domain.TestMybatisPlus;
import com.ittao.mybatisplus.service.TestMybatisPlusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 测试表(TestMybatisPlus)表控制层
 *
 * @author makejava
 * @since 2021-07-23 00:37:23
 */
@RestController
@RequestMapping("/api/mybatisPlus")
public class TestMybatisPlusController {
    /**
     * 服务对象
     */
    @Autowired
    private TestMybatisPlusService testMybatisPlusService;

    /**
     * http://localhost:9000/api/mybatisPlus/selectOne?id=1
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    public Object selectOne(Integer id) {
        return testMybatisPlusService.getById(id);
    }

    @RequestMapping("selectAll")
    public Object selectALL() {
        return testMybatisPlusService.list();
    }

    @RequestMapping("save")
    public Object save() {
        TestMybatisPlus testMybatisPlus = new TestMybatisPlus(6, "王婆", "666666", 0, new Date(), new Date(), "save");
        testMybatisPlusService.save(testMybatisPlus);

        return selectALL();
    }

    @RequestMapping("update")
    public Object update() {
        TestMybatisPlus testMybatisPlus = new TestMybatisPlus(6, "王婆", "666666", 1, new Date(), new Date(), "update");
        testMybatisPlusService.updateById(testMybatisPlus);

        return selectALL();
    }

    @RequestMapping("delete")
    public Object delete() {
        testMybatisPlusService.removeById(6);
        return selectALL();
    }

}
