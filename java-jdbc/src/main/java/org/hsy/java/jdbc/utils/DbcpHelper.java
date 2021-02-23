package org.hsy.java.jdbc.utils;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author heshiyuan
 */
public class DbcpHelper extends BaseHelper{
    private static DbcpHelper dbcpHelper = new DbcpHelper();
    private static DataSource dataSource = null;
    static {
        Properties prop = new Properties();
        InputStream inputStream = DbcpHelper.class.getResourceAsStream("/dbcp.properties");
        if (null == inputStream) {
            throw new RuntimeException("未找到数据库配置文件，dbcp.properties");
        }
        try {
            prop.load(inputStream);
            dataSource = BasicDataSourceFactory.createDataSource(prop);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected DataSource dataSource() {
        return dataSource;
    }

    public static DbcpHelper getInstance(){
        return dbcpHelper;
    }
}
