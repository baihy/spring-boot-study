package com.baihy.domain;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @projectName: springboot
 * @packageName: com.baihy.domain
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-18 15:43
 */
@Data
@Accessors(chain = true)
public class User {

    private Integer id;

    private String username;

    private String password;

}
