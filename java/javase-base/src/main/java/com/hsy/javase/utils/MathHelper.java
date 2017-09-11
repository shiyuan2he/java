package com.hsy.javase.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;

/**
 * @description <p>请在此处输入类的描述</p>
 * @path paac-core/com.codelibrary.javaee.utils.MathHelper.java	
 * @time 2016年5月24日 上午12:01:14
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class MathHelper {
    private final static Logger _logger = LoggerFactory.getLogger(MathHelper.class);
    /**
     *
     * @description <p>根据传入的位数生成相应位数的随机数</p>
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
            _logger.error("将要生成的随机数值大于int精度，请使用返回值为long的generateRandomByLength方法") ;
            return 0;
        }
        StringBuilder str=new StringBuilder();//定义变长字符串
        Random random=new Random();
        //随机生成数字，并添加到字符串
        for(int i=0;i<length;i++){
            str.append(random.nextInt(10));
        }
        _logger.error("生成的随机数：{}",str.toString()) ;
        return Integer.parseInt(str.toString());
    }
    /**
     *
     * @description <p>根据传入的位数生成相应位数的随机数</p>
     * @returnType 生成的随机数
     * 方法名:
     * 类名:MathUtils
     * @author heshiyuan
     * @email shiyuan4work@sina.com
     * @date 2017/7/25 8:53
     * @price ￥:5毛
     * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
     * @callnumber 15910868535
     */
    public static long generateRandomOfLongByLength(int length){
        StringBuilder str=new StringBuilder();//定义变长字符串
        Random random=new Random();
        //随机生成数字，并添加到字符串
        for(int i=0;i<length;i++){
            str.append(random.nextInt(10));
        }
        _logger.error("生成的随机数：{}",str.toString()) ;
        return Long.parseLong(str.toString());
    }
    /**
     *
     * @author shiyuan2he shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he
     * @description
     *     <p>加法运算</p>
     * @time 2016年4月5日 下午11:36:53
     * @return_type double
     * @param
     */
    public static double add(String value1, String value2) {
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.add(b2).doubleValue();
    }

    /**
     *
     * @author shiyuan2he shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he
     * @description
     *     <p>减法运算</p>
     * @time 2016年4月5日 下午11:37:53
     * @return_type double
     * @param
     */
    public static double sub(String value1, String value2) {
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.subtract(b2).doubleValue();
    }

    /**
     *
     * @author shiyuan2he shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he
     * @description
     *     <p>乘法运算</p>
     * @time 2016年4月5日 下午11:38:07
     * @return_type double
     * @param
     */
    public static double mul(String value1, String value2) {
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.multiply(b2).doubleValue();
    }

    /**
     *
     * @author shiyuan2he shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he
     * @description
     *     <p>乘法运算</p>
     * @time 2016年4月5日 下午11:38:33
     * @return_type int
     * @param
     */
    public static int mul2(String value1, String value2) {
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.multiply(b2).intValue();
    }

    /**
     *
     * @author shiyuan2he shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he
     * @description
     *     <p>除法运算</p>
     * @time 2016年4月5日 下午11:38:50
     * @return_type double
     * @param
     */
    public static double div(String value1, String value2, int len) {
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.divide(b2, len, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     *
     * @author shiyuan2he shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he
     * @description
     *     <p>四舍五入</p>
     * @time 2016年4月5日 下午11:39:07
     * @return_type double
     * @param
     */
    public static double round(double d, int len) {
        // 操作
        BigDecimal b1 = new BigDecimal(d);
        BigDecimal b2 = new BigDecimal(1);
        // 任何一个数字除以1都是原数字
        // ROUND_HALF_UP是BigDecimal的一个常量，
        // 表示进行四舍五入的操作
        return b1.divide(b2, len, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    /**
     *
     * @author shiyuan2he shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he
     * @description
     *     <p>比较double类型数据大小</p>
     * @time 2016年4月5日 下午11:39:24
     * @return_type int 小于、等于或大于 data2 时，返回 -1、0 或 1
     * @param
     */
    public static int compare(double a,double b){
        BigDecimal data1 = new BigDecimal(a);
        BigDecimal data2 = new BigDecimal(b);
        return data1.compareTo(data2);// 小于、等于或大于 data2 时，返回 -1、0 或 1
    }

    /**
     *
     * @author shiyuan2he shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he
     * @description
     *     <p>功能测试</p>
     * @time 2016年4月5日 下午11:40:04
     * @return_type void
     * @param
     */
    public static void main(String[] args) {
        /*System.out.println(div("17", "100", 2));
        System.out.println(mul("1000", Double.toString(div("17", "100", 2))));
        System.out.println( Double.compare(Double.parseDouble("170"), Double.parseDouble("170.0")) );*/
        System.out.println(mul2("0.037", "100"));

        /*String sl = "0.031";
        String sub = sl.substring(sl.indexOf(".")+1);
        if(sub.length() > 2){
            System.out.println("税率有误");
        }
        System.out.println(sub);*/
        //System.out.println(formatDoubleDigit(Double.parseDouble("200.056")));
    }

    /**
     *
     * @github https://github.com/shiyuan2he
     * @description
     *     <p>格式化两位小数</p>
     * @time 2016年4月6日 下午10:59:12
     * @return_type String
     * @param
     */
    public static String formatDoubleDigit(double value){
        DecimalFormat df = new DecimalFormat("##########0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        return df.format(value);
    }
}

