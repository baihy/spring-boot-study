package com.baihy.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @projectName: springboot
 * @packageName: com.baihy.config
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-18 17:32
 */
@Configuration
@MapperScan(basePackages = {"com.baihy.datasource2.mapper"}, sqlSessionFactoryRef = "test2SqlSessionFactory")
public class DataSource2Config {

    //1.配置数据源
    //2.配置SqlSessionFactory
    //3.配置事务管理器
    //4.配置template

    // 配置数据源
    @Bean(name = "test2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.test2")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    // 配置SqlSessionFactory
    @Bean(name = "test2SqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(DataSource test2DataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(test2DataSource);
        return sqlSessionFactoryBean.getObject();
    }


    // 配置事务管理器
    @Bean(name = "test2DataSourceTransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource test2DataSource) {
        return new DataSourceTransactionManager(test2DataSource);
    }


    // 配置template
    @Bean(name = "test2SqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory test2SqlSessionFactory) {
        return new SqlSessionTemplate(test2SqlSessionFactory);
    }

}
