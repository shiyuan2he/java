package com.hsy.java.base.utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * @author heshiyuan
 * @description <p>验证码工具类</p>
 * @path java/com.hsy.java.base.utils
 * @date 2017/11/6 17:32
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class VerificationCodeHelper {
    // 设置图像的宽高
    private int width ; // 验证码宽度
    private int height ; // 验证码高度
    private String font ;// 验证码字体
    private String codeType ; // "4":4位数字   "4a":4位数字和字母

    private BufferedImage image; // 图像
    private String str; // 验证码

    private VerificationCodeHelper () {
        width = 120;
        height = 30;
        font = "Times New Roman";
        codeType = "4";
        init();
    }

    // 获取实例
    public static VerificationCodeHelper Instance() {
        return new VerificationCodeHelper();
    }

    // 获取图片
    public RenderedImage getImage() {
        return this.image;
    }

    // 获取6位随机验证码
    public String getStr() {
        return this.str;
    }

    private void init() {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 获取图形上下文,画图工具
        Graphics graphics = image.getGraphics();
        // 生成随机类
        Random random = new Random();
        // 设定背景色
        graphics.setColor(ColorHelper.getRandColor(200, 250));
        graphics.fillRect(0, 0, width, height);//填充矩形
        // 设定字体
        graphics.setFont(new Font(font, Font.PLAIN, height - 4));
        // 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
        graphics.setColor(ColorHelper.getRandColor(160, 200));
        for (int i = 0; i < 155; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            graphics.drawLine(x, y, x + xl, y + yl);
        }
        // 取随机产生的认证码(4位数字)
        String sRand = "";
        generateString(sRand,graphics) ;
        // 赋值验证码
        this.str = sRand;
        // 图象生效
        graphics.dispose();
        this.image = image;
    }
    /**
     * @description <p>
     *     48~57 是数字的ASCII值
     *     65～90 是大写字母
     *     97～122 是小写字母
     * </p>
     * @param
     * @return
     * @author heshiyuan
     * @date 2017/11/6 18:05
     */
    private void generateString(String sRand,Graphics graphics) {
        int length = 0 ;
        Random random = new Random();
        String rand = "" ;
        if(codeType.length()==1){
            length = Integer.parseInt(codeType) ;
            rand = String.valueOf(random.nextInt(10));
        }else{
            length = Integer.parseInt(Pattern.compile("[^0-9]").matcher(codeType).replaceAll("").trim());
        }
        // 取随机产生的认证码(4位数字)
        for (int i = 0; i < length; i++) {
            sRand += rand;
            // 将认证码显示到图象中
            graphics.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            // 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
            graphics.drawString(rand, 13 * i + 26, 25);
        }
    }


}
