package com.ittao.aoplog.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: HttpContextUtils
 * @Description: 获取 request
 * @Author: it-code-liu
 * @CreateTime: 2021/7/20 23:48
 * @Version : V1.0.0
 */
public class HttpContextUtils {

    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }
}
