package org.hsy.java.util.jdbc;

import org.hsy.java.bean.po.TConfigInfo;
import org.hsy.java.util.jdbc.config.MariadbJdbcConfig;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/org.hsy.java.util.jdbc
 * @date 2017/11/21 18:07
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class JdbcConfigHelper implements IJdbcConfigInterface {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private String env;
    private String appId;
    private boolean override;
    private Set<String> excludeKeys;

    public JdbcConfigHelper() {
        this.env = MariadbJdbcConfig.instance.env();
        this.appId = MariadbJdbcConfig.instance.appId();
        this.override = true;
    }

    @Override
    public void loadConfig(Properties properties) {
        if(StringUtils.isNotBlank(this.env) && StringUtils.isNotBlank(this.appId)){
            Connection connection = null ;
            QueryRunner queryRunner = new QueryRunner() ;
            try {
                connection = getConnection(MariadbJdbcConfig.instance.driverClass(),MariadbJdbcConfig.instance.url(),
                        MariadbJdbcConfig.instance.username(),MariadbJdbcConfig.instance.password()) ;
                List<TConfigInfo> configInfoList = (List)queryRunner.query(connection, getSql(),
                        new BeanListHandler(TConfigInfo.class), new Object[]{this.appId, this.env});
                if(null!=configInfoList&&configInfoList.size()>0){
                    configInfoList.forEach(info -> {
                        if(info != null) {
                            String field = info.getField();
                            String value = info.getValue();
                            if(StringUtils.isNotBlank(field) && StringUtils.isNotBlank(value)
                                    && (this.excludeKeys == null || this.excludeKeys.isEmpty() || !this.excludeKeys.contains(field))) {
                                Object object = properties.get(field);
                                if(this.isOverride()) {
                                    if(object != null) {
                                        this.logger.warn("当前的配置中已经有key为{}的属性，数据库中值:{}将覆盖此值", field,value);
                                    }
                                    properties.put(field, value);
                                }
                            }
                        }
                    });
                }
            } catch (SQLException e) {
                throw new RuntimeException(e) ;
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e) ;
            } finally {
                if(connection != null) {
                    try {
                        DbUtils.close(connection);
                    } catch (SQLException var18) {
                        this.logger.error("连接关闭异常:{},{}", var18.getMessage(), var18);
                    }
                }
            }
        }else{
            throw new IllegalArgumentException("env和name必须初始化...");
        }
    }

    private String getSql() {
        StringBuilder sql = new StringBuilder();
        sql.append("select info.app_id,info.field,info.value from t_config_info info where 1 = 1 and info.app_id = ? and info.env = ?");
        return sql.toString() ;
    }

    public static Connection getConnection(String driverClass, String url, String username, String password)throws SQLException,ClassNotFoundException{
        Class.forName(driverClass);
        return DriverManager.getConnection(url,username,password);
    }

    public boolean isOverride(){
        return StringUtils.isBlank(MariadbJdbcConfig.instance.override())?this.override:Boolean.valueOf(MariadbJdbcConfig.instance.override()).booleanValue();
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public void setOverride(boolean override) {
        this.override = override;
    }

    public Set<String> getExcludeKeys() {
        return excludeKeys;
    }

    public void setExcludeKeys(Set<String> excludeKeys) {
        this.excludeKeys = excludeKeys;
    }

}
