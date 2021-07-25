package com.ittao.shiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ittao.shiro.domain.TestShiroRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 测试角色表(TestShiroRole)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-25 01:43:25
 */
@Mapper
public interface TestShiroRoleMapper extends BaseMapper<TestShiroRole> {
    /**
     * 根据用户 id 获取用户的角色集合
     *
     * @param userId
     * @return
     */
    @Select("select r.role_id,r.role_name from test_shiro_role r left join test_shiro_user_role ur on ur.role_id = r.role_id where ur.user_id = #{userId}")
    List<TestShiroRole> getRolesByUserId(Integer userId);
}
