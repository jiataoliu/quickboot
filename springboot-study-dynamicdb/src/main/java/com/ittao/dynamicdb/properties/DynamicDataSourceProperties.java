package com.ittao.dynamicdb.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName: DynamicDataSourceProperties
 * @Description: 多数据源属性 在 application 中表示为以 dynamic 为节点的配置
 * @Author: it-code-liu
 * @CreateTime: 2021/7/24 4:33
 * @Version : V1.0.0
 */
@ConfigurationProperties(prefix = "dynamic")
public class DynamicDataSourceProperties {
    private Map<String, DataSourceProperties> datasource = new LinkedHashMap<>();

    public Map<String, DataSourceProperties> getDatasource() {
        return datasource;
    }

    public void setDatasource(Map<String, DataSourceProperties> datasource) {
        this.datasource = datasource;
    }
}
