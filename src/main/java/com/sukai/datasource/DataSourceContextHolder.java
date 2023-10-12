package com.sukai.datasource;


import com.mysql.cj.util.StringUtils;
import lombok.extern.java.Log;

/**
 * 数据库选择工具
 *
 * @author: lzx
 */
@Log
public class DataSourceContextHolder {
    //存储对应数据库
    private static final ThreadLocal<String> dataSourceContextHolder = new ThreadLocal<>();

    /**
     * 设置数据源
     *
     * @param dataSource
     */
    public static void setDataSource(String dataSource) {
        log.info("--set-ds---{}" + dataSource);
        dataSourceContextHolder.set(dataSource);
    }

    public static String getDataSource() {
        String dataSource = ((String) dataSourceContextHolder.get());
        if(StringUtils.isNullOrEmpty(dataSource)){
            dataSource = "master";
        }
        log.info("--get-ds---{}" + dataSource);
        return dataSource;
    }

    /**
     * 清除数据源
     */
    public static void clearDataSource() {
        dataSourceContextHolder.remove();
    }
}
