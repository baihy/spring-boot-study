package com.baihy.controller;

import com.baihy.datasource1.service.User1Service;
import com.baihy.datasource2.service.User2Service;
import com.baihy.domain.User;
import com.baihy.service.HelloService;
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
    private User1Service user1Service;
    @Autowired
    private User2Service user2Service;

    @Autowired
    private HelloService helloService;

    @RequestMapping("/save1")
    public int save1(User user) {
        return user1Service.save(user);
    }

    @RequestMapping("/save2")
    public int save2(User user) {
        return user2Service.save(user);
    }


    @RequestMapping("/save")
    public int save(User user) {
        return helloService.save(user);
    }

}
