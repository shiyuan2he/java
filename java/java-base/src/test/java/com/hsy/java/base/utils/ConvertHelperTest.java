package com.hsy.java.base.utils;

import java.util.Map;

import com.hsy.java.base.bean.User;
import org.junit.Test;

/**
 * @description <p>对象转换类测试</p>
 * @author heshiyuan @date 2017年3月11日 下午3:10:48
 * @path: javase-common/com.javase.util/ConvertHelperTest.java
 * @price ￥：5元
 * @copyright 如有复制粘贴请通知本人或者捐赠，微信号：hewei1109
 * @email heshiyuan@chtwm.com
 * @callnumber 15910868535
 */
public class ConvertHelperTest {

	@Test
	public void test() {
		User user = new User() ;
		user.setUsername("hehe");
		user.setPassword("123456");
		user.setTestNamePassword("sssss");
		Map<String,Object> map = ConvertHelper.beanToMapByCommonsBeanUtils(user) ;
		System.out.println(map.toString());
	}

}

