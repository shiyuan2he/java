package org.hsy.java.jdbc.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author heshiyuan
 */
public class C3p0Helper extends BaseHelper{
    private static DataSource dataSource = new ComboPooledDataSource("mariadb");
    private static C3p0Helper c3p0Helper = new C3p0Helper();

    /**
     * 获取实例
     * @return
     */
    public static C3p0Helper getInstance(){
        return c3p0Helper;
    }

    @Override
    protected DataSource dataSource() {
        return dataSource;
    }
}
