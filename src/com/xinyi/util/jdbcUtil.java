package com.xinyi.util;

import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	
	public static List<String> getCurrentPermissionS(int userId){
		jdbcUtil jdbcUtil = new jdbcUtil();
		Connection connection =null;
		List<String> permissionList = new ArrayList<String>();	
		try {
			connection =jdbcUtil.getCon();			
			String pListSql = "SELECT t2.permissionName pList from t_user_permission t1"
					+ " LEFT JOIN t_permission t2 on t1.permissionId = t2.id "
					+ "LEFT JOIN t_user t3 on  t1.userId = t3.id where t3.id = ?";
			PreparedStatement preparedStatement2 = connection.prepareStatement(pListSql);
			preparedStatement2.setInt(1, userId);
			ResultSet rSet = preparedStatement2.executeQuery();
			while (rSet.next()) {
				permissionList.add(rSet.getString("pList"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				jdbcUtil.closeCon(connection);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return permissionList;
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
