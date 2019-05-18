package com.baihy.datasource2.service.impl;

import com.baihy.datasource2.mapper.User2Mapper;
import com.baihy.datasource2.service.User2Service;
import com.baihy.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @projectName: springboot
 * @packageName: com.baihy.datasource2.service.impl
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-18 17:27
 */
@Service
public class User2ServiceImpl implements User2Service {

    @Autowired
    private User2Mapper user2Mapper;

    @Override
    public int save(User user) {
        return user2Mapper.insert(user);
    }
}
