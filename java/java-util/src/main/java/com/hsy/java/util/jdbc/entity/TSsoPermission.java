package com.hsy.java.util.jdbc.entity;

import java.util.Date;


public class TSsoPermission{
	private Long id;
	private String authAddress;
	private String authDescription;
	private Long parentId;
	private Long creater;
	private Date createTime;
	private Long updater;
	private Date updateTime;
	public void setId(Long id){
		this.id=id;
	}
	public Long getId(){
		return id;
	}
	public void setAuthAddress(String authAddress){
		this.authAddress=authAddress;
	}
	public String getAuthAddress(){
		return authAddress;
	}
	public void setAuthDescription(String authDescription){
		this.authDescription=authDescription;
	}
	public String getAuthDescription(){
		return authDescription;
	}
	public void setParentId(Long parentId){
		this.parentId=parentId;
	}
	public Long getParentId(){
		return parentId;
	}
	public void setCreater(Long creater){
		this.creater=creater;
	}
	public Long getCreater(){
		return creater;
	}
	public void setCreateTime(Date createTime){
		this.createTime=createTime;
	}
	public Date getCreateTime(){
		return createTime;
	}
	public void setUpdater(Long updater){
		this.updater=updater;
	}
	public Long getUpdater(){
		return updater;
	}
	public void setUpdateTime(Date updateTime){
		this.updateTime=updateTime;
	}
	public Date getUpdateTime(){
		return updateTime;
	}
}

