package com.hsy.java.base.utils;

import com.hsy.java.base.utils.RandomHelper;
import com.hsy.java.base.utils.VerificationCodeHelper;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.io.*;
/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.base.utils
 * @date 2017/11/7 11:47
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class VerificationCodeHelperTest {

    @Test
    public void testGenerateImageCode() throws IOException {
        VerificationCodeHelper verificationCodeHelper = VerificationCodeHelper.getInstance() ;
        OutputStream os = new FileOutputStream("/Users/heshiyuan/Desktop/"+RandomHelper.generateRandomByLength(3)+".jpeg");
        ImageIO.write(verificationCodeHelper.getImage(),"JPEG",os) ;
        os.flush();
        os.close();
    }
}