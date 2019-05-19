package com.baihy.service.impl;

import com.baihy.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @projectName: springboot
 * @packageName: com.baihy.service.impl
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-19 19:57
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello() {
        return "hello 柏华洋";
    }
}
