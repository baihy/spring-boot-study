package com.baihy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @projectName: springboot
 * @packageName: com.baihy.config
 * @description: 这个相当于是application.xml配置文件，我们在这个配置文件中只需要扫描除了Controller之外的其他注解
 * @author: huayang.bai
 * @date: 2019-05-19 19:58
 */
@Configuration // 标记这个类是Spring容器配置类，相当于是application.xml
@ComponentScan(basePackages = {"com.baihy.service"})
public class RootConfig {
}
