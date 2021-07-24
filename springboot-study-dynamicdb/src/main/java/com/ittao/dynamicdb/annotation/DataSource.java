package com.ittao.dynamicdb.annotation;

import java.lang.annotation.*;

/**
 * @ClassName: DataSource
 * @Description: 多数据源注解
 * 在方法名上加入 DataSource('名称')
 * @Author: it-code-liu
 * @CreateTime: 2021/7/24 3:53
 * @Version : V1.0.0
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DataSource {
    String value() default "";
}

