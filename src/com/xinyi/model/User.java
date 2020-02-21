package com.xinyi.model;

import java.util.List;

import javax.sound.sampled.LineListener;

public class User {
	private int id;						//id
	private String userName;	//用户名
	private String nickName;		//昵称
	private String passWord;		//密码
	private String photoString; //头像文件名
	private List<String> permissions;//权限列表
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public User(int id, String nickName, String passWord, String photoString) {
		super();
		this.id = id;
		this.nickName = nickName;
		this.passWord = passWord;
		this.photoString = photoString;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", nickName=" + nickName + ", passWord=" + passWord
				+ ", photoString=" + photoString + ", permissions=" + permissions + "]";
	}



	public List<String> getPermissions() {
		return permissions;
	}



	public User(String userName, String nickName, String passWord, String photoString) {
		super();
		this.userName = userName;
		this.nickName = nickName;
		this.passWord = passWord;
		this.photoString = photoString;
	}



	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}



	public User(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}



	public User(int id, String userName, String nickName, String passWord, String photoString) {
		super();
		this.id = id;
		this.userName = userName;
		this.nickName = nickName;
		this.passWord = passWord;
		this.photoString = photoString;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getPhotoString() {
		return photoString;
	}
	public void setPhotoString(String photoString) {
		this.photoString = photoString;
	}
	
	
}
