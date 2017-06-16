/**
 * @author 何世远	shiyuan4work@sina.com
 * @Description 文件注释
 * @date 2015年11月14日 下午4:05:38
 * @version 1.0 create at 2015年11月14日 下午4:05:38 by 何世远
 */
package com.javase.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author 何世远	shiyuan4work@sina.com
 * @Description 请输入类描述信息
 * @date 2015年11月14日 下午4:05:38
 */
public class RegexTools {
	//private static LoggerEx logger = LoggerEx.getInstance(RegexTools.class.getName()) ;
	/**
	 * @author 何世远	shiyuan4work@sina.com
	 * @Description 请输入此方法描述信息
	 * @date 2015年11月14日 下午4:05:38
	 */
	public static void main(String[] args) {
		//new RegexTools().finding() ;
		new RegexTools().examine("666hello world!888","\\w+") ;
	}
	
	@SuppressWarnings("unused")
	private void finding(){
		Matcher matcher = Pattern.compile("\\w+").matcher("666hello world!888") ;
		while (matcher.find()) {
			//logger.info(matcher.group());	
			// 功能通上面注释部分
			for (int i = 0; i <=matcher.groupCount(); i++) {
				//logger.info(matcher.group(i));
			}
		}
	}
	private void examine(String message,String regex){
		Display	d = new Display(regex) ;
		d.display(message);
		Pattern pp = Pattern.compile(regex) ;
		Matcher m = pp.matcher(message) ;
		while (m.find()) {
			//logger.info(matcher.group());	
			//logger.info(m.group() + "；起始位置：" + m.start() + ";结束位置：" + m.end());
			/*if(m.lookingAt()){
				logger.info(m.group() + "；起始位置：" + m.start() + ";结束位置：" + m.end());
			}*/
			if(m.matches()){
				//logger.info(m.group() + "；起始位置：" + m.start() + ";结束位置：" + m.end());
			}
		}
	
	}
	private static class Display{
		//private static LoggerEx logger = LoggerEx.getInstance(Display.class.getName()) ;
		private boolean regexPrinted = false ;
		private String regex ;
		Display(String regex){this.regex = regex ;}
		void display(String message){
			//logger.info("要匹配的字符串：" + message);
			if(!regexPrinted){
				//logger.info("匹配的正则表达式：" +regex);
				regexPrinted = true ;
			}
		}
	}
	

}
