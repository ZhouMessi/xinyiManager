package com.xinyi.model;

//权限
public class permission {

	public permission(int permissionId, String permissionName, String permissionExplain) {
		super();
		this.permissionId = permissionId;
		this.permissionName = permissionName;
		this.permissionExplain = permissionExplain;
	}
	private int permissionId;//权限ID
	private String permissionName;//权限名称
	private String permissionExplain;//权限说明
	
	
	public int getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}
	public permission(String permissionName, String permissionExplain) {
		super();
		this.permissionName = permissionName;
		this.permissionExplain = permissionExplain;
	}
	public permission() {
		// TODO Auto-generated constructor stub
	}
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	public String getPermissionExplain() {
		return permissionExplain;
	}
	@Override
	public String toString() {
		return permissionName +":" +permissionExplain;
	}
	public void setPermissionExplain(String permissionExplain) {
		this.permissionExplain = permissionExplain;
	}
	
	
}
