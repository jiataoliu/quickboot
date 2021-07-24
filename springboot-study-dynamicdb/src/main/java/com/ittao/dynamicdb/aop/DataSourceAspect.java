package com.ittao.dynamicdb.aop;

import com.ittao.dynamicdb.annotation.DataSource;
import com.ittao.dynamicdb.config.DynamicContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @ClassName: DataSourceAspect
 * @Description: 多数据源，切面处理类
 * @Author: it-code-liu
 * @CreateTime: 2021/7/24 3:55
 * @Version : V1.0.0
 */
@Aspect
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class DataSourceAspect {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 切面点 指定注解
     * */
    @Pointcut("@annotation(com.ittao.dynamicdb.annotation.DataSource) " +
            "|| @within(com.ittao.dynamicdb.annotation.DataSource)")
    public void dataSourcePointCut() {

    }

    /**
     * 拦截方法指定为 dataSourcePointCut
     * */
    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Class targetClass = point.getTarget().getClass();
        Method method = signature.getMethod();

        DataSource targetDataSource = (DataSource)targetClass.getAnnotation(DataSource.class);
        DataSource methodDataSource = method.getAnnotation(DataSource.class);
        if(targetDataSource != null || methodDataSource != null){
            String value;
            if(methodDataSource != null){
                value = methodDataSource.value();
            }else {
                value = targetDataSource.value();
            }

            DynamicContextHolder.setDataSource(value);
            logger.debug("set datasource is {}", value);
        }

        try {
            return point.proceed();
        } finally {
            DynamicContextHolder.clearDataSource();
            logger.debug("clean datasource");
        }
    }
}
