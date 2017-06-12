/**
 * @author 何世远	shiyuan4work@sina.com
 * @Description 文件注释
 * @date 2015年11月2日 下午9:37:44
 * @version 1.0 create at 2015年11月2日 下午9:37:44 by 何世远
 */
package com.javase.exception;


/**
 * @author 何世远	shiyuan4work@sina.com
 * @Description 请输入类描述信息
 * @date 2015年11月2日 下午9:37:44
 */
public class MyException extends Exception{
	/**
	 * @Description 请输入属性描述信息
	 * @author 何世远	shiyuan4work@sina.com
	 * @date 2015年11月15日 下午10:27:45
	 */
	private static final long serialVersionUID = -573384093260328717L;
	private int ID ;
	public MyException(){}
	
	public MyException(String msg){	super(msg);}
	
	public MyException(String msg,int id){	
		super(msg);
		this.ID = id ;
	}
	public int val(){
		return this.ID ;
	}
	public String getMsg(){
		return "异常详情：" + ID + super.getMessage() ;
	}
}
