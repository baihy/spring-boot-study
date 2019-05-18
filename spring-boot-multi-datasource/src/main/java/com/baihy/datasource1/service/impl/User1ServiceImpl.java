package com.baihy.datasource1.service.impl;

import com.baihy.datasource1.mapper.User1Mapper;
import com.baihy.datasource1.service.User1Service;
import com.baihy.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @projectName: springboot
 * @packageName: com.baihy.datasource1.service.impl
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-18 17:25
 */
@Service
public class User1ServiceImpl implements User1Service {


    @Autowired
    private User1Mapper user1Mapper;

    @Override
    public int save(User user) {
        return user1Mapper.insert(user);
    }
}
