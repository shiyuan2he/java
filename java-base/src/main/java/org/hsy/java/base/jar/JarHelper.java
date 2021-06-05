package org.hsy.java.base.jar;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @author heshiyuan
 * @description <p>jar工具类</p>
 * @path paac/com.hsy.paac.util
 * @date 2017/8/31 22:11
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class JarHelper {
    private static final Logger _logger = LoggerFactory.getLogger(JarHelper.class) ;
    /**
     * 解压jar文件到指定目录
     * @param fileName
     * @param outputPath
     */
    public static synchronized void decompress(String fileName, String outputPath) {
        // 保证输出路径为目录
        if (!outputPath.endsWith(File.separator)) {
            outputPath += File.separator;
        }
        // 如果不存在输出目录，则创建
        File dir = new File(outputPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        // 解压到输出目录
        JarFile jf = null;
        try {
            jf = new JarFile(fileName);
            for (Enumeration<JarEntry> e = jf.entries(); e.hasMoreElements(); ) {
                JarEntry je = e.nextElement();
                String outFileName = outputPath + je.getName();
                File f = new File(outFileName);
                if (je.isDirectory()) {
                    if (!f.exists()) {
                        f.mkdirs();
                    }
                } else {
                    File pf = f.getParentFile();
                    if (!pf.exists()) {
                        pf.mkdirs();
                    }
                    InputStream in = jf.getInputStream(je);
                    OutputStream out = new BufferedOutputStream(
                            new FileOutputStream(f));
                    byte[] buffer = new byte[2048];
                    int nBytes;
                    while ((nBytes = in.read(buffer)) > 0) {
                        out.write(buffer, 0, nBytes);
                    }
                    out.flush();
                    out.close();
                    in.close();
                }
            }
        } catch (Exception e) {
            _logger.info("解压" + fileName + "出错！" + e.getMessage());
        } finally {
            if (jf != null) {
                try {
                    jf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
