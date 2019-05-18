package com.baihy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: springboot
 * @packageName: com.baihy.controller
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-12 11:17
 */
@RestController
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "spring boot应用";
    }

}
