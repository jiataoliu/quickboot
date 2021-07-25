package com.ittao.shiro.realm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ittao.shiro.constant.ShiroConstant;
import com.ittao.shiro.domain.TestShiroPermission;
import com.ittao.shiro.domain.TestShiroRole;
import com.ittao.shiro.domain.TestShiroUser;
import com.ittao.shiro.service.TestShiroPermissionService;
import com.ittao.shiro.service.TestShiroRoleService;
import com.ittao.shiro.service.TestShiroUserService;
import com.ittao.shiro.util.ShiroUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @ClassName: CustomerRealm
 * @Description: 自定义认证 realm
 * @Author: it-code-liu
 * @CreateTime: 2021/7/25 2:34
 * @Version : V1.0.0
 */
public class CustomerRealm extends AuthorizingRealm {
    @Autowired
    private TestShiroUserService testShiroUserService;

    @Autowired
    private TestShiroRoleService testShiroRoleService;

    @Autowired
    private TestShiroPermissionService testShiroPermissionService;

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 根据主身份信息获取角色信息
        TestShiroUser user = (TestShiroUser) principals.getPrimaryPrincipal();

        // 根据用户 id 获取用户的角色集合
        List<TestShiroRole> roles = this.testShiroRoleService.getRolesByUserId(user.getUserId());

        if (!CollectionUtils.isEmpty(roles)) {
            // 把 roles 当做参数注册到 session 里面
            ShiroUtils.setSessionAttribute(ShiroConstant.SESSION_ROLES, roles);
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            roles.forEach(role -> {
                simpleAuthorizationInfo.addRole(role.getRoleName());

                // 根据角色 id 获取角色的权限集合
                List<TestShiroPermission> permissions = this.testShiroPermissionService.getPermissionsByRoleId(role.getRoleId());
                if (!CollectionUtils.isEmpty(permissions)) {
                    // 把 permissions 当做参数注册到 session 里面
                    ShiroUtils.setSessionAttribute(ShiroConstant.SESSION_PERMISSIONS, permissions);
                    permissions.forEach(permission -> {
                        simpleAuthorizationInfo.addStringPermission(permission.getPermissionName());
                    });
                }
            });
            return simpleAuthorizationInfo;
        }
        return null;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        // 是否是免密登录
        boolean loginFlag = false;

        // 判断是否免密登陆类型
        if (authcToken instanceof UsernameToken) {
            loginFlag = true;
        }

        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String userName = token.getUsername();

        // 查询用户信息
        TestShiroUser user = this.testShiroUserService.getOne(new QueryWrapper<TestShiroUser>().eq("user_name", userName));

        // 账号不存在
        if (user == null) {
            throw new UnknownAccountException("账号或密码不正确");
        }

        // 账号锁定
        if (user.getStatus() == 0) {
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }

        // 如果是免密登录
        if (loginFlag) {
            return new SimpleAuthenticationInfo(user,
                    ShiroUtils.sha256(ShiroConstant.UNIVERSAL_PASSWORD, user.getSalt()),
                    ByteSource.Util.bytes(user.getSalt()),
                    this.getName());
        }

        return new SimpleAuthenticationInfo(user,
                user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()),
                this.getName());
    }

    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher shaCredentialsMatcher = new HashedCredentialsMatcher();
        shaCredentialsMatcher.setHashAlgorithmName(ShiroConstant.HASH_ALGORITHM_NAME);
        shaCredentialsMatcher.setHashIterations(ShiroConstant.HASH_ITERATORS);
        super.setCredentialsMatcher(shaCredentialsMatcher);
    }
}

