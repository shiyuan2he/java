package com.hsy.java.bean.dto;

import java.io.Serializable;
import java.util.Map;

/**
 * 
 * @author yingjun
 *
 * ajax 请求的返回类型封装JSON结果
 */
public class ResponseBodyBean<T> extends AbstractResponseBody implements Serializable {


	private static final long serialVersionUID = -4185151304730685014L;

	private boolean success; // 判断操作成功的唯一标识  ture成功，false失败

	private String code ;
    private String msg ;

    private T data;

    private Map<String, Object> link;

    public ResponseBodyBean(boolean success, String code , String msg) {
        this.success = success;
        this.code = code ;
        this.msg = msg;
    }

    public ResponseBodyBean(boolean success, String code, T data) {
        this.success = success ;
        this.code = code ;
        this.data = data ;
    }

    public ResponseBodyBean(boolean success, String code,String message, T data) {
        this.success = success ;
        this.code = code ;
        this.msg = message ;
        this.data = data ;
    }

    public ResponseBodyBean() {}

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

    public Map<String, Object> getLink() {
        return link;
    }

    public void setLink(Map<String, Object> link) {
        this.link = link;
    }
}
