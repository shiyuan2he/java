package org.hsy.java.jdbc.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author heshiyuan
 * @date 2021/2/23 16:33
 */
public abstract class BaseHelper {
    private DataSource dataSource;

    /**
     * 获取数据源
     * @return
     */
    protected abstract DataSource dataSource();

    public Connection getConnection(){
        if(null == dataSource){
            dataSource = dataSource();
            if(null == dataSource){
                throw new IllegalArgumentException("数据源加载失败");
            }
        }
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("连接池获取连接失败");
    }

    /**
     * 释放连接回连接池
     * @param conn
     * @param stmt
     * @param rs
     */
    public void release(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            stmt = null;
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }
}
