package com.ittao.shiro.realm;

import com.ittao.shiro.constant.ShiroConstant;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @ClassName: UsernameToken
 * @Description: shiro 免密登录
 * @Author: it-code-liu
 * @CreateTime: 2021/7/25 4:55
 * @Version : V1.0.0
 */
public class UsernameToken extends UsernamePasswordToken {
    public UsernameToken(String username) {
        this.username = username;
    }

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Object getCredentials() {
        // 这里和下方的 免密验证密码 对应，也可以别的，一致即可。
        return ShiroConstant.UNIVERSAL_PASSWORD;
    }
}
