package com.hsy.java.util.plugins;
import com.hsy.java.util.secure.AESHelper;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * @description <p>支持加密配置文件插件</p>
 * @param
 * @return No such property: code for class: Script1
 * @author heshiyuan
 * @date 07/09/2017 4:33 PM
 * @email shiyuan4work@sina.com
 * @github https://github.com/shiyuan2he.git
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

	private String[] propertyNames = {
		"master.jdbc.password", "slave.jdbc.password", "generator.jdbc.password", "master.redis.password"
	};

	/**
	 * 解密指定propertyName的加密属性值
	 * @param propertyName
	 * @param propertyValue
	 * @return
	 */
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		for (String p : propertyNames) {
			if (p.equalsIgnoreCase(propertyName)) {
//				return AESHelper.decode(propertyValue);
                return null;
			}
		}
		return super.convertProperty(propertyName, propertyValue);
	}

}
