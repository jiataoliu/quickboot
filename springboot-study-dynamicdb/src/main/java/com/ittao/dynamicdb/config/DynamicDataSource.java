package com.ittao.dynamicdb.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @ClassName: DynamicDataSource
 * @Description: 多数据源 继承AbstractRoutingDataSource进行扩展，重新 determineCurrentLookupKey 方法实现多数据源
 * @Author: it-code-liu
 * @CreateTime: 2021/7/24 4:38
 * @Version : V1.0.0
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    // 获取当前数据库配置中的数据源
    @Override
    protected Object determineCurrentLookupKey() {
        // peek() 获得当前线程数据源
        return DynamicContextHolder.getDataSource();
    }

}
