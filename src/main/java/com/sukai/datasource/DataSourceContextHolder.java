package com.sukai.datasource;


import com.mysql.cj.util.StringUtils;
import lombok.extern.java.Log;

/**
 * 数据库切换工具
 * @author chengsukai
 */
@Log
public class DataSourceContextHolder {
    //存储对应数据库
    private static final ThreadLocal<String> DATA_SOURCE_CONTEXT_HOLDER = new ThreadLocal<>();

    /**
     * 设置数据源
     *
     * @param dataSource 数据源
     */
    public static void setDataSource(String dataSource) {
        log.info("--set-ds---{}" + dataSource);
        DATA_SOURCE_CONTEXT_HOLDER.set(dataSource);
    }

    public static String getDataSource() {
        String dataSource = DATA_SOURCE_CONTEXT_HOLDER.get();
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
        DATA_SOURCE_CONTEXT_HOLDER.remove();
    }
}
