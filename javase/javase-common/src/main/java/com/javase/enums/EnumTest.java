/**
 * @author 何世远	shiyuan4work@sina.com
 * @Description 文件注释
 * @date 2015年10月27日 下午9:28:57
 * @version 1.0 create at 2015年10月27日 下午9:28:57 by 何世远
 */
package com.javase.enums;



/**
 * @author 何世远	shiyuan4work@sina.com
 * @Description 季节枚举类
 * @date 2015年10月27日 下午9:28:57
 */
public class EnumTest {
	//private static LoggerEx logger = LoggerEx.getInstance(EnumTest.class.getName()) ;
	/**
	 * @author 何世远	shiyuan4work@sina.com
	 * @Description 枚举类测试车主方法
	 * @date 2015年10月27日 下午9:28:57
	 */
	public static void main(String[] args) {
		//遍历枚举类Season
		EnumTest.ergodicSeason();
		EnumTest.describeSeason(Season.SPRING) ;
		EnumTest.describeSeason(Season.SUMMER) ;
		EnumTest.describeSeason(Season.AUTUMN) ;
		EnumTest.describeSeason(Season.WINTER) ;
	}
	/**
	 * @author 何世远	shiyuan4work@sina.com
	 * @Description 请输入此方法描述信息
	 * @date 2015年10月27日 下午9:38:30
	 */
	private static void ergodicSeason(){
		for (Season	seanson : Season.values()) {
			//logger.info("枚举类Season的第" + seanson.ordinal() + "个元素是" + seanson);
		}
	}
	private static void describeSeason(Season season){
		switch (season) {
		case SPRING:
			//logger.info("万物复苏，春回大地，又到了繁衍的季节！");
			break;
		case SUMMER:
			//logger.info("烈阳高照，热气腾飞，万物回归了平静！！");
			break;
		case AUTUMN:
			//logger.info("丰收时节，秋风落叶，风吹黄了一切！");
			break;
		case WINTER:
			//logger.info("千里冰封，银装素裹，来年还是繁殖季！");
			break;
		default:
			//logger.info("。。。。！");
			break;
		}
	}
	enum Season{
		SPRING,SUMMER,AUTUMN,WINTER
	}

}
