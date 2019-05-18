package com.baihy.datasource1.service.impl;

import com.baihy.datasource1.mapper.User1Mapper;
import com.baihy.datasource1.service.User1Service;
import com.baihy.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * 在多数据源环境下，使用@Transactional注解，管理事务一定要指定事务管理器
     * 因为在多数据源环境下， @Transactional注解，会找到多个事务管理器
     *
     * @param user
     * @return
     */
    @Override
    //@Transactional(transactionManager = "test1DataSourceTransactionManager")
    @Transactional // 开启全局事务之后，就不能指定事务管理器了
    public int save(User user) {
        return user1Mapper.insert(user);
    }
}
