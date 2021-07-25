package com.ittao.shiro.util;

import org.apache.shiro.crypto.hash.SimpleHash;

import java.util.Random;

/**
 * @ClassName: SaltUtils
 * @Description: 用户随机盐生成工具类
 * @Author: it-code-liu
 * @CreateTime: 2021/7/25 2:17
 * @Version : V1.0.0
 */
public class SaltUtils {
    /**
     * 生成salt的静态方法
     *
     * @param n
     * @return
     */
    public static String getSalt(int n) {
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz01234567890!@#$%^&*()".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char aChar = chars[new Random().nextInt(chars.length)];
            sb.append(aChar);
        }
        return sb.toString();
    }

    /**  加密算法 */
    public final static String hashAlgorithmName = "SHA-256";
    /**  循环次数 */
    public final static int hashIterations = 16;

    public static String sha256(String password, String salt) {
        return new SimpleHash(hashAlgorithmName, password, salt, hashIterations).toString();
    }
}
