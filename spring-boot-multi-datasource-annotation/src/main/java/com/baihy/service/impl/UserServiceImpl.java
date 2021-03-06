package com.baihy.service.impl;

import com.baihy.annotation.DataSource;
import com.baihy.domain.User;
import com.baihy.mapper.UserMapper;
import com.baihy.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @Transactional
    public int save1(User user) {
        Integer result = userMapper.insert(user);
        Integer.parseInt("abc");
        return result;
    }

    @Override
    @DataSource("test")
    public int save2(User user) {
        return userMapper.insert(user);
    }


    @Override
    @DataSource
    public PageInfo<User> find(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<User> users = userMapper.find();
        return new PageInfo<>(users);
    }
}

