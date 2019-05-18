package com.baihy.mapper;

import com.baihy.domain.User;
import org.apache.ibatis.annotations.Insert;

/**
 * @projectName: springboot
 * @packageName: com.baihy.mapper
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-18 15:44
 */

public interface UserMapper {


    @Insert("insert t_user (username, password) values(#{username}, #{password})")
    int insert(User user);

}
