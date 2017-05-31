package com.hsy.codebase.utils.javase.json;

import java.util.Date;

public class User {
	private String userId;
	private String userName;
	private String userCode;
	private String userPwd;
	private Date userRegTime;
	private String userLoginIp;
	
	public User() {
		super();
	}
	
	public User(String userId, String userName, String userCode,
			String userPwd, Date userRegTime,String userLoginIp) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userCode = userCode;
		this.userPwd = userPwd;
		this.userRegTime = userRegTime;
		this.userLoginIp = userLoginIp;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public Date getUserRegTime() {
		return userRegTime;
	}
	public void setUserRegTime(Date userRegTime) {
		this.userRegTime = userRegTime;
	}
	public String getUserLoginIp() {
		return userLoginIp;
	}
	public void setUserLoginIp(String userLoginIp) {
		this.userLoginIp = userLoginIp;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", userCode=" + userCode + ", userPwd=" + userPwd
				+ ", userRegTime=" + userRegTime + ", userLoginIp="
				+ userLoginIp + "]";
	}
}
