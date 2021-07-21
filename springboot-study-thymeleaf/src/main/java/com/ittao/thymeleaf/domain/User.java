package com.ittao.thymeleaf.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: User
 * @Description: TODO
 * @Author: it-code-liu
 * @CreateTime: 2021/7/21 3:46
 * @Version : V1.0.0
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private String sex;
    private Date birthday;

    public User() {
    }

    public User(String username, String sex, Date birthday) {
        this.username = username;
        this.sex = sex;
        this.birthday = birthday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
