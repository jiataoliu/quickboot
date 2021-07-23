package com.ittao.mybatisplus.controller;

import com.ittao.mybatisplus.domain.TestMybatisPlus;
import com.ittao.mybatisplus.service.TestMybatisPlusService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @ClassName: TestMybatisPlusControllerTests
 * @Description: TODO
 * @Author: it-code-liu
 * @CreateTime: 2021/7/23 23:45
 * @Version : V1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestMybatisPlusControllerTests {

    @Autowired
    private TestMybatisPlusService testMybatisPlusService;

    @Test
    public void save() {
        TestMybatisPlus testMybatisPlus = new TestMybatisPlus(6, "王婆", "666666", 0, new Date(), new Date(), "");
        testMybatisPlusService.save(testMybatisPlus);
        System.out.println(testMybatisPlusService.getById(6));
    }
}
