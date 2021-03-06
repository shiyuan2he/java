package org.hsy.java.enums;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/org.hsy.java.enums
 * @date 2017/10/27 14:20
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public enum WebEnum {

    WEB_FOUND_EXCEPTION("3000","WEB层发生异常"),
    PARAM_VALID_EXCEPTION("3001","参数校验异常"),
    PARAM_TRANSFORM_EXCEPTION("3002","参数转换异常"),
    ;

    private String code ;
    private String message ;

    WebEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
