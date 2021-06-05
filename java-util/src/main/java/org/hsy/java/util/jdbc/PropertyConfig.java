package org.hsy.java.util.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.io.IOException;
import java.util.*;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/org.hsy.java.util.jdbc
 * @date 2017/11/22 09:16
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class PropertyConfig extends PropertyPlaceholderConfigurer {
    private List<IJdbcConfigInterface> configList;
    private boolean loadPlugin;
    private Logger logger = LoggerFactory.getLogger(PropertyConfig.class);

    public PropertyConfig() {}

    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
    }

    protected void loadProperties(Properties props) throws IOException {
        super.loadProperties(props);
        if(this.configList != null && this.configList.size() > 0) {
            int size = this.configList.size();
            IJdbcConfigInterface configRead = null;

            for(int i = 0; i < size; ++i) {
                configRead = this.configList.get(i);
                if(configRead != null) {
                    configRead.loadConfig(props);
                }
            }
        }

        Set<Map.Entry<Object, Object>> entrySet = props.entrySet();
        Iterator<Map.Entry<Object, Object>> iterator = entrySet.iterator();
        this.logger.info("====================开始输出配置====================");

        while(iterator.hasNext()) {
            Map.Entry<Object, Object> entry = (Map.Entry)iterator.next();
            this.logger.info("{}={}", entry.getKey(), entry.getValue());
        }

        this.logger.info("====================结束输出配置====================");
    }

    public List<IJdbcConfigInterface> getConfigList() {
        return this.configList;
    }

    public void setConfigList(List<IJdbcConfigInterface> configList) {
        this.configList = configList;
    }

    public boolean isLoadPlugin() {
        return this.loadPlugin;
    }

    public void setLoadPlugin(boolean loadPlugin) {
        this.loadPlugin = loadPlugin;
    }
}
