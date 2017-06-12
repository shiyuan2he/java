/**
 * @author 何世远	shiyuan4work@sina.com
 * @Description 数组初始化单元测试
 * @date 2015年12月13日 下午2:03:27
 * @version 1.0 create at 2015年12月13日 下午2:03:27 by 何世远
 */
package com.javase.array;


import com.hsy.codebase.utils.javase.logger.LoggerEx;
import com.javase.array.ArrayInit;
import org.junit.*;

/**
 * @author 何世远	shiyuan4work@sina.com
 * @Description 请输入类描述信息
 * @date 2015年12月13日 下午2:03:27
 */
public class ArrayInitTest {
	private static LoggerEx logger = LoggerEx.getInstance(ArrayInit.class.getName()) ;
	
	ArrayInit arrayInit = new ArrayInit() ;
	/**
	 * @author 何世远	shiyuan4work@sina.com
	 * @Description 单元测试类加载前调用此方法
	 * @date 2015年12月13日 下午2:03:27
	 */
	@BeforeClass
	public static void setUpBeforeClass() {
		logger.info("单元测试类加载前调用此方法");
	}

	/**
	 * @author 何世远	shiyuan4work@sina.com
	 * @Description 单元测试类加载后调用此方法
	 * @date 2015年12月13日 下午2:03:27
	 */
	@AfterClass
	public static void tearDownAfterClass() {
		logger.info("单元测试类加载后调用此方法");
	}

	/**
	 * @author 何世远	shiyuan4work@sina.com
	 * @Description 单元测试方法执行前调用此方法
	 * @date 2015年12月13日 下午2:03:27
	 */
	@Before
	public void setUp(){
		logger.info("单元测试方法执行前调用此方法");
	}

	/**
	 * @author 何世远	shiyuan4work@sina.com
	 * @Description 单元测试方法执行后调用此方法
	 * @date 2015年12月13日 下午2:03:27
	 */
	@After
	public void tearDown(){
		logger.info("单元测试方法执行后调用此方法");
	}

	/**
	 * Test method for {@link com.hsy.codebase.utils.javase.array.ArrayInit#init()}.
	 */
	@Test
	public void testInit() {
		Assert.assertNotNull(arrayInit);
		arrayInit.init();
	}

}
