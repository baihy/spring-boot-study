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
 * @date: 2019-05-18 10:24
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    public String sayHello() {
        return helloService.sayHello();
    }


    @RequestMapping("/testAsync")
    public String testAsync() {
        helloService.testAsync();
        System.out.println("方法调用之后");
        return "success";
    }

}
