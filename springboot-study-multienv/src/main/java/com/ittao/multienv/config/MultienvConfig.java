package com.ittao.multienv.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName: MultienvConfig
 * @Description: TODO
 * @Author: it-code-liu
 * @CreateTime: 2021/7/16 3:27
 * @Version : V1.0.0
 */
@Component
@ConfigurationProperties(prefix = "springbootstudy")
public class MultienvConfig {
    private String environment;

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
