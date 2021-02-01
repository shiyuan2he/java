package com.hsy.java.util.temp;

import org.apache.commons.io.output.FileWriterWithEncoding;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.File;
import java.util.Properties;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path paac/com.hsy.paac.util
 * @date 30/08/2017 1:20 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class VelocityUtil {
    /**
     * 根据模板生成文件
     * @param inputVmFilePath 模板路径
     * @param outputFilePath 输出文件路径
     * @param context
     * @throws Exception
     */
    public static void generate(String inputVmFilePath, String outputFilePath, VelocityContext context) throws Exception {
        try {
           /* Properties properties = new Properties();
            properties.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH, getPath(inputVmFilePath));
            Velocity.init(properties);
            VelocityEngine engine = new VelocityEngine();
            engine.init();
            Template template = Velocity.getTemplate(getFile(inputVmFilePath), "utf-8");*/
            VelocityEngine ve = new VelocityEngine();
            Properties properties = new Properties();
            properties.setProperty(ve.FILE_RESOURCE_LOADER_PATH, getPath(inputVmFilePath));
            ve.init(properties);   //初始化
            Template template = ve.getTemplate(getFile(inputVmFilePath), "utf-8");//此处只要指明文件名就可以了.
            File outputFile = new File(outputFilePath);
            FileWriterWithEncoding writer = new FileWriterWithEncoding(outputFile, "utf-8");
            template.merge(context, writer);
            writer.close();
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * 根据文件绝对路径获取目录
     * @param filePath
     * @return
     */
    public static String getPath(String filePath) {
        String path = "";
        if (StringUtils.isNotBlank(filePath)) {
            path = filePath.substring(0, filePath.lastIndexOf("/") + 1);
        }
        return path;
    }

    /**
     * 根据文件绝对路径获取文件
     * @param filePath
     * @return
     */
    public static String getFile(String filePath) {
        String file = "";
        if (StringUtils.isNotBlank(filePath)) {
            file = filePath.substring(filePath.lastIndexOf("/") + 1);
        }
        return file;
    }
}
