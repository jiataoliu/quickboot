package com.ittao.aoplog.aspect;

import com.ittao.aoplog.annotation.Log;
import com.ittao.aoplog.util.HttpContextUtils;
import com.ittao.aoplog.util.IPUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

/**
 * @ClassName: LogAspect
 * @Description: TODO
 * @Author: it-code-liu
 * @CreateTime: 2021/7/20 22:25
 * @Version : V1.0.0
 */
@Aspect
@Component
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    /**
     * 这里指定使用 @annotation 指定com.spring.aoplog.annotation.Log log注解
     */
    @Pointcut("@annotation(com.ittao.aoplog.annotation.Log)")
    public void logPointCut() {
    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        // 执行方法
        Object result = point.proceed();
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        // 异步保存日志 这里是文本日志
        saveLog(point, time);

        return result;
    }

    public void saveLog(ProceedingJoinPoint joinPoint, long time) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        // 保存系统日志
        logger.info("开始异步保存日志 : 》》》》》》》");
        logger.info("请求的时间 : " + new Date());

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();


        Log syslog = method.getAnnotation(Log.class);

        // 注解上的描述
        logger.info("注解上的描述 : " + syslog.value());

        // 获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();

        logger.info("请求地址 : " + request.getRequestURL().toString());
        logger.info("HTTP METHOD : " + request.getMethod());

        // 请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        logger.info("请求的方法名 : " + className + "." + methodName + "()");

        // 请求的参数
        Object[] args = joinPoint.getArgs();
        logger.info("请求的参数 : " + Arrays.toString(joinPoint.getArgs()));


        // 设置IP地址
        logger.info("设置IP地址 : " + IPUtils.getIpAddr(request));

        logger.info("耗时 : " + time);

        // 保存系统日志
        logger.info("结束异步保存日志 : 》》》》》》》");
    }
}
