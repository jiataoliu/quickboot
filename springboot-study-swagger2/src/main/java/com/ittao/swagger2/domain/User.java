package com.ittao.swagger2.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName: User
 * @Description: TODO
 * @Author: it-code-liu
 * @CreateTime: 2021/7/17 20:00
 * @Version : V1.0.0
 */
@ApiModel(value = "user对象", description = "用户对象user")
public class User {
    @ApiModelProperty(value = "用户ID", name = "userId", example = "1")
    private Integer userId;
    @ApiModelProperty(value = "用户名", name = "userName", example = "ittao")
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
