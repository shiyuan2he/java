package com.hsy.java.bean.dto;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.bean.dto
 * @date 2018/6/28 9:05
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class ServiceResponseBody<T> implements java.io.Serializable{
    public static boolean success = true; // 判断操作成功的唯一标识  ture成功，false失败

    private String code ;
    private String msg ;

    private T data;

    public ServiceResponseBody(boolean success, String code , String msg) {
        this.success = success;
        this.code = code ;
        this.msg = msg;
    }

    public ServiceResponseBody(boolean success, String code, T data) {
        this.success = success ;
        this.code = code ;
        this.data = data ;
    }

    public ServiceResponseBody(boolean success, String code,String message, T data) {
        this.success = success ;
        this.code = code ;
        this.msg = message ;
        this.data = data ;
    }

    public ServiceResponseBody() {}

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
