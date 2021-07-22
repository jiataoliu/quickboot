package com.ittao.jpa.controller;

import com.ittao.jpa.domain.TestJpa;
import com.ittao.jpa.repository.TestJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Optional;

/**
 * @ClassName: TestJpaController
 * @Description: TODO
 * @Author: it-code-liu
 * @CreateTime: 2021/7/23 2:38
 * @Version : V1.0.0
 */
@RestController
@RequestMapping("/api/jpa")
public class TestJpaController {
    @Autowired
    private TestJpaRepository testJpaRepository;

    /**
     * http://localhost:9000/api/jpa/findById?id=1
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("findById")
    public Object findById(Integer id) {
        Optional<TestJpa> optionalUserDO = testJpaRepository.findById(id);
        if (optionalUserDO.isPresent()) {
            TestJpa testJpa = optionalUserDO.get();

            return testJpa;
        }

        return null;
    }

    /**
     * 查询多个数据
     */
    @GetMapping("findAll")
    public Object findAll() {
        return testJpaRepository.findAll();
    }

    /**
     * 插入数据
     */
    @GetMapping("insert")
    public Object insert() {
        TestJpa testJpa = new TestJpa(6, "王婆", "666666", 0, new Date(), new Date(), "");
        testJpaRepository.save(testJpa);

        return findAll();
    }

    /**
     * 修改数据
     */
    @GetMapping("update")
    public Object update() {
        TestJpa testJpa = new TestJpa(6, "王婆", "666666", 1, new Date(), new Date(), "");
        testJpaRepository.save(testJpa);

        return findAll();
    }

    /**
     * 删除数据
     */
    @GetMapping("delete")
    public Object delete() {
        testJpaRepository.deleteById(6);

        return findAll();
    }
}
