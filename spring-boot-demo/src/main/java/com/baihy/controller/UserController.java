package com.baihy.controller;

import com.baihy.domain.User;
import com.baihy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: springboot
 * @packageName: com.baihy.controller
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-18 15:47
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/save")
    public int save(User user) {
        return userService.save(user);
    }
}
