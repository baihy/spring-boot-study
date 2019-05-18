package com.baihy;

import com.baihy.property.DataSource1ConfigPropretues;
import com.baihy.property.DataSource2ConfigPropretues;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @projectName: springboot
 * @packageName: com.baihy
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-18 17:56
 */
@SpringBootApplication
@EnableConfigurationProperties({DataSource1ConfigPropretues.class, DataSource2ConfigPropretues.class})
public class MultiDataSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiDataSourceApplication.class, args);
    }
}
