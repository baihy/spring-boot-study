package com.baihy.bootjar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: springboot
 * @packageName: com.baihy.bootjar.controller
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-19 12:38
 */
@RestController
public class HelloController {


    @RequestMapping("/hello")
    public String sayHello() {
        return "hello world";
    }

}
