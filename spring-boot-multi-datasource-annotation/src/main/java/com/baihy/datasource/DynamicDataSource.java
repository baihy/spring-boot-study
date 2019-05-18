package com.baihy.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @projectName: springboot
 * @packageName: com.baihy.datasource
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-18 18:59
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private static final Logger LOGGER = LoggerFactory.getLogger(DynamicDataSource.class);

    @Override
    protected Object determineCurrentLookupKey() {
        LOGGER.info("当前的数据源是：{}", DataSourceContextHolder.getDataSoruce());
        return DataSourceContextHolder.getDataSoruce();
    }
}
