package com.ittao.shiro.controller;

import com.ittao.shiro.constant.ShiroConstant;
import com.ittao.shiro.domain.TestShiroPermission;
import com.ittao.shiro.domain.TestShiroRole;
import com.ittao.shiro.domain.TestShiroUser;
import com.ittao.shiro.realm.UsernameToken;
import com.ittao.shiro.service.TestShiroUserService;
import com.ittao.shiro.util.ShiroUtils;
import com.ittao.shiro.util.VerifyCodeUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 测试用户表(TestShiroUser)表控制层
 *
 * @author makejava
 * @since 2021-07-25 01:43:23
 */
@Controller
@RequestMapping("/user")
public class TestShiroUserController {
    /**
     * 服务对象
     */
    @Resource
    private TestShiroUserService testShiroUserService;

    /**
     * http://localhost:9000/user/index
     *
     * @return
     */
    @GetMapping("index")
    public String index() {
        return "index";
    }

    @GetMapping("login")
    public String login() {
        return "login";
    }

    /**
     * http://localhost:9000/user/selectOne
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @GetMapping("selectOne")
    @ResponseBody
    @RequiresRoles("sys")
    public TestShiroUser selectOne() {
        TestShiroUser testShiroUser = ShiroUtils.getTestShiroUser();

        List<TestShiroRole> roles = (List) ShiroUtils.getSessionAttribute(ShiroConstant.SESSION_ROLES);
        if (roles != null && !roles.isEmpty()) {
            List<Integer> roleIdList = new ArrayList<Integer>();
            roles.forEach(r ->
                    roleIdList.add(r.getRoleId())
            );
            testShiroUser.setRoleIdList(roleIdList);
        }

        List<TestShiroPermission> permissions = (List) ShiroUtils.getSessionAttribute(ShiroConstant.SESSION_PERMISSIONS);
        if (permissions != null && !permissions.isEmpty()) {
            List<Integer> permissionIdList = new ArrayList<Integer>();
            permissions.forEach(p ->
                    permissionIdList.add(p.getPermissionId())
            );
            testShiroUser.setPermissionIdList(permissionIdList);
        }

        return testShiroUser;
    }

    /**
     * 用户注册
     * http://localhost:9000/user/register
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("register")
    public String register(String username, String password) {
        try {
            TestShiroUser testShiroUser = new TestShiroUser();
            testShiroUser.setUserName(username);
            testShiroUser.setPassword(password);
            testShiroUser.setStatus(1);
            testShiroUser.setCreateTime(new Date());
            testShiroUser.setLoginTime(new Date());
            testShiroUser.setRemark(password);
            this.testShiroUserService.save(testShiroUser);
            return "login";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "register";
    }

    /**
     * 用户登录
     * http://localhost:9000/user/login
     *
     * @param username
     * @param password
     * @param verifyCode
     * @return
     */
    @PostMapping("login")
    public String login(String username, String password, String verifyCode, HttpSession session) {
        // 校验验证码
        String verifyCodes = (String) session.getAttribute(ShiroConstant.SESSION_VERIFY_CODE);
        if (!verifyCodes.equalsIgnoreCase(verifyCode)) {
            System.out.println("验证码错误~");
            return "login";
        }

        // 获取当前登录用户
        Subject subject = ShiroUtils.getSubject();

        try {
            // 执行登录操作
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
            // 认证通过后直接跳转到 index.html
            return "index";
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名错误~");
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            System.out.println("密码错误~");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 如果认证失败仍然回到登录页面
        return "login";
    }

    /**
     * 用户免密登录
     * http://localhost:9000/user/loginUserName
     *
     * @param username
     * @param verifyCode
     * @return
     */
    @PostMapping("loginUserName")
    public String loginUserName(String username, String verifyCode, HttpSession session) {
        // 校验验证码
        String verifyCodes = (String) session.getAttribute(ShiroConstant.SESSION_VERIFY_CODE);
        if (!verifyCodes.equalsIgnoreCase(verifyCode)) {
            System.out.println("验证码错误~");
            return "login";
        }

        // 获取当前登录用户
        Subject subject = ShiroUtils.getSubject();

        try {
            // 执行登录操作
            UsernameToken token = new UsernameToken(username);
            subject.login(token);
            // 认证通过后直接跳转到 index.html
            return "index";
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名错误~");
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            System.out.println("密码错误~");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 如果认证失败仍然回到登录页面
        return "login";
    }

    /**
     * 用户登出
     * http://localhost:9000/user/logout
     *
     * @return
     */
    @RequestMapping("logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
        // 退出后仍然会到登录页面
        return "login";
    }

    /**
     * 生成验证码
     *
     * @param session
     * @param response
     * @throws IOException
     */
    @RequestMapping("getImage")
    public void getImage(HttpSession session, HttpServletResponse response) throws IOException {
        //生成验证码
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        //验证码放入session
        session.setAttribute(ShiroConstant.SESSION_VERIFY_CODE, verifyCode);
        //验证码存入图片
        ServletOutputStream os = response.getOutputStream();

        // 设置返回头信息，内容类型为图片
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");

        VerifyCodeUtils.outputImage(180, 40, os, verifyCode);
    }

}
