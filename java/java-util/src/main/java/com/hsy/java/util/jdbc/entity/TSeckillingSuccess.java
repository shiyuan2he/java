package com.hsy.java.util.jdbc.entity;

import java.util.Date;


public class TSeckillingSuccess{
	private Long seckillingItemId;
	private Long userPhone;
	private Byte state;
	private Date createTime;
	public void setSeckillingItemId(Long seckillingItemId){
		this.seckillingItemId=seckillingItemId;
	}
	public Long getSeckillingItemId(){
		return seckillingItemId;
	}
	public void setUserPhone(Long userPhone){
		this.userPhone=userPhone;
	}
	public Long getUserPhone(){
		return userPhone;
	}
	public void setState(Byte state){
		this.state=state;
	}
	public Byte getState(){
		return state;
	}
	public void setCreateTime(Date createTime){
		this.createTime=createTime;
	}
	public Date getCreateTime(){
		return createTime;
	}
}

