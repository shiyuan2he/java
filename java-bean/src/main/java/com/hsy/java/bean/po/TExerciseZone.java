package com.hsy.java.bean.po;



public class TExerciseZone {
	private Long id;
	private Integer code;
	private String name;
	private Long parentId;
	private Integer sortId;
	private String remark;
	public void setId(Long id){
		this.id=id;
	}
	public Long getId(){
		return id;
	}
	public void setCode(Integer code){
		this.code=code;
	}
	public Integer getCode(){
		return code;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setParentId(Long parentId){
		this.parentId=parentId;
	}
	public Long getParentId(){
		return parentId;
	}
	public void setSortId(Integer sortId){
		this.sortId=sortId;
	}
	public Integer getSortId(){
		return sortId;
	}
	public void setRemark(String remark){
		this.remark=remark;
	}
	public String getRemark(){
		return remark;
	}

    @Override
    public String toString() {
        return "TExerciseZone{" +
                "id=" + id +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", sortId=" + sortId +
                ", remark='" + remark + '\'' +
                '}';
    }
}

