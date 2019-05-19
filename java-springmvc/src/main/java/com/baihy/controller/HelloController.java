package com.baihy.controller;

import com.baihy.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: springboot
 * @packageName: com.baihy.controller
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-19 19:56
 */
@RestController
public class HelloController {


    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    public String sayHello() {
        return helloService.sayHello();
    }


}
