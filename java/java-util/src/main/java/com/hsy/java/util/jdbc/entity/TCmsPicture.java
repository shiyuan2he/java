package com.hsy.java.util.jdbc.entity;

import java.util.Date;


public class TCmsPicture{
	private Long id;
	private String pictureId;
	private String pictureUrl;
	private String source;
	private Byte del;
	public void setId(Long id){
		this.id=id;
	}
	public Long getId(){
		return id;
	}
	public void setPictureId(String pictureId){
		this.pictureId=pictureId;
	}
	public String getPictureId(){
		return pictureId;
	}
	public void setPictureUrl(String pictureUrl){
		this.pictureUrl=pictureUrl;
	}
	public String getPictureUrl(){
		return pictureUrl;
	}
	public void setSource(String source){
		this.source=source;
	}
	public String getSource(){
		return source;
	}
	public void setDel(Byte del){
		this.del=del;
	}
	public Byte getDel(){
		return del;
	}
}

