package com.baihy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @projectName: springboot
 * @packageName: com.baihy.controller
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-18 10:27
 */
@Controller
public class JspController {

    @RequestMapping("/jsp")
    public String jspIndex() {
        System.out.println("访问成功页面");
        return "success";
    }

}
