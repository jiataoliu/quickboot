package com.ittao.mybatisplus.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ittao.mybatisplus.domain.TestMybatisPlus;
import com.ittao.mybatisplus.mapper.TestMybatisPlusMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @ClassName: TestMybatisPlusServiceTests
 * @Description: TODO
 * @Author: it-code-liu
 * @CreateTime: 2021/7/24 1:17
 * @Version : V1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestMybatisPlusServiceTests {

    @Autowired
    private TestMybatisPlusMapper testMybatisPlusMapper;

    @Test
    public void selectPage() {
        QueryWrapper queryWrapper = new QueryWrapper<TestMybatisPlus>();

        queryWrapper.eq("user_id", "2");

        int count = testMybatisPlusMapper.selectCount(queryWrapper);

        IPage<TestMybatisPlus> page = new Page(1, 2, count);
        IPage<TestMybatisPlus> list = testMybatisPlusMapper.selectPage(page, queryWrapper);

        System.out.println("返回数据：" + list.getRecords());

        System.out.println("总条数：" + list.getTotal() + "当前页码：" + list.getCurrent() + "总页码：" + list.getPages() + "每页显示条数：" + list.getSize());

        System.out.println("返回的数据：" + page.getRecords());
    }

    @Test
    public void selectList() {
        QueryWrapper queryWrapper = new QueryWrapper<TestMybatisPlus>();

        queryWrapper.select("user_id", "user_name", "password", "status")
                .orderByAsc("user_id");

        List<TestMybatisPlus> testMybatisPlusList = testMybatisPlusMapper.selectList(queryWrapper);

        System.out.println("返回数据：" + testMybatisPlusList);
    }

}
