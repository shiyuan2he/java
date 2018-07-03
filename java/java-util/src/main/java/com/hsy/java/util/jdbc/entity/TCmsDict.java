package com.hsy.java.util.jdbc.entity;

import java.util.Date;


public class TCmsDict{
	private Long id;
	private String dictId;
	private String dictName;
	private String parentId;
	private Date createTime;
	private String createUserId;
	private Date updateTime;
	private String updateUserId;
	private Byte del;
	public void setId(Long id){
		this.id=id;
	}
	public Long getId(){
		return id;
	}
	public void setDictId(String dictId){
		this.dictId=dictId;
	}
	public String getDictId(){
		return dictId;
	}
	public void setDictName(String dictName){
		this.dictName=dictName;
	}
	public String getDictName(){
		return dictName;
	}
	public void setParentId(String parentId){
		this.parentId=parentId;
	}
	public String getParentId(){
		return parentId;
	}
	public void setCreateTime(Date createTime){
		this.createTime=createTime;
	}
	public Date getCreateTime(){
		return createTime;
	}
	public void setCreateUserId(String createUserId){
		this.createUserId=createUserId;
	}
	public String getCreateUserId(){
		return createUserId;
	}
	public void setUpdateTime(Date updateTime){
		this.updateTime=updateTime;
	}
	public Date getUpdateTime(){
		return updateTime;
	}
	public void setUpdateUserId(String updateUserId){
		this.updateUserId=updateUserId;
	}
	public String getUpdateUserId(){
		return updateUserId;
	}
	public void setDel(Byte del){
		this.del=del;
	}
	public Byte getDel(){
		return del;
	}
}

