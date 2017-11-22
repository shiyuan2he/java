package com.hsy.java.java.base.utils;

import org.junit.Test;

/**
 * @description <p>日期帮助工具类测试类</p>
 * @author heshiyuan @date 2017年3月9日 下午7:19:37
 * @path: javase-common/com.javase.util/DateHelperTest.java
 * @price ￥：5元
 * @copyright 如有复制粘贴请通知本人或者捐赠，微信号：hewei1109
 * @email heshiyuan@chtwm.com
 * @callnumber 15910868535
 */
public class DateHelperTest {

	@Test
	public void test() {
		//System.out.println(DateHelper.getStrFromDateOfFormate(new Date(), "yyyy-MM-dd"));
		System.out.println(DateHelper.getDateFromStrOfFormate("2017-08-26", "yyyy-MM-dd")) ;
	}
}

