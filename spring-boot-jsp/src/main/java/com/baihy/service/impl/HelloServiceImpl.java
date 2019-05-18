package com.baihy.service.impl;

import com.baihy.service.HelloService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


/**
 * @projectName: springboot
 * @packageName: com.baihy.service.impl
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-18 11:33
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello() {
        return "success";
    }

    @Override
    @Async
    public void testAsync() {
        try {
            // 让线程睡觉是为了看出明显的效果。
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("测试异步调用");
    }
}
