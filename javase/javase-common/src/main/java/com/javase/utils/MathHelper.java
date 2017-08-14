package com.javase.utils;

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
        StringBuilder str=new StringBuilder();//定义变长字符串
        Random random=new Random();
        //随机生成数字，并添加到字符串
        for(int i=0;i<length;i++){
            str.append(random.nextInt(10));
        }
        return Integer.parseInt(str.toString());
    }
}

