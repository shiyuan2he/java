package org.hsy.java.base.utils;

import java.awt.*;
import java.util.Random;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/org.hsy.java.base.utils
 * @date 2017/11/6 17:43
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class ColorHelper {

    // 给定范围获得随机颜色
    /**
     * @description <p>根据指定的区间生成rgb颜色</p>
     * @param fc 上区间
     * @param bc 下区间
     * @return 颜色对象
     * @author heshiyuan
     * @date 2017/11/6 17:43
     */
    public static Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255){
           fc = 255;
        }
        if (bc > 255){
           bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }
}
