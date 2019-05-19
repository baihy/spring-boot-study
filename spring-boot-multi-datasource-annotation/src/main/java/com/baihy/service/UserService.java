package com.baihy.service;

import com.baihy.domain.User;
import com.github.pagehelper.PageInfo;

/**
 * @projectName: springboot
 * @packageName: com.baihy.service
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-18 19:22
 */
public interface UserService {


    int save1(User user);

    int save2(User user);


    PageInfo<User> find(Integer page, Integer pageSize);

}
