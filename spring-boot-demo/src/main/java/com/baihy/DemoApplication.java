package com.baihy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @projectName: springboot
 * @packageName: com.baihy
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-12 11:18
 */
// @SpringBootApplication //原理是扫描同级包
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.baihy.controller", "com.baihy.service"}) // 这里是定位扫描包
@MapperScan(basePackages = {"com.baihy.mapper"})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

    }

}
