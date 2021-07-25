package com.ittao.shiro.domain;

import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;
import java.io.Serializable;

/**
 * 测试权限表(TestShiroPermission)实体类
 *
 * @author makejava
 * @since 2021-07-25 01:43:20
 */
public class TestShiroPermission implements Serializable {
    private static final long serialVersionUID = -1L;
    /**
     * 权限ID
     */
    @TableId(value ="permission_id")
    private Integer permissionId;
    /**
     * 权限名称
     */
    private String permissionName;
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


    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
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
