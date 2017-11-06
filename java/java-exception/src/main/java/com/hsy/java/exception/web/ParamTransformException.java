package com.hsy.java.exception.web;

import com.hsy.java.enums.WebEnum;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.exception.web
 * @date 2017/11/2 08:37
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class ParamTransformException extends RuntimeException{
    private String code ;

    public ParamTransformException(WebEnum webEnum) {
        super(webEnum.getMessage());
        this.code = webEnum.getCode();
    }
    public ParamTransformException(String message, String code) {
        super(message);
        this.code = code;
    }

    public ParamTransformException(String message, Throwable cause, String code) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
