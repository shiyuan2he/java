package com.hsy.javase.integer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * 
 * @description 
 *     <p>Integer工具类</p>
 * @time 2016年4月5日 下午11:36:59
 */
public class MathUtil {
    /**
     * 
     * @author shiyuan2he shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he
     * @see javase-base com.hsy.codebase.utils.javase.integer MathUtil.java
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
     * @see javase-base com.hsy.codebase.utils.javase.integer MathUtil.java
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
     * @see javase-base com.hsy.codebase.utils.javase.integer MathUtil.java
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
     * @see javase-base com.hsy.codebase.utils.javase.integer MathUtil.java
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
     * @see javase-base com.hsy.codebase.utils.javase.integer MathUtil.java
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
     * @see javase-base com.hsy.codebase.utils.javase.integer MathUtil.java
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
     * @see javase-base com.hsy.codebase.utils.javase.integer MathUtil.java
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
     * @see javase-base com.hsy.codebase.utils.javase.integer MathUtil.java
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
     * @author shiyuan2he shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he
     * @see javase-base com.hsy.codebase.utils.javase.integer MathUtil.java
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