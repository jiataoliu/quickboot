package com.ittao.jpa.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: TestJpa
 * @Description: TODO
 * @Author: it-code-liu
 * @CreateTime: 2021/7/23 2:40
 * @Version : V1.0.0
 */
@Entity
@Table(name = "test_jpa")
public class TestJpa implements Serializable {
    private static final long serialVersionUID = -1L;
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    /**
     * 用户名
     */
    @Column(name = "user_name", length = 32)
    private String userName;
    /**
     * 密码
     */
    @Column(name = "password", length = 32)
    private String password;
    /**
     * 状态 0-删除 1-正常
     */
    @Column(name = "status")
    private Integer status;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;
    /**
     * 登录时间
     */
    @Column(name = "login_time")
    private Date loginTime;
    /**
     * 备注
     */
    @Column(name = "remark", length = 128)
    private String remark;

    public TestJpa() {
    }

    public TestJpa(Integer userId, String userName, String password, Integer status, Date createTime, Date loginTime, String remark) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.status = status;
        this.createTime = createTime;
        this.loginTime = loginTime;
        this.remark = remark;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
