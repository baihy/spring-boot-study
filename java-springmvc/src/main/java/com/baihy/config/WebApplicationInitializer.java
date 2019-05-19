package com.baihy.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @projectName: springboot
 * @packageName: com.baihy.config
 * @description: 这个类的作用就是初始化DispatcherServlet对象的
 * @author: huayang.bai
 * @date: 2019-05-19 20:03
 */
public class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    // 加载spring容器的配置，相当于是加载application.xml配置文件
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    // 加载springmvc的配置类。相当于是加载springmvc.xml配置文件
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    // 配置dispatcherServlet拦截的请求地址
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
