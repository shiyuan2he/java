package com.hsy.javase.enums;
/**
 * @description <p>系统全局枚举code代码</p>
 * @path javase-base/com.hsy.codebase.utils.javase.enums
 * @time 2016年7月27日 下午8:27:31
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public enum SysBaseEnumCode {
	SUCCESS("000000","操作成功"),
	FAILURE("999999","操作失败") ;
	private String code ;
	private String message ;
	
	SysBaseEnumCode(String code,String message){
		this.code = code ;
		this.message = message ;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

