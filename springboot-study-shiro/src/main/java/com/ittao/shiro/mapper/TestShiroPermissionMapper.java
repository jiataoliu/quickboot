package com.ittao.shiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ittao.shiro.domain.TestShiroPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 测试权限表(TestShiroPermission)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-25 01:43:20
 */
@Mapper
public interface TestShiroPermissionMapper extends BaseMapper<TestShiroPermission> {
    /**
     * 根据角色 id 获取角色的权限集合
     *
     * @param roleId
     * @return
     */
    @Select("select p.permission_id,p.permission_name from test_shiro_permission p left join test_shiro_role_permission rp on rp.permission_id = p.permission_id where rp.role_id = #{roleId}")
    List<TestShiroPermission> getPermissionsByRoleId(Integer roleId);
}
