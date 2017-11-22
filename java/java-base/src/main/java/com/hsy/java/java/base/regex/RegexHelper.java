/**
 * @author 何世远	shiyuan4work@sina.com
 * @Description 文件注释
 * @date 2015年11月14日 下午4:05:38
 * @version 1.0 create at 2015年11月14日 下午4:05:38 by 何世远
 */
package com.hsy.java.java.base.regex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @author heshiyuan	shiyuan4work@sina.com
 * @Description 请输入类描述信息
 * @date 2015年11月14日 下午4:05:38
 */
public class RegexHelper {
    private static final Logger _logger = LoggerFactory.getLogger(RegexHelper.class) ;
    /**
     * @description <p>提取字符串中的数字</p>
     * @param number  代替去的字符串
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 23/09/2017 7:57 PM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    public static String numberIntercept(String number) throws Exception {
        long start = System.currentTimeMillis() ;
        _logger.info("过滤前的字符串：{}",number);
        String numberStr = Pattern.compile("[^0-9]").matcher(number).replaceAll("") ;
        _logger.info("提取出的字符串是：{}",numberStr);
        long end = System.currentTimeMillis() ;
        _logger.info("耗时【{}】毫秒",(end - start));
        return numberStr;
    }
    /**
     * @description <p>提取字符串中所有的汉字</p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 23/09/2017 7:57 PM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    public static String sinogramIntercept(String str) throws Exception {
        String regex = "[\u4E00-\u9FA5]";//汉字
        Matcher matcher = Pattern.compile(regex).matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            sb.append(matcher.group());
        }
        return sb.toString();
    }

    /**
     * @description <p>过滤设置的特殊符号</p>
     * @param str 待过滤的字符串
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 30/09/2017 8:43 AM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    public static String filtration(String str){
        String regEx = "[`~!@#$%^&*()+=|{}:;\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        return Pattern.compile(regEx).matcher(str).replaceAll("").trim();
    }
}
