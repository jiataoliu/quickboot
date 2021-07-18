package com.ittao.restful.domain;

/**
 * @ClassName: User
 * @Description: TODO
 * @Author: it-code-liu
 * @CreateTime: 2021/7/17 20:00
 * @Version : V1.0.0
 */
public class User {
    private Integer userId;
    private String userName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
