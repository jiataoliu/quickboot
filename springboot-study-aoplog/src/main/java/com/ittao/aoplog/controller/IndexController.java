package com.ittao.aoplog.controller;

import com.ittao.aoplog.annotation.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: IndexController
 * @Description: TODO
 * @Author: it-code-liu
 * @CreateTime: 2021/7/20 22:25
 * @Version : V1.0.0
 */

/**
 * @Aspect 面向切面编程注解，通常应用在类上
 * @Pointcut Pointcut 是植入 Advice 的触发条件。
 * 每个 Pointcut 的定义包括2部分，一是表达式，二是方法签名。
 * 方法签名必须是 public 及 void 型。
 * 可以将 Pointcut 中的方法看作是一个被 Advice 引用的助记符，
 * 因为表达式不直观，因此我们可以通过方法签名的方式为 此表达式命名。
 * 因此 Pointcut 中的方法只需要方法签名，而不需要在方法体内编写实际代码
 * @Around：环绕增强，相当于MethodInterceptor
 * @AfterReturning：后置增强，相当于AfterReturningAdvice，方法正常退出时执行
 * @Before：标识一个前置增强方法，相当于BeforeAdvice的功能，相似功能的还有
 * @AfterThrowing：异常抛出增强，相当于ThrowsAdvice
 * @After: final 增强，不管是抛出异常或者正常退出都会执行
 */
@Controller
public class IndexController {

    /**
     * http://localhost:9000/log?name=spring
     *
     * @param name
     * @return
     */
    @Log("日志注解，配合WebAspect记录请求前、请求后、请求过程")
    @RequestMapping("/log")
    @ResponseBody
    public String log(String name) {
        return "Hello " + name;
    }
}
