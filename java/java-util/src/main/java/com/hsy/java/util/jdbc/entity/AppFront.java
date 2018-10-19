package com.hsy.java.util.jdbc.entity;



public class AppFront{
	private Object id;
	private Byte type;
	private String name;
	private String img;
	private Byte priority;
	private Long createdAt;
	private Long updatedAt;
	private String related;
	private Byte module;
	private String desc;
	public void setId(Object id){
		this.id=id;
	}
	public Object getId(){
		return id;
	}
	public void setType(Byte type){
		this.type=type;
	}
	public Byte getType(){
		return type;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setImg(String img){
		this.img=img;
	}
	public String getImg(){
		return img;
	}
	public void setPriority(Byte priority){
		this.priority=priority;
	}
	public Byte getPriority(){
		return priority;
	}
	public void setCreatedAt(Long createdAt){
		this.createdAt=createdAt;
	}
	public Long getCreatedAt(){
		return createdAt;
	}
	public void setUpdatedAt(Long updatedAt){
		this.updatedAt=updatedAt;
	}
	public Long getUpdatedAt(){
		return updatedAt;
	}
	public void setRelated(String related){
		this.related=related;
	}
	public String getRelated(){
		return related;
	}
	public void setModule(Byte module){
		this.module=module;
	}
	public Byte getModule(){
		return module;
	}
	public void setDesc(String desc){
		this.desc=desc;
	}
	public String getDesc(){
		return desc;
	}
}

