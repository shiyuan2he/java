package com.hsy.java.util.mybatis;
import com.hsy.java.base.string.StringHelper;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * @author heshiyuan
 * @description <p></p>
 * @path paac/com.hsy.paac.util
 * @date 30/08/2017 1:16 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class MybatisGeneratorUtil {
    private static Logger _logger = LoggerFactory.getLogger(MybatisGeneratorUtil.class) ;
    // generatorConfig模板路径
    private static String generatorConfig_vm = "/template/generatorConfig.vm";
    // Service模板路径
    private static String service_vm = "/template/Service.vm";
    // ServiceMock模板路径
    private static String serviceMock_vm = "/template/ServiceMock.vm";
    // ServiceImpl模板路径
    private static String serviceImpl_vm = "/template/ServiceImpl.vm";

    private static String basePath = "" ;
    private static String rpcServicePorject = "" ;
    private static String baseProject = "" ;
    private static String daoProject = "" ;
    private static String generatorConfig_xml = "" ;
    private static List<Map<String, Object>> tables = new ArrayList<>(); //储存将要读取的数据库表

    static{
        //windows
        //generatorConfig_vm = MybatisGeneratorUtil.class.getResource(generatorConfig_vm).getPath().replaceFirst("/", "");
        // 类unix
        generatorConfig_vm = MybatisGeneratorUtil.class.getResource(generatorConfig_vm).getPath();
        service_vm = MybatisGeneratorUtil.class.getResource(service_vm).getPath();
        serviceMock_vm = MybatisGeneratorUtil.class.getResource(serviceMock_vm).getPath();
        serviceImpl_vm = MybatisGeneratorUtil.class.getResource(serviceImpl_vm).getPath();
    }

    /**
     * 根据模板生成generatorConfig.xml文件
     * @param jdbc_driver   驱动路径
     * @param jdbc_url      链接
     * @param jdbc_username 帐号
     * @param jdbc_password 密码
     * @param module        项目模块
     * @param database      数据库
     * @param table_prefix  表前缀
     * @param package_name  包名
     */
    public static void generator(
            String jdbc_driver,
            String jdbc_url,
            String jdbc_username,
            String jdbc_password,
            String module,
            String database,
            String table_prefix,
            String package_name,
            Map<String, String> last_insert_id_tables) throws Exception{

        // 初始化全局变量
        initParam(module) ;

        _logger.info("========== 开始生成generatorConfig.xml文件 ==========");
        _logger.info("generatorConfig.xml存放路径："+generatorConfig_xml);
        //generateMybatisConfigXml(database,table_prefix,jdbc_driver,jdbc_url,jdbc_username,jdbc_password,package_name,last_insert_id_tables) ;
        _logger.info("========== 结束生成generatorConfig.xml文件 ==========");

        _logger.info("========== 开始运行MybatisGenerator，生成mapper接口==========");
        //generateModelAndMapperAndDaoInterface() ;
        _logger.info("========== 结束运行MybatisGenerator ==========");

        _logger.info("========== 开始生成Service ==========");
        generateServiceInterface(module,package_name) ;

        _logger.info("========== 结束生成Service ==========");

        /*System.out.println("========== 开始生成Controller ==========");
        System.out.println("========== 结束生成Controller ==========");*/
    }

    private static void generateServiceInterface(String module, String package_name) throws Exception {/*
        String ctime = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        String servicePath = basePath + module + "/" + module + "-rpc-api" +
                            "/src/main/java/" + package_name.replaceAll("\\.", "/") +
                            "/rpc/api";
        _logger.info("service生成地址"+servicePath);
        String serviceImplPath = basePath + module + "/" + module + "-rpc-service" +
                            "/src/main/java/" + package_name.replaceAll("\\.", "/") +
                            "/rpc/service/impl";
        _logger.info("serviceImpl生成地址"+servicePath);
        //deleteDir(new File(servicePath));
        //deleteDir(new File(serviceImplPath));
        for (int i = 0; i < tables.size(); i++) {
            String model = StringHelper.lineToHump(ObjectUtils.toString(tables.get(i).get("table_name")));
            String service = servicePath + "/" + model + "Service.java";
            String serviceMock = servicePath + "/" + model + "ServiceMock.java";
            String serviceImpl = serviceImplPath + "/" + model + "ServiceImpl.java";
            // 生成service
            File serviceFile = new File(service);
            if (!serviceFile.exists()) {
                generateResource(service_vm,service,package_name,model,ctime);
            }
            // 生成serviceMock
            File serviceMockFile = new File(serviceMock);
            if (!serviceMockFile.exists()) {
                generateResource(serviceMock_vm,serviceMock,package_name,model,ctime);
            }
            // 生成serviceImpl
            File serviceImplFile = new File(serviceImpl);
            if (!serviceImplFile.exists()) {
                VelocityContext context = new VelocityContext();
                context.put("package_name", package_name);
                context.put("model", model);
                context.put("mapper", StringUtil.toLowerCaseFirstOne(model));
                context.put("ctime", ctime);
                VelocityUtil.generate(serviceImpl_vm, serviceImpl, context);
                _logger.info(serviceImpl);
            }
        }*/
    }

    private static void generateResource(String vm,String filePath, String package_name, String model, String ctime) throws Exception {
        /*VelocityContext context = new VelocityContext();
        context.put("package_name", package_name);
        context.put("model", model);
        context.put("ctime", ctime);
        VelocityUtil.generate(vm, filePath, context);
        _logger.info(filePath);*/
    }

    /*private static void generateModelAndMapperAndDaoInterface() throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
        List<String> warnings = new ArrayList<>();
        File configFile = new File(generatorConfig_xml);
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(true);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        for (String warning : warnings) {
            _logger.info(warning);
        }
    }*/

    private static void initParam(String module) {
        // paac-urms/paac-urms-dao
        daoProject = module + "/" + module + "-dao";
        _logger.info("在"+daoProject+"中生成mapper接口文件和xml文件");

        //  /Users/heshiyuan/data/devTools/repo/git/paac/
        basePath = MybatisGeneratorUtil.class.getResource("/").getPath()
                .replace("/target/classes/", "")
                .replace(daoProject, "");
        _logger.info("basePath地址："+basePath);

        // /Users/heshiyuan/data/devTools/repo/git/paac/paac-urms/paac-urms-dao
        daoProject = basePath + daoProject;

        //  /Users/heshiyuan/data/devTools/repo/git/paac/paac-urms/paac-urms-rpc-service
        rpcServicePorject = basePath + module + "/" + module + "-rpc-service";
        _logger.info("在"+rpcServicePorject+"中生成接口文件");

        //  /Users/heshiyuan/data/devTools/repo/git/paac/paac-urms/paac-urms-base
        baseProject = basePath + module + "/" + module + "-base";
        _logger.info("在"+baseProject+"中生成实体文件");

        generatorConfig_xml = MybatisGeneratorUtil.class.getResource("/")
                .getPath()
                .replace("/target/classes/", "") +
                "/src/main/resources/generatorConfig.xml";
        _logger.info("在"+generatorConfig_xml+"生成generatorConfig.xml文件");
    }

    /*private static void generateMybatisConfigXml(String database, String table_prefix, String jdbc_driver,
                                                 String jdbc_url, String jdbc_username, String jdbc_password,
                                                 String package_name,Map<String, String> last_insert_id_tables) {
        try {
            //查询将要生成的表,并将其放到全局变量tables
            selectTables(database,table_prefix,jdbc_driver,jdbc_url,jdbc_username,jdbc_password);
            VelocityContext context = new VelocityContext();

            context.put("tables", tables);
            // 生成实体的位置
            context.put("baseProject", baseProject);
            context.put("daoProject", daoProject);
            context.put("rpcServicePorject", rpcServicePorject);
            context.put("generator_javaModelGenerator_targetPackage", package_name + ".base.model");
            context.put("generator_sqlMapperGenerator_targetPackage", package_name + ".dao.mapper");
            context.put("generator_javaClientGenerator_targetPackage", package_name + ".dao");
            context.put("generator_jdbc_password", AESUtil.AESDecode(jdbc_password));
            context.put("last_insert_id_tables", last_insert_id_tables);
            VelocityUtil.generate(generatorConfig_vm, generatorConfig_xml, context);
            // 删除旧代码
            //deleteDir(new File(baseProject + "/src/main/java/" + package_name.replaceAll("\\.", "/") + "/base/model"));
            //deleteDir(new File(daoProject + "/src/main/java/" + package_name.replaceAll("\\.", "/") + "/dao/mapper"));
            //deleteDir(new File(daoProject + "/src/main/java/" + package_name.replaceAll("\\.", "/") + "/dao"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void selectTables(String database, String table_prefix, String jdbc_driver,
                                               String jdbc_url, String jdbc_username, String jdbc_password) throws SQLException {
        String sql = "SELECT table_name FROM INFORMATION_SCHEMA.TABLES WHERE table_schema = '" +
                    database + "' AND table_name LIKE '" + table_prefix + "_%';";
        _logger.info("sql:"+sql);

        Map<String, Object> table;
        // 查询定制前缀项目的所有表
        JdbcUtil jdbcUtil = new JdbcUtil(jdbc_driver, jdbc_url, jdbc_username, AESUtil.AESDecode(jdbc_password));
        List<Map> result = jdbcUtil.selectByParams(sql, null);
        for (Map map : result) {
            _logger.info(map.get("TABLE_NAME"));
            table = new HashMap<>();
            table.put("table_name", map.get("TABLE_NAME"));
            table.put("model_name", StringUtil.lineToHump(ObjectUtils.toString(map.get("TABLE_NAME"))));
            tables.add(table);
        }
        jdbcUtil.release();
    }*/

    // 递归删除非空文件夹
    public static void deleteDir(File dir) {
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (int i = 0; i < files.length; i++) {
                deleteDir(files[i]);
            }
        }
        dir.delete();
    }
}
