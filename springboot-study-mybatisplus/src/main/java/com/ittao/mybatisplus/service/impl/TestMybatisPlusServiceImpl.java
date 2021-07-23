package com.ittao.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ittao.mybatisplus.domain.TestMybatisPlus;
import com.ittao.mybatisplus.mapper.TestMybatisPlusMapper;
import com.ittao.mybatisplus.service.TestMybatisPlusService;
import org.springframework.stereotype.Service;

/**
 * 测试表(TestMybatisPlus)表服务实现类
 *
 * @author makejava
 * @since 2021-07-23 00:37:23
 */
@Service("testMybatisPlusService")
public class TestMybatisPlusServiceImpl extends ServiceImpl<TestMybatisPlusMapper, TestMybatisPlus> implements TestMybatisPlusService {
}
