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
    private static final Logger _logger = LoggerFactory.getLogger(RegexHelper.class) ;
    /**
     * @description <p>提取字符串中的数字</p>
     * @param number  被替代的字符串
     * @return 过滤后的字符串
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

    /**
     * 验证手机号码
     *
     * 移动号码段:139、138、137、136、135、134、150、151、152、157、158、159、182、183、187、188、147
     * 联通号码段:130、131、132、136、185、186、145
     * 电信号码段:133、153、180、189
     *
     * @param cellphone
     * @return
     */
    public static boolean checkCellphone(String cellphone) {
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(regex);
        if(m.matches()){
            return true ;
        }
        return false;
    }

    /**
     * 验证固话号码
     *
     * @param telephone
     * @return
     */
    public static boolean checkTelephone(String telephone) {
        String regex = "^(0\\d{2}-\\d{8}(-\\d{1,4})?)|(0\\d{3}-\\d{7,8}(-\\d{1,4})?)$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(regex);
        if(m.matches()){
            return true ;
        }
        return false;
    }
}
