/**
 * @author 何世远	shiyuan4work@sina.com
 * @Description 文件注释
 * @date 2015年11月2日 下午9:43:26
 * @version 1.0 create at 2015年11月2日 下午9:43:26 by 何世远
 */
package com.javase.exception;

/**
 * @author 何世远	shiyuan4work@sina.com
 * @Description 请输入类描述信息
 * @date 2015年11月2日 下午9:43:26
 */
public class ExceptionTest {
	//private static LoggerEx logger = LoggerEx.getInstance(ExceptionTest.class.getName()) ;
	/**
	 * @author 何世远	shiyuan4work@sina.com
	 * @Description 请输入此方法描述信息
	 * @date 2015年11月2日 下午9:37:44
	 */
	public static void main(String[] args){
		//testArithmeticException() ; // 测试ArithmeticException
		run() ;
		
	}
	public static void run(){
		try {
			testException01()  ;
		} catch (Exception e) {
			/*logger.error("e.getMessage()==" + e.getMessage());
			logger.error("--------------");
			logger.error("e.getMessage()==" + e.getMessage());
			logger.error("--------------");
			logger.error("e.getLocalizedMessage():==" + e.getLocalizedMessage());
			logger.error("--------------");
			logger.error("e:==" + e);
			logger.error("--------------");
			logger.error("e.printStackTrace():==");
			logger.error("--------------");
			e.printStackTrace(System.out) ;
			logger.error("--------------");
			for (StackTraceElement ste : e.getStackTrace()) {
				logger.info(ste.getClassName() + "	" + ste.getLineNumber() + "		" +ste.getMethodName()) ;
			}*/
			return ;
		}
	}
	/**
	 * 
	 * @author 何世远	shiyuan4work@sina.com
	 * @Description 模拟抛出异常的方法
	 * @date 2015年11月4日 下午10:35:21
	 */
	private static void testException01() throws MyException {
		throw new MyException("testException01 抛出的异常") ;
	}
	/**
	 * 
	 * @author 何世远	shiyuan4work@sina.com
	 * @Description 测试ArithmeticException
	 * @date 2015年11月4日 下午9:45:33
	 */
	@SuppressWarnings("unused")
	private static void testArithmeticException(){
		try {
			int a = 10 ,b = 0 ;
			int c = a / b ;
			//logger.info(c);
		} catch (ArithmeticException e) {
			//e.printStackTrace();// 默认打印到错误输出流
			e.printStackTrace(System.out);
			try {
				//throw new com.hsy.codebase.utils.javase.exception.MyException("除数不能为0") ;
			} catch (Exception e1) {
				//e1.printStackTrace();
			}
		}
	}
}
