package com.baihy.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @projectName: springboot
 * @packageName: com.baihy.aop
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-18 13:14
 */
@Aspect  // 指定这个类为切面
@Configuration // 把切面交给spring容器来管理
@Slf4j
public class WebLogAop {

    // 定义切点： 指定切点拦截的范围
    @Pointcut("execution(public * com.baihy.controller.*.*(..))")
    public void webLog() {
    }

    // 定义前置通过做
    @Before("webLog()")
    public void before(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        // 获取到request请求对象
        HttpServletRequest request = requestAttributes.getRequest();
        StringBuffer url = request.getRequestURL(); //  获取请求地址
        log.info("url:{}", url);
        String ip = request.getRemoteAddr(); //获取ip地址
        log.info("ip:{}", url);
    }


    // 定义后置通知
    @AfterReturning(returning = "object", pointcut = "webLog()")
    public void after(Object object) {
        log.info("响应的结果是：{}", object);
    }
}
