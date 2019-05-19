package com.baihy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @projectName: springboot
 * @packageName: com.baihy.controller
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-19 20:35
 */
@Controller
public class UserController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

}
