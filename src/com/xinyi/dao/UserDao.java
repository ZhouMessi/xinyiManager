package com.xinyi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xinyi.model.User;
import com.xinyi.util.MD5Util;

public class UserDao {

	public User login(Connection connection,User user) throws Exception {
		
		User resultUser = null;
		String sqlString = "select * from t_user where userName = ? and passWord = ? ";
		PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
		preparedStatement.setString(1, user.getUserName());
		preparedStatement.setString(2, user.getPassWord());
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next()) {
			resultUser =new User();
			resultUser.setId(resultSet.getInt("id"));
			resultUser.setUserName(resultSet.getString("userName"));
			resultUser.setNickName(resultSet.getString("nickName"));
			resultUser.setPassWord(resultSet.getString("passWord"));
			resultUser.setPhotoString(resultSet.getString("photoString"));
		}
		
		return resultUser;	
	}

	
	public int checkUserName(Connection connection, String userName) throws SQLException {
		String sql = "select count(1) num from t_user where userName = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, userName);
		ResultSet rSet =preparedStatement.executeQuery();
		int num = 0;
		if (rSet.next()) {  
			num = rSet.getInt("num");  
		 } 
		return num;
	}

	//保存用户信息
	public int saveUser(Connection connection, User user) throws Exception {
		String sql = "insert into t_user values(null,?,?,?,?)";
		PreparedStatement psmt = connection.prepareStatement(sql);
		psmt.setString(1, user.getUserName());
		psmt.setString(2, user.getNickName());
		psmt.setString(3, MD5Util.getMD5(user.getPassWord()));
		psmt.setString(4, user.getPhotoString());
		
		return psmt.executeUpdate();
	}


	public int updateUserInfo(Connection connection, User user) throws Exception {
		String sql = " update t_user set nickName = ? , passWord = ? , photoString = ? where id = ?";
		PreparedStatement psmt = connection.prepareStatement(sql);
		psmt.setString(1, user.getNickName());
		psmt.setString(2, MD5Util.getMD5(user.getPassWord()));
		psmt.setString(3, user.getPhotoString());
		psmt.setInt(4, user.getId());

		return psmt.executeUpdate();
	}
}
