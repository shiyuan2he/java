package com.hsy.java.util.secure;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hsy.java.base.string.StringHelper;
/**
 * 
 * @description 
 *		<p>Base64加密工具类</p>
 * @date 2016年10月10日 下午4:19:43
 * @github 
 * 		http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class Base64Helper {
    private static final Logger _logger = LoggerFactory.getLogger(Base64Helper.class) ;
	private final static String CHARSET = "utf-8" ;

	/**
	 * @description <p>jdk方式base64加密-不建议使用</p>
	 * @param originStr 待加密的字符串
	 * @return
	 * @returnType String
	 * 方法名:stringToBase64
	 * 类名:Base64Helper
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年10月10日 下午4:26:53
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	public static String stringToBase64OfJdk(String originStr) {
        _logger.info("【jdk-base64-api】待加密的原始字符串{}",originStr);
		byte[] b = null;
		String targetStr = originStr;
		try {
		    if(StringHelper.isNotNullOrEmpty(originStr)){
                b = originStr.getBytes(CHARSET);
            }
		} catch (UnsupportedEncodingException e) {
            _logger.error("【jdk-base64-api】加密字符串{}遇到异常，异常信息：{}",originStr,e.getMessage());
		}
		if (b != null) {
            targetStr = java.util.Base64.getEncoder().encodeToString(b);
            _logger.info("【jdk-base64-api】加密后的字符串{}",targetStr);
		}
		return targetStr;
	}

	/**
	 * 
	 * @description <p>jdk api base64解密-不建议使用</p>
	 * @param originStr 待解密的原始字符串
	 * @return 解密后的字符串
	 * @returnType String
	 * 方法名:base64ToStringOfJdk
	 * 类名:Base64Helper
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年10月10日 下午4:26:58
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	public static String base64ToStringOfJdk(String originStr) {
        _logger.info("【jdk-base64-api】待解密的原始字符串{}",originStr);
		byte[] b = null;
		String targetStr = "";
		if (StringUtils.isNotBlank(originStr)) {
			try {
				b = java.util.Base64.getDecoder().decode(originStr);
				targetStr = new String(b, CHARSET);
			} catch (Exception e) {
                _logger.error("【jdk-base64-api】加密字符串{}遇到异常，异常信息：{}",originStr,e.getMessage());
			}
		}
        _logger.info("【jdk-base64-api】解密后的字符串{}",targetStr);
		return targetStr;
	}
    /**
     * @description <p>apache commons-codec加解密包</p>
     * @param originStr 加密前的字符串
     * @return 加密后的字符串
     * @author heshiyuan
     * @date 24/10/2017 3:52 PM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    public static String stringToBase64OfCc(String originStr){
        _logger.info("【apache commons-codec-base64-api】待加密的原始字符串{}",originStr);
        if(StringUtils.isBlank(originStr)) return originStr ;
        String targetStr = "";
        byte[] b = null;
        try {
            if(StringHelper.isNotNullOrEmpty(originStr)){
                b = originStr.getBytes(CHARSET);
            }
            b = Base64.encodeBase64(b) ;
            targetStr = new String(b, CHARSET);
        } catch (UnsupportedEncodingException e) {
            _logger.error("【apache commons-codec-base64-api】加密字符串{}遇到异常，异常信息：{}",originStr,e.getMessage());
        }
        _logger.info("【apache commons-codec-base64-api】加密后的字符串{}",targetStr);
        return targetStr ;
    }
    /**
     * @description <p></p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 24/10/2017 4:06 PM 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    public static String base64ToStringOfCc(String originStr){
        _logger.info("【apache commons-codec-base64-api】待解密的原始字符串{}",originStr);
        if(StringUtils.isBlank(originStr)) return originStr ;
        String targetStr = "";
        byte[] b = null;
        try {
            if(StringHelper.isNotNullOrEmpty(originStr)){
                b = originStr.getBytes(CHARSET);
            }
            b = Base64.decodeBase64(b) ;
            targetStr = new String(b, CHARSET);
        } catch (UnsupportedEncodingException e) {
            _logger.error("【apache commons-base64-api】解密字符串{}遇到异常，异常信息：{}",originStr,e.getMessage());
        }
        _logger.info("【apache commons-codec-base64-api】解密后的字符串{}",targetStr);
        return targetStr ;
    }
    /**
     * @description <p>apache commons-codec加解密包</p>
     * @param originStr
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 24/10/2017 3:52 PM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    public static String stringToBase64OfBc(String originStr){
        _logger.info("【bouncycastle-base64-api】待加密的原始字符串{}",originStr);
        if(StringUtils.isBlank(originStr)) return originStr ;
        String targetStr = "";
        byte[] b = null;
        try {
            if(StringHelper.isNotNullOrEmpty(originStr)){
                b = originStr.getBytes(CHARSET);
            }
            b = org.bouncycastle.util.encoders.Base64.encode(b);
            targetStr = new String(b, CHARSET);
        } catch (UnsupportedEncodingException e) {
            _logger.error("【bouncycastle-base64-api】加密字符串{}遇到异常，异常信息：{}",originStr,e.getMessage());
        }
        _logger.info("【bouncycastle-base64-api】加密后的字符串{}",targetStr);
        return targetStr ;
    }
    /**
     * @description <p></p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 24/10/2017 4:06 PM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    public static String base64ToStringOfBc(String originStr){
        _logger.info("【bouncycastle-base64-api】待解密的原始字符串{}",originStr);
        
        if(StringUtils.isBlank(originStr)) return originStr ;
        String targetStr = "";
        byte[] b = null;
        try {
            if(StringHelper.isNotNullOrEmpty(originStr)){
                b = originStr.getBytes(CHARSET);
            }
            b = org.bouncycastle.util.encoders.Base64.decode(b);
            targetStr = new String(b, CHARSET);
        } catch (UnsupportedEncodingException e) {
            _logger.error("【bouncycastle-base64-api】解密字符串{}遇到异常，异常信息：{}",originStr,e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        _logger.info("【bouncycastle-base64-api】解密后的字符串{}",targetStr);
        return targetStr ;
    }
}
