package com.baihy.service.impl;

import com.baihy.datasource1.service.User1Service;
import com.baihy.datasource2.service.User2Service;
import com.baihy.domain.User;
import com.baihy.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @projectName: springboot
 * @packageName: com.baihy.service.impl
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-18 20:55
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private User1Service user1Service;
    @Autowired
    private User2Service user2Service;

    /**
     * 这种是传统的分布式事务解决方案：jta+atomikos
     *  要把两个事务（test1DataSourceTransactionManager和test2DataSourceTransactionManager）注册到一个
     *  全局的事务管理器里面。
     *  这种在一个项目中的多数据源的分布式事务管理。
     * @param user
     * @return
     */
    @Override
    // @Transactional(transactionManager = "test1DataSourceTransactionManager")
    @Transactional // 开启全局事务之后，就不能指定事务管理器了
    public int save(User user) {
        // 在一个方法中，如果调用两个数据源,那么事务如何控制？
        int result1 = user1Service.save(user);
        int result2 = user2Service.save(user);
        Integer.parseInt(user.getPassword());
        //  因为上面的事务是user1Service的事务管理器，所以，user1Service的save方法会回滚，而user2Service
        // 的方法调用不会回滚
        int result = result1 + result2;
        return result;
    }
}
