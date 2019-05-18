package com.baihy.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @projectName: springboot
 * @packageName: com.baihy.datasource
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-18 19:00
 */

public class DataSourceContextHolder {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceContextHolder.class);

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    /**
     * 设置数据源
     *
     * @param DataSourceName
     */
    public static void setDataSource(String DataSourceName) {
        LOGGER.info("切换到{}数据源", DataSourceName);
        contextHolder.set(DataSourceName);
    }

    /**
     * 获取数据源名称
     *
     * @return
     */
    public static String getDataSoruce() {
        return (contextHolder.get());
    }

    /**
     * 清除数据源
     */
    public static void clearDataSource() {
        contextHolder.remove();
    }
}
