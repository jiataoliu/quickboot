package com.ittao.aoplog.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: IPUtils
 * @Description: TODO
 * @Author: it-code-liu
 * @CreateTime: 2021/7/20 23:49
 * @Version : V1.0.0
 */
public class IPUtils {
    private static Logger logger = LoggerFactory.getLogger(IPUtils.class);

    /**
     * 获取IP地址
     * <p>
     * 使用 Nginx 等反向代理软件， 则不能通过 request.getRemoteAddr() 获取IP地址
     * 如果使用了多级反向代理的话，X-Forwarded-For 的值并不止一个，而是一串IP地址，X-Forwarded-For 中第一个非 unknown 的有效IP字符串，则为真实IP地址
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = null;
        try {
            ip = request.getHeader("x-forwarded-for");
            if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (StringUtils.isEmpty(ip) || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
        } catch (Exception e) {
            logger.error("IPUtils ERROR ", e);
        }

        // 使用代理，则获取第一个IP地址
        if(StringUtils.isEmpty(ip) && ip.length() > 15) {
			if(ip.indexOf(",") > 0) {
				ip = ip.substring(0, ip.indexOf(","));
			}
		}

        return ip;
    }
}
