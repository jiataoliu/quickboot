package com.ittao.shiro.util;

import com.ittao.shiro.constant.ShiroConstant;
import com.ittao.shiro.domain.TestShiroUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * @ClassName: ShiroUtils
 * @Description: Shiro 工具类
 * @Author: it-code-liu
 * @CreateTime: 2021/7/25 4:14
 * @Version : V1.0.0
 */
public class ShiroUtils {

    public static String sha256(String password, String salt) {
        return new SimpleHash(ShiroConstant.HASH_ALGORITHM_NAME, password, salt, ShiroConstant.HASH_ITERATORS).toString();
    }

    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    public static TestShiroUser getTestShiroUser() {
        return (TestShiroUser) SecurityUtils.getSubject().getPrincipal();
    }

    public static Integer getUserId() {
        return getTestShiroUser().getUserId();
    }

    public static void setSessionAttribute(Object key, Object value) {
        getSession().setAttribute(key, value);
    }

    public static Object getSessionAttribute(Object key) {
        return getSession().getAttribute(key);
    }

    public static boolean isLogin() {
        return SecurityUtils.getSubject().getPrincipal() != null;
    }

    public static void logout() {
        SecurityUtils.getSubject().logout();
    }

    public static void main(String[] args) {
        // 生成随机盐
        String salt = SaltUtils.getSalt(ShiroConstant.SALT_LENGTH);
        salt = "salt";
        System.out.println(salt);
        System.out.println(sha256("666666", salt));
    }

}
