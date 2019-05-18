package com.baihy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @projectName: springboot
 * @packageName: com.baihy
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-18 10:26
 */
@SpringBootApplication
@EnableAsync // 开启异步调用
public class SpringJspApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJspApplication.class, args);

    }

}
