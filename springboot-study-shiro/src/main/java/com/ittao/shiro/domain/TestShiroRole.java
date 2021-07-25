package com.ittao.shiro.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * 测试角色表(TestShiroRole)实体类
 *
 * @author makejava
 * @since 2021-07-25 01:43:24
 */
public class TestShiroRole implements Serializable {
    private static final long serialVersionUID = -1L;
    /**
     * 角色ID
     */
    @TableId(value ="role_id")
    private Integer roleId;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 状态 0-删除 1-正常
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 备注
     */
    private String remark;
    /**
     * 角色ID列表
     */
    @TableField(exist=false)
    private List<Long> roleIdList;


    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
