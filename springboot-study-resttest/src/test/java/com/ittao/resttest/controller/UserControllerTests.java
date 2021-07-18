package com.ittao.resttest.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @ClassName: UserControllerTests
 * @Description: TODO
 * @Author: it-code-liu
 * @CreateTime: 2021/7/18 12:10
 * @Version : V1.0.0
 */

@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTests {
    private MockMvc mockMvc;// 定义一个 MockMvc

    @Autowired
    private WebApplicationContext webApplicationContext;

    /**
     * 初始化 MockMvc
     */
    @Before
    public void setUp() throws Exception {
        // MockMvcBuilders.webAppContextSetup(WebApplicationContext context)：指定 WebApplicationContext，将会从该上下文获取相应的控制器并得到相应的 MockMvc；
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();// 建议使用这种
    }

    /**
     * 测试 Hello World 方法
     */
    @Test
    public void hello() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/user/hello")
                .param("name", "itTao")
                .accept(MediaType.TEXT_HTML_VALUE)) // perform 结束
                .andExpect(MockMvcResultMatchers.status().isOk()) // 添加断言
                .andExpect(MockMvcResultMatchers.content().string("Hello itTao"))// 添加断言
                .andDo(MockMvcResultHandlers.print()) // 添加执行
                .andReturn();// 添加返回

        // 下面部分等等与 addExcept 部分
        int status = mvcResult.getResponse().getStatus(); //得到返回代码
        String content = mvcResult.getResponse().getContentAsString(); // 得到返回结果
        Assert.assertEquals(200, status); // 等于 andExpect(MockMvcResultMatchers.status().isOk()) //添加断言
        Assert.assertEquals("Hello itTao", content); // andExpect(MockMvcResultMatchers.content().string("Hello World"))//添加断言
    }

    /**
     * 测试用户列表获取 /users GET
     */
    @Test
    public void getUsers() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/user/users")
                .accept(MediaType.APPLICATION_JSON));

        // 设置编码，防止中文乱码
        MockHttpServletResponse response = resultActions.andReturn().getResponse();
        response.setCharacterEncoding("UTF-8");

        resultActions.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    /**
     * 获取单个用户信息 /users/3 GET
     */
    @Test
    public void getUser() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/user/users/3")
                .accept(MediaType.APPLICATION_JSON));

        // 设置编码，防止中文乱码
        MockHttpServletResponse response = resultActions.andReturn().getResponse();
        response.setCharacterEncoding("UTF-8");

        resultActions.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    /**
     * 新增单个用户信息 /users/ POST
     * 注意 addUser 使用了 @RequestBody 方法，对应使用 .contentType(MediaType.APPLICATION_JSON).content(json 字符串)
     */
    @Test
    public void addUser() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/user/users")
                .contentType(MediaType.APPLICATION_JSON).content("{ \"userId\": 5,\"userName\": \"ittao\"}"));

        // 设置编码，防止中文乱码
        MockHttpServletResponse response = resultActions.andReturn().getResponse();
        response.setCharacterEncoding("UTF-8");

        resultActions.andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    /**
     * 编辑一个用户 /users/ PUT
     */
    @Test
    public void editUser() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.put("/user/users/3")
                .contentType(MediaType.APPLICATION_JSON).content("{ \"userId\": 3,\"userName\": \"ittao\"}"));

        // 设置编码，防止中文乱码
        MockHttpServletResponse response = resultActions.andReturn().getResponse();
        response.setCharacterEncoding("UTF-8");

        resultActions.andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    /**
     * 删除一个用户 /users/ DELETE
     * */
    @Test
    public void deleteUser() throws  Exception{
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.delete("/user/users/3")
                .contentType(MediaType.APPLICATION_JSON));

        // 设置编码，防止中文乱码
        MockHttpServletResponse response = resultActions.andReturn().getResponse();
        response.setCharacterEncoding("UTF-8");

        resultActions.andExpect(MockMvcResultMatchers.status().isNoContent())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

}
