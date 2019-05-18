package com.baihy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @projectName: springboot
 * @packageName: com.baihy
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-18 17:56
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.baihy.mapper"})
public class MultiDataSourceAnnotationApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiDataSourceAnnotationApplication.class, args);
    }
}
