package com.baihy.mapper;

import com.baihy.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @projectName: springboot
 * @packageName: com.baihy.mapper
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-18 19:26
 */
public interface UserMapper {

    /**
     * 保存方法
     *
     * @param user
     * @return
     */
    @Insert("insert t_user (username, password) values(#{username}, #{password})")
    int insert(User user);



    @Select("select id,username,password from t_user")
    List<User> find();


}
