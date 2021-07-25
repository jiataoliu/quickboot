package com.ittao.shiro.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Locale;

/**
 * @ClassName: ApplicationContextUtils
 * @Description: TODO
 * @Author: it-code-liu
 * @CreateTime: 2021/7/25 15:38
 * @Version : V1.0.0
 */
public class ApplicationContextUtils implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        System.out.println("--------------------context--------------------" + context);
        this.applicationContext = context;
    }


    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }

    public static String getMessage(String key) {
        return applicationContext.getMessage(key, null, Locale.getDefault());
    }
}
