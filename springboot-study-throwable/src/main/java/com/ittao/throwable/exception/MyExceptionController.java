package com.ittao.throwable.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: MyExceptionController
 * @Description: TODO
 * @Author: it-code-liu
 * @CreateTime: 2021/7/20 2:17
 * @Version : V1.0.0
 */
@ControllerAdvice(annotations = Controller.class)
public class MyExceptionController {
    private static final Logger logger = LoggerFactory.getLogger(MyExceptionController.class);
    public static final String DEFAULT_ERROR_VIEW = "error";

    /**
     * 处理所有的Controller层面的异常
     * 如果这里添加 @ResponseBody 注解 表示抛出的异常以 Rest 的方式返回，这时就系统就不会指向到错误页面 /error
     */
    @ExceptionHandler(Exception.class)
    public final ModelAndView handleAllExceptions(Exception ex, HttpServletRequest request) {
        logger.error(ex.getMessage());
        ModelAndView modelAndView = new ModelAndView();

        //将异常信息设置如modelAndView
        modelAndView.addObject("msg", ex);
        modelAndView.addObject("url", request.getRequestURL());
        modelAndView.setViewName(DEFAULT_ERROR_VIEW);

        //返回ModelAndView
        return modelAndView;
    }

}
