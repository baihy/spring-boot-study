package com.baihy.service.impl;

import com.baihy.domain.User;
import com.baihy.mapper.UserMapper;
import com.baihy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @projectName: springboot
 * @packageName: com.baihy.service.impl
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-18 15:46
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 下面的方法，添加上了开启事务的注解（springboot默认是开启事务）
     *  如果下面的方法，不加@Transactional注解时，执行完了30行，保存数据的代码，事务就会提交，当执行到31行代码时，会报出异常，
     *  那么就不会往下执行了，此时事务已经提交了，事务就不会回滚了
     *  如果下面的方法，加上了@Transactional注解，执行完30行，保存数据的代码，事务不会提交，当执行到31行代码时，会报出异常，此时，事务还没有
     *  提交，所有此时数据库中，不会保存这个数据。
     *  所以：加不加@Transactional注解的区别在于：提交事务的时间。
     *      加了：那么方法执行完，不发生异常的情况下，提交事务。
     *      不加：执行完保存数据的代码就会提交事务，不管方法的代码有没有执行完。
     */
    @Override
    @Transactional
    public int save(User user) {
        Integer result = userMapper.insert(user); // 加上@Transactional注解，这行代码不会提交事务。如果不加，就会提交事务。
        Integer.parseInt("abc");
        return result;
    }
}
