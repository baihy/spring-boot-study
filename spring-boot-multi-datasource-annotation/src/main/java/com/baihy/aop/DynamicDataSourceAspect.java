package com.baihy.aop;

import com.baihy.annotation.DataSource;
import com.baihy.datasource.DataSourceContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.lang.reflect.Method;

/**
 * @projectName: springboot
 * @packageName: com.baihy.aop
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-18 19:15
 */
@Configuration
@Aspect
@Order(value = 0) // 设置切面的优先级，值越小，优先级越高，设置@Order是为了保证数据源切换在开启事务之前
public class DynamicDataSourceAspect {


    // 拦截所有的service方法
    @Pointcut("execution(* com.baihy.service.*.*(..))")
    public void changeDataSource() {

    }

    @Before("changeDataSource()")
    public void before(JoinPoint joinPoint) throws NoSuchMethodException {
        Object target = joinPoint.getTarget();
        Class<?> targetClass = target.getClass();
        // 判断类上面有没有配置数据源
        DataSource dataSourceAnnotation = targetClass.getAnnotation(DataSource.class);
        String dataSourceName = null;
        if (dataSourceAnnotation != null) {
            dataSourceName = dataSourceAnnotation.value();
        } else {// 判断方法上有没有配置数据源
            // 获取访问方法的名称
            String methodName = joinPoint.getSignature().getName();
            // 获取访问方法的参数类型列表
            Class[] argClass = ((MethodSignature) joinPoint.getSignature()).getParameterTypes();
            // 通过反射获取指定的方法
            Method method = targetClass.getMethod(methodName, argClass);
            DataSource dataSourceMethodAnnotation = method.getAnnotation(DataSource.class);
            if (dataSourceMethodAnnotation != null) {
                dataSourceName = dataSourceMethodAnnotation.value();
            }
        }
        DataSourceContextHolder.setDataSource(dataSourceName);
    }

    /**
     * 方法调用之后，需要把数据源清空
     */
    @After("changeDataSource()")
    public void after() {
        DataSourceContextHolder.clearDataSource();
    }


}
