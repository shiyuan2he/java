package org.hsy.java.util.jdbc;

import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author heshiyuan
 * @description <p>读取properties文件到数据库</p>
 * @path java/org.hsy.java.util.jdbc
 * @date 2017/11/25 13:39
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class ReadPropertiesFileToDB {
    private String driverClass ;
    private String url ;
    private String username ;
    private String password ;
    private Connection connection ;
    public ReadPropertiesFileToDB(String driverClass,String url,String username,String password){
        this.driverClass = driverClass ;
        this.url = url ;
        this.username = username;
        this.password = password;
        try {
            connection = JdbcConfigHelper.getConnection(driverClass,url,username,password) ;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void execute(String env,String appId,String field,String value,String description){
        QueryRunner queryRunner = new QueryRunner() ;
        StringBuilder sql = new StringBuilder();
        sql.append("insert into t_config_info(env,app_id,field,value,description)")
                .append(" VALUES")
                .append(" (")
                    .append(",").append(env)
                    .append(",").append(appId)
                    .append(",").append(field)
                    .append(",").append(value)
                    .append(",").append(description)
                .append(")");
        try {
            queryRunner.update(connection,sql.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void close(){
        if(null != connection){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
