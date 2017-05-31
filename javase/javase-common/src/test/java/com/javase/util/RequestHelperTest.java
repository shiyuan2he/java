package com.javase.util;

import java.util.HashMap;
import java.util.Map;

import com.javase.utils.RequestHelper;
import org.junit.Test;

/**
 * @description <p>类文件描述</p>
 * @author heshiyuan @date 2017年3月9日 下午4:17:24
 * @path: javase-common/com.javase.util/RequestHelperTest.java
 * @price ￥：5元
 * @copyright 如有复制粘贴请通知本人或者捐赠，微信号：hewei1109
 * @email heshiyuan@chtwm.com
 * @callnumber 15910868535
 */
public class RequestHelperTest {

	@Test
	public void test() {
		Map<String,Object> param = new HashMap<>() ;
		param.put("111", "esfs") ;
		param.put("222", 1) ;
		param.put("333", true) ;
		RequestHelper.printRequestParam(param);
	}
}

