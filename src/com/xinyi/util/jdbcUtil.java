package com.xinyi.util;

import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.DriverManager;

import com.xinyi.model.User;
import com.xinyi.model.order;

public class jdbcUtil {
	
	private String dbUrl = "jdbc:mysql://localhost:3306/db_xinyi?characterEncoding=utf8&amp;useSSL=false";
	private String dbUserName = "root";
	private String dbPassWordString = "root";
	private String DriverName = "com.mysql.jdbc.Driver";
	
	public Connection getCon() throws Exception{
 		getClass().forName(DriverName);
		Connection connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassWordString);
		return connection;
	}
	
	public void closeCon(Connection connection) throws Exception {
		if(connection!=null) {
			connection.close();
		}
	}
	
	public static void main(String[] args) {
		jdbcUtil jdbcUtil = new jdbcUtil();
		try {
			jdbcUtil.getCon();
			System.out.println("连接数据库成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("连接数据库失败");
		}
	}
}
