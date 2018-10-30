package com.hsy.java.util.jdbc;

import com.hsy.java.base.string.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * @author heshiyuan
 * @description <p>实体生成工具类</p>
 * @path java/com.hsy.java.util.jdbc
 * @date 16/10/2017 10:37 AM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class EntityGenerator {
    private static Logger _logger = LoggerFactory.getLogger(EntityGenerator.class) ;
    private static String packageName ;
    private static String tablename;//表名
    private static String[] colnames; // 列名数组
    private static String[] colTypes; //列名类型数组
    private static int[] colSizes; //列名大小数组
    private static boolean f_util = false; // 是否需要导入包java.util.*
    private static boolean f_sql = false; // 是否需要导入包java.sql.*

    //数据库连接
    private static String URL = null;
    private static String NAME = null;
    private static String PASS = null;
    private static String DRIVER = null;


    public EntityGenerator(String packageName,String tablename,String dburl,String dbname,String dbpass,String dbdriver){
        this.packageName = packageName ;
        this.tablename = tablename ;
        this.URL = dburl ;
        this.NAME = dbname ;
        this.PASS = dbpass ;
        this.DRIVER = dbdriver ;
        generator() ;
    }
    public static void generator(){
        //创建连接
        Connection con;
        //查要生成实体类的表
        String sql = "select * from " + tablename;
        _logger.info("【实体生成器】{}",sql);
        PreparedStatement pStemt = null;
        try {
            try {
                Class.forName(DRIVER);
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
            con = DriverManager.getConnection(URL,NAME,PASS);
            pStemt = con.prepareStatement(sql);
            ResultSetMetaData rsmd = pStemt.getMetaData();
            int size = rsmd.getColumnCount();   //统计列
            colnames = new String[size];
            colTypes = new String[size];
            colSizes = new int[size];
            for (int i = 0; i < size; i++) {
                colnames[i] = rsmd.getColumnName(i + 1);
                colTypes[i] = rsmd.getColumnTypeName(i + 1);

                if(colTypes[i].equalsIgnoreCase("datetime")
                        || colTypes[i].equalsIgnoreCase("timestamp")){
                    f_util = true;
                }
                if(colTypes[i].equalsIgnoreCase("image")
                        || colTypes[i].equalsIgnoreCase("text")){
                    f_sql = true;
                }
                colSizes[i] = rsmd.getColumnDisplaySize(i + 1);
            }
            String content = parse(colnames,colTypes,colSizes);

            try {
                String path = EntityGenerator.class.getResource("").getPath();
                path = path.replaceAll("target/classes","src/main/java");
                String outputPath = path + "entity/" + StringHelper.lineToHump(tablename) + ".java";
                _logger.info("【实体生成器】实体生成地址：{}",outputPath);
                FileWriter fw = new FileWriter(outputPath);
                PrintWriter pw = new PrintWriter(fw);
                pw.println(content);
                pw.flush();
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 功能：生成实体类主体代码
     * @param colnames
     * @param colTypes
     * @param colSizes
     * @return
     */
    private static String parse(String[] colnames, String[] colTypes, int[] colSizes) {
        StringBuffer sb = new StringBuffer();
        //生成包路径
        sb.append("package " + packageName + ";\r\n");
        sb.append("\r\n");
        //判断是否导入工具包
        if(f_util){
            sb.append("import java.util.Date;\r\n");
        }
        if(f_sql){
            sb.append("import java.sql.*;\r\n");
        }
        //注释部分
        //sb.append("   /**\r\n");
        //sb.append("    * "+tablename+" 实体类\r\n");
        //sb.append("    * "+new Date()+" "+this.authorName+"\r\n");
        //sb.append("    */ \r\n");
        //实体部分
        sb.append("\r\n\r\npublic class " + StringHelper.lineToHump(tablename) + "{\r\n");
        processAllAttrs(sb);//属性
        processAllMethod(sb);//get set方法
        sb.append("}\r\n");

        //System.out.println(sb.toString());
        return sb.toString();
    }

    /**
     * 功能：生成所有属性
     * @param sb
     */
    private static void processAllAttrs(StringBuffer sb) {
        for (int i = 0; i < colnames.length; i++) {
            sb.append("\tprivate " + sqlType2JavaType(colTypes[i]) + " " + StringHelper.toLowerCaseFirstOne(StringHelper.lineToHump(colnames[i])) + ";\r\n");
        }

    }

    /**
     * 功能：生成所有方法
     * @param sb
     */
    private static void processAllMethod(StringBuffer sb) {
        for (int i = 0; i < colnames.length; i++) {
            sb.append("\tpublic void set" + StringHelper.lineToHump(colnames[i]) + "(" + sqlType2JavaType(colTypes[i]) + " " + StringHelper.toLowerCaseFirstOne(StringHelper.lineToHump(colnames[i])) + "){\r\n");
            sb.append("\t\tthis." + StringHelper.toLowerCaseFirstOne(StringHelper.lineToHump(colnames[i])) + "=" + StringHelper.toLowerCaseFirstOne(StringHelper.lineToHump(colnames[i])) + ";\r\n");
            sb.append("\t}\r\n");
            sb.append("\tpublic " + sqlType2JavaType(colTypes[i]) + " get" + StringHelper.lineToHump(colnames[i]) + "(){\r\n");
            sb.append("\t\treturn " + StringHelper.toLowerCaseFirstOne(StringHelper.lineToHump(colnames[i])) + ";\r\n");
            sb.append("\t}\r\n");
        }
    }
    /**
     * 功能：获得列的数据类型
     * @param sqlType
     * @return
     */
    private static String sqlType2JavaType(String sqlType) {
        _logger.info("字段类型{}",sqlType);
        if(sqlType.equalsIgnoreCase("bit")){
            return "Boolean";
        }else if(sqlType.equalsIgnoreCase("tinyint")){
            return "Byte";
        }else if(sqlType.equalsIgnoreCase("smallint")){
            return "Short";
        }else if(sqlType.equalsIgnoreCase("int")
                || sqlType.equalsIgnoreCase("integer")){
            return "Integer";
        }else if(sqlType.equalsIgnoreCase("bigint")){
            return "Long";
        }else if(sqlType.equalsIgnoreCase("float")){
            return "Float";
        }else if(sqlType.equalsIgnoreCase("decimal")
                || sqlType.equalsIgnoreCase("numeric")
                || sqlType.equalsIgnoreCase("real")
                || sqlType.equalsIgnoreCase("money")
                || sqlType.equalsIgnoreCase("smallmoney")){
            return "Double";
        }else if(sqlType.equalsIgnoreCase("varchar")
                || sqlType.equalsIgnoreCase("char")
                || sqlType.equalsIgnoreCase("nvarchar")
                || sqlType.equalsIgnoreCase("nchar")
                || sqlType.equalsIgnoreCase("text")){
            return "String";
        }else if(sqlType.equalsIgnoreCase("datetime")
                || sqlType.equalsIgnoreCase("timestamp")){
            return "Date";
        }else if(sqlType.equalsIgnoreCase("image")){
            return "Blod";
        }
        return "Object";
    }
    private static final String packageNames = "com.hsy.java.util.jdbc.entity" ;
    /*private static final String[] tableName =
            {
                    "t_activity_apply",
                    "t_user_operation_record",
                    "t_activity_publish",
                    "t_banner_manager",
                    "t_content_detail",
                    "t_content_manager",
                    "t_project_financing",
                    "t_project_invest",
                    "t_qj_certification",
                    "t_successful_case",
                    "t_sys_group_type",
                    "t_sys_params",
                    "t_user_intention_application"
            } ;*/
    private static final String[] tableName =
            {
                  "app_front"
            } ;
    //private static final String driver = "org.mariadb.jdbc.Driver" ;
    //private static final String url = "jdbc:mariadb://192.168.6.101:3306/qyjr?useUnicode=true&characterEncoding=UTF-8" ;
    private static final String driver = "com.mysql.jdbc.Driver" ;
    private static final String url = "jdbc:mysql://192.168.1.183:3306/project_y?useUnicode=true&autoReconnect=true&allowMultiQueries=true&zeroDateTimeBehavior=convertToNull" ;
    private static final String username = "projecty" ;
    private static final String password = "projecty" ;
    public static void main(String[] args){
        for (int i = 0; i < tableName.length; i++) {
            new EntityGenerator(packageNames,tableName[i], url,
                    username,password,driver) ;
        }
    }
}

