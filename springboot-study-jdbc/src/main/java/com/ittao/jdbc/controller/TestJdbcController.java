package com.ittao.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: TestJdbcController
 * @Description: TODO
 * @Author: it-code-liu
 * @CreateTime: 2021/7/22 23:08
 * @Version : V1.0.0
 */
@RestController
@RequestMapping("/api/jdbc")
public class TestJdbcController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * http://localhost:9000/api/jdbc/queryForList
     * 获取示例数据库 test_jdbc 的全部信息
     *
     * @return 返回 json 数据
     */
    @GetMapping("/queryForList")
    public Object queryForList() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from test_jdbc ");
        return list;
    }

    @GetMapping("/insert")
    public Object insert() {

        String sql = "INSERT INTO test_jdbc VALUES(?, ?, ?, ?, sysdate(), sysdate(), ?);";
        jdbcTemplate.update(sql, 6, "王婆", "666666", 0, "");

        return queryForList();
    }

    @GetMapping("/update")
    public Object update() {

        String sql = "UPDATE test_jdbc SET status=?, login_time=? WHERE user_id=?;";
        jdbcTemplate.update(sql, 1, new Date(), 6);

        return queryForList();
    }

    @GetMapping("/delete")
    public Object delete() {

        String sql = "DELETE FROM test_jdbc WHERE user_id=?;";
        jdbcTemplate.update(sql, 6);

        return queryForList();
    }

}
