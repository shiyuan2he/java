package com.hsy.java.util.jdbc.entity;



public class TSsoRolePermission{
	private Long id;
	private Long roleId;
	private Long permissionId;
	public void setId(Long id){
		this.id=id;
	}
	public Long getId(){
		return id;
	}
	public void setRoleId(Long roleId){
		this.roleId=roleId;
	}
	public Long getRoleId(){
		return roleId;
	}
	public void setPermissionId(Long permissionId){
		this.permissionId=permissionId;
	}
	public Long getPermissionId(){
		return permissionId;
	}
}

