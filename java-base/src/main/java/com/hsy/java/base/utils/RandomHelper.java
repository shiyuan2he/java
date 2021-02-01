package com.hsy.java.base.utils;

import com.hsy.java.base.number.MathHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * 
 * @description 
 *		<p>随机数工具类</p>
 * @time 2016年7月6日 下午10:25:40
 * @github 
 * 		http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * @returnType long
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class RandomHelper {
    private final static Logger _logger = LoggerFactory.getLogger(MathHelper.class);
	/**
	 * 
	 * @description 
	 *		<p>当前毫秒数</p>
	 * @time 2016年7月6日 下午10:25:40
	 * @github 
	 * 		http://github.com/shiyuan2he
	 * @author shiyuan2he
	 * @email shiyuan4work@sina.com
	 * @returnType long
	 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
	 */
	public static long curTimeGenerator(){
		return System.currentTimeMillis();
	}
	/**
	 * 
	 * @description 
	 *		<p>生成24位全球唯一标识ID主键-PAAC14776347668456433687</p>
	 * @time 2016年7月6日 下午10:35:19
	 * @github 
	 * 		http://github.com/shiyuan2he
	 * @author shiyuan2he
	 * @email shiyuan4work@sina.com
	 * @returnType String
	 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
	 */
	synchronized public static String IDGenerateValue(final long lastTimestamp){
		final StringBuffer idValue = new StringBuffer() ;
		long timestamp  = curTimeGenerator();
		while (timestamp <= lastTimestamp) {
			 timestamp = curTimeGenerator();
		}
		idValue.append(timestamp).append(Math.round(Math.random()*10000000)) ;
		return idValue.toString();
	}
	/**
	 * 
	 * @description <p>返回以start开头，以end结尾，中间length个数字的字符串</p>
	 * @param start
	 * @param end
	 * @param length
	 * @return
	 * @returnType String
	 * 方法名:generateValueByParam
	 * 类名:RandomHelper
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年11月3日 下午2:20:15
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	synchronized public static String generateValueByParam(String start,String end,int length){
		if(length < 0) return "" ;
		StringBuffer stringCount = new StringBuffer() ;
		stringCount.append("1") ;
		for(int i=0;i<length;i++){
			stringCount.append("0");
		}
		StringBuffer sb = new StringBuffer() ;
		sb.append(start).append(Math.round(Math.random()*Integer.parseInt(stringCount.toString()))).append(end) ;
		return sb.toString() ;
	}
    /**
     *
     * @description <p>Random生成：根据传入的位数生成相应位数的随机数</p>
     * @returnType 生成的随机苏
     * 方法名:
     * 类名:MathUtils
     * @author heshiyuan
     * @email shiyuan4work@sina.com
     * @date 2017/7/25 8:53
     * @price ￥:5毛
     * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
     * @callnumber 15910868535
     */
    public static int generateRandomByLength(int length){
        if(length > 9) {
            //_logger.info("将要生成的随机数值大于int精度，请使用返回值为long的generateRandomByLength方法") ;
            return 0;
        }
        StringBuilder str= new StringBuilder();//定义变长字符串
        Random random = new Random();
        //随机生成数字，并添加到字符串
        for(int i=0;i<length;i++){
            str.append(random.nextInt(10));
        }
        //_logger.info("生成的随机数：{}",str.toString()) ;
        return Integer.parseInt(str.toString());
    }

    /**
     * @description <p>根据ascii生成随机数</p>
     * @param
     * @return
     * @author heshiyuan
     * @date 2017/11/6 18:11
     */
    public static String generateStringByLength(int length){
        String sRand = "" ;
        Random random = new Random();
        for(int i=48;i<(48+length);i++){
            sRand += random.nextInt(10);
        }
        _logger.info("生成的{}位随机字符：{}", length, sRand) ;
        return sRand;
    }

    public static Integer[] generetaArrayByLength(int length){
		Integer[] newArray = new Integer[length] ;
		Random random = new Random();
		for (int i=0;i<length;i++){
			//随机生成数字，并添加到字符串
			newArray[i] = random.nextInt(100000) ;
		}
		return newArray ;
	}
}
