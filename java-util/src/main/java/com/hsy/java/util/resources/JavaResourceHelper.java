package com.hsy.java.util.resources;
import com.hsy.java.base.jar.JarHelper;
import com.hsy.java.base.utils.PropertiesFileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

/**
 * @author heshiyuan
 * @author shiyuan2he
 * @description <p></p>
 * @path paac/com.hsy.paac.util
 * @date 2017/8/31 22:10
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class JavaResourceHelper implements InitializingBean, ServletContextAware {
    private static final Logger _logger = LoggerFactory.getLogger(JavaResourceHelper.class.getName()) ;
    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        _logger.info("===== 开始解压java-resource =====");
        String version = PropertiesFileUtil.getInstance("properties/config").get("java.resource.version");
        _logger.info("java-resource.jar 版本: "+version);
        String jarPath = servletContext.getRealPath("/WEB-INF/lib/java-resource-" + version + ".jar");
        _logger.info("java-resource.jar 包路径: "+jarPath);
        String resources = servletContext.getRealPath("/") + "/resources/java-resource";
        _logger.info("java-resource.jar 解压到: "+resources);
        JarHelper.decompress(jarPath, resources);
        _logger.info("===== 解压java-resource完成 =====");
    }
}
