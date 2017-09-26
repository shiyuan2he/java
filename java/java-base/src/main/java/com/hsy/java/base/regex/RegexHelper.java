/**
 * @author 何世远	shiyuan4work@sina.com
 * @Description 文件注释
 * @date 2015年11月14日 下午4:05:38
 * @version 1.0 create at 2015年11月14日 下午4:05:38 by 何世远
 */
package com.hsy.java.base.regex;
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
    private final Logger _logger = LoggerFactory.getLogger(this.getClass()) ;
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
        return Pattern.compile("[^0-9]").matcher(number).replaceAll("");
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
     * 过滤设置的特殊符号
     *
     * @param str
     * @return
     * @throws Exception
     */
    public static String filtration(String str) throws Exception {
        String regEx = "[`~!@#$%^&*()+=|{}:;\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        return Pattern.compile(regEx).matcher(str).replaceAll("").trim();
    }
}
