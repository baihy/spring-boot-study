package com.baihy.service.impl;

import com.baihy.annotation.DataSource;
import com.baihy.domain.User;
import com.baihy.mapper.UserMapper;
import com.baihy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @projectName: springboot
 * @packageName: com.baihy.service.impl
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-18 19:24
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @DataSource("baihy")
    public int save1(User user) {
        return userMapper.insert(user);
    }

    @Override
    @DataSource("test")
    public int save2(User user) {
        return userMapper.insert(user);
    }
}
