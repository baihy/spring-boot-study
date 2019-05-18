package com.baihy.datasource2.mapper;

import com.baihy.domain.User;
import org.apache.ibatis.annotations.Insert;

/**
 * @projectName: springboot
 * @packageName: com.baihy.datasource2
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-18 17:24
 */
public interface User2Mapper {


    @Insert("insert t_user (username, password) values(#{username}, #{password})")
    int insert(User user);
}
