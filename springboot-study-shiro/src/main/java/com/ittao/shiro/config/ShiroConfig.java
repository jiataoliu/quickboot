package com.ittao.shiro.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.ittao.shiro.realm.CustomerRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: ShiroConfig
 * @Description: Shiro 的核心配置类，用来整合 shiro 框架
 * @Author: it-code-liu
 * @CreateTime: 2021/7/25 2:36
 * @Version : V1.0.0
 */
@Configuration
public class ShiroConfig {

    // 1.创建 shiroFilter 工厂，设置对应的过滤条件和跳转条件,负责拦截所有请求
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 登录页面
        shiroFilterFactoryBean.setLoginUrl("/user/login");
        // 未授权界面
        shiroFilterFactoryBean.setUnauthorizedUrl("/");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index");

        // 给 filter 设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        // 配置系统受限资源
        // 配置系统公共资源
        Map<String, String> filterMap = new HashMap<String, String>();

        // anon 设置为公共资源，放行要注意 anon 和 authc 的顺序
        filterMap.put("/user/login", "anon");
        filterMap.put("/login.html", "anon");

        filterMap.put("/user/register", "anon");
        filterMap.put("/register.html", "anon");

        filterMap.put("/user/loginUserName", "anon");
        filterMap.put("/user/selectOne", "anon");
        filterMap.put("/user/getImage", "anon");

        // authc 请求这个资源需要认证和授权
        filterMap.put("/user/index", "authc");
        filterMap.put("/index.html", "authc");
        filterMap.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return shiroFilterFactoryBean;
    }

    // 2. 创建 SecurityManager 安全管理器对象
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager() {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        // 给安全管理器设置
        defaultWebSecurityManager.setRealm(getRealm());

        return defaultWebSecurityManager;
    }

    // 3.创建自定义 realm
    @Bean
    public Realm getRealm() {
        CustomerRealm customerRealm = new CustomerRealm();
        return customerRealm;
    }

    // 4.加入注解的使用，不加这个，注解不生效
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    // 5.跟上面的注解配置搭配使用，有时候加了上面的配置后注解不生效，需要加入下面的配置
    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator app = new DefaultAdvisorAutoProxyCreator();
        app.setProxyTargetClass(true);
        return app;
    }

    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }
}
