package com.baihy.config;

import com.baihy.property.DataSource1ConfigPropretues;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @projectName: springboot
 * @packageName: com.baihy.config
 * @description: 开启全局事务
 * @author: huayang.bai
 * @date: 2019-05-18 17:32
 */
@Configuration
@MapperScan(basePackages = {"com.baihy.datasource1.mapper"}, sqlSessionFactoryRef = "test1SqlSessionFactory")
public class DataSource1ConfigGT {
    @Autowired
    private DataSource1ConfigPropretues dataSource1ConfigPropretues;
    //1.配置数据源
    //2.配置SqlSessionFactory
    //3.配置事务管理器
    //4.配置template
    // 配置数据源
    @Bean(name = "test1DataSource")
    public DataSource dataSource() {
        MysqlXADataSource xaDataSource = new MysqlXADataSource();
        xaDataSource.setUrl(dataSource1ConfigPropretues.getUrl());
        xaDataSource.setUser(dataSource1ConfigPropretues.getUsername());
        xaDataSource.setPassword(dataSource1ConfigPropretues.getPassword());
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setUniqueResourceName("test1DataSource");
        atomikosDataSourceBean.setXaDataSource(xaDataSource);
        // AtomikosDataSourceBean这个对象需要的XADataSource类型的类，而不是普通的DataSource
        return atomikosDataSourceBean;
    }

    // 配置SqlSessionFactory
    @Bean(name = "test1SqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(DataSource test1DataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(test1DataSource);
        return sqlSessionFactoryBean.getObject();
    }

    // 配置事务管理器 引入全局事务时，就不需要再配置本地事务了。
    /*@Bean(name = "test1DataSourceTransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource test1DataSource) {
        return new DataSourceTransactionManager(test1DataSource);
    }*/

    // 配置template
    @Bean(name = "test1SqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory test1SqlSessionFactory) {
        return new SqlSessionTemplate(test1SqlSessionFactory);
    }
}
