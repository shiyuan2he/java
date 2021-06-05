package org.hsy.java.util.jdbc.config;

import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.ConfigFactory;
import org.aeonbits.owner.Reloadable;

import java.util.Map;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/org.hsy.java.util.jdbc.config
 * @date 2017/11/21 18:13
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Sources({"classpath:properties/config.properties"})
public interface MariadbJdbcConfig extends Reloadable{
    MariadbJdbcConfig instance = ServerConfigInner.config ;
    @Key("mariadb.config.driverClass")
    String driverClass() ;
    @Key("mariadb.config.url")
    String url() ;
    @Key("mariadb.config.username")
    String username() ;
    @Key("mariadb.config.password")
    String password()  ;
    @Key("mariadb.config.env")
    String env()  ;
    @Key("mariadb.config.appId")
    String appId()  ;
    @Key("mariadb.config.override")
    String override();

    final class ServerConfigInner {
        public static final MariadbJdbcConfig config = (MariadbJdbcConfig) ConfigFactory.create(MariadbJdbcConfig.class, new Map[0]);
        public ServerConfigInner() {}
    }
}
