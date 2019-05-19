package com.baihy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @projectName: springboot
 * @packageName: com.baihy.config
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-19 19:58
 */
@Configuration // 标记这个类是springmvc的配置类，相当于是springmvc.xml的配置
@ComponentScan(basePackages = {"com.baihy.controller"})
@EnableWebMvc // 配置开启springmvc
public class WebConfig {
    // 从spring5.0开始，就不需要继承WebMvcConfigurerAdapter这个类了。


    //配置视图解析器
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/");
        viewResolver.setSuffix(".jsp");
        //在页面中，可以使用${}来访问beans
        viewResolver.setExposeContextBeansAsAttributes(true);
        return viewResolver;
    }
}
