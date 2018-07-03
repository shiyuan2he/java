package com.hsy.java.util.jdbc.entity;

import java.util.Date;


public class TCmsCheck{
	private Long id;
	private String checkId;
	private String checkName;
	private Byte checkState;
	private String checkRemark;
	private Byte del;
	private Date createTime;
	private String createUserId;
	private Date checkTime;
	private String checkUserId;
	public void setId(Long id){
		this.id=id;
	}
	public Long getId(){
		return id;
	}
	public void setCheckId(String checkId){
		this.checkId=checkId;
	}
	public String getCheckId(){
		return checkId;
	}
	public void setCheckName(String checkName){
		this.checkName=checkName;
	}
	public String getCheckName(){
		return checkName;
	}
	public void setCheckState(Byte checkState){
		this.checkState=checkState;
	}
	public Byte getCheckState(){
		return checkState;
	}
	public void setCheckRemark(String checkRemark){
		this.checkRemark=checkRemark;
	}
	public String getCheckRemark(){
		return checkRemark;
	}
	public void setDel(Byte del){
		this.del=del;
	}
	public Byte getDel(){
		return del;
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
	public void setCheckTime(Date checkTime){
		this.checkTime=checkTime;
	}
	public Date getCheckTime(){
		return checkTime;
	}
	public void setCheckUserId(String checkUserId){
		this.checkUserId=checkUserId;
	}
	public String getCheckUserId(){
		return checkUserId;
	}
}

