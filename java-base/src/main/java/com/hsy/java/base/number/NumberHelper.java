package com.hsy.java.base.number;

import java.util.regex.Pattern;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.java.base.number
 * @date 2018/1/8 13:41
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class NumberHelper {
    /**
     * @description <p></p>
     * @param numberStr 待验证的字符串
     * @return 是否是数字
     * @author heshiyuan
     * @date 2018/8/20 10:19
     */
    public static boolean isNumber(String numberStr){
       if(isNumericOne(numberStr) && isNumericTwo(numberStr) && isNumericThree(numberStr)
               && isNumericFour(numberStr) && isNumericFive(numberStr) && isNumericSix(numberStr))
           return true;
       return  false;
    }
    //方法一：用JAVA自带的函数
    public static boolean isNumericOne(String str){
        for (int i = str.length();--i>=0;){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
    /**
     * 方法二：推荐，速度最快
     * 判断是否为整数
     * @param str 传入的字符串
     * @return 是整数返回true,否则返回false
     */
    public static boolean isNumericTwo(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }


    //方法三：
    public static boolean isNumericThree(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }
    //方法四：
    public final static boolean isNumericFour(String s) {
        if (s != null && !"".equals(s.trim()))
            return s.matches("^[0-9]*$");
        else
            return false;
    }
    //方法五：用ascii码
    public static boolean isNumericFive(String str){
        for(int i=str.length();--i>=0;){
            int chr=str.charAt(i);
            if(chr<48 || chr>57)
                return false;
        }
        return true;
    }

    //方法六：用异常
    public static boolean isNumericSix(String str){
        try{
            Integer.parseInt(str);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
