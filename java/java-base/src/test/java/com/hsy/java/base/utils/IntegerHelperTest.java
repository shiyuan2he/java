package com.hsy.java.base.utils;

import com.hsy.java.base.number.IntegerHelper;
import org.junit.Test;

/**
 * @description <p>类文件描述</p>
 * @author heshiyuan @date 2017年3月9日 下午3:44:07
 * @path: javase-common/com.javase.util/IntegerHelperTest.java
 * @price ￥：5元
 * @copyright 如有复制粘贴请通知本人或者捐赠，微信号：hewei1109
 * @email heshiyuan@chtwm.com
 * @callnumber 15910868535
 */
public class IntegerHelperTest {

	@Test
	public void test() {
		System.out.println(IntegerHelper.isInteger("44444"));
		System.out.println(IntegerHelper.isInteger("fsfsdf"));
		System.out.println(IntegerHelper.isInteger("33dfs"));
		System.out.println(IntegerHelper.isInteger("4,."));
		System.out.println(IntegerHelper.isInteger("kkk/"));
		/**
		 * 输出结果 :	true,false,false,false,false
		 */
	}

}

