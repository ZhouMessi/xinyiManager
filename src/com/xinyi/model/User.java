package com.xinyi.model;

import com.xinyi.daoManager.Parameter;
import com.xinyi.daoManager.Table;

@Table(TableName = "t_user")
public class User {
	
	@Parameter(name = "id")
	private int id;						//id
	
	@Parameter(name = "userName")
	private String userName;	//用户名
	
	@Parameter(name = "nickName")
	private String nickName;		//昵称
	
	@Parameter(name = "passWord")
	private String passWord;		//密码
	
	@Parameter(name = "photoString")
	private String photoString; //头像文件名
	
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
				+ ", photoString=" + photoString;
	}

	public User(String userName, String nickName, String passWord, String photoString) {
		super();
		this.userName = userName;
		this.nickName = nickName;
		this.passWord = passWord;
		this.photoString = photoString;
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
