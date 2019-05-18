package com.baihy.property;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @projectName: springboot
 * @packageName: com.baihy.property
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-18 22:10
 */

@ConfigurationProperties(prefix = "spring.datasource.test1")
@Data
@Accessors(chain = true)
public class DataSource1ConfigPropretues {

    private String url;

    private String username;

    private String password;
}
