package com.baihy.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: springboot
 * @packageName: com.baihy.handler
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-18 11:27
 */
// 开启全局捕获异常。basePackages属性是指定发生异常的范围
@ControllerAdvice(basePackages = "com.baihy.controller")
public class GlobalExceptionHandler {

    /**
     * 处理json响应格式的异常
     * @return
     */
    @ResponseBody
    @ExceptionHandler({RuntimeException.class})// 指定处理异常的类型
    public Map<String, Object> handleJsonException() {
        /**
         * 一般情况下，在实际的应用中，如果发生了异常，需要把异常信息存入日志中，一般是存在mongodb中。
         */
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("errorCode", "404");
        resultMap.put("message", "页面找不到");
        return resultMap;
    }

}
