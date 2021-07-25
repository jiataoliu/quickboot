package com.ittao.shiro.constant;

/**
 * @ClassName: ShiroConstant
 * @Description: TODO
 * @Author: it-code-liu
 * @CreateTime: 2021/7/25 2:16
 * @Version : V1.0.0
 */
public class ShiroConstant {
    /**
     * 加密算法
     */
    public final static String HASH_ALGORITHM_NAME = "SHA-256";
    /**
     * 随机盐的位数
     **/
    public static final int SALT_LENGTH = 8;
    /**
     * hash 的散列次数
     **/
    public static final int HASH_ITERATORS = 1024;
    /**
     * 免密登录用的万能密码
     */
    public final static String UNIVERSAL_PASSWORD = "UNIVERSAL_PASSWORD";
    /**
     * 用户角色存入 session 的 key
     */
    public final static String SESSION_ROLES = "SESSION_ROLES";
    /**
     * 用户权限存入 session 的 key
     */
    public final static String SESSION_PERMISSIONS = "SESSION_PERMISSIONS";
    /**
     * 验证码存入 session 的 key
     */
    public final static String SESSION_VERIFY_CODE = "SESSION_VERIFY_CODE";
}
