package com.xinyi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

import com.xinyi.model.order;
import com.xinyi.model.permission;
import com.xinyi.util.StringUtil;

public class permissionDao {

	//查询用户
	public ResultSet list(Connection connection, String userName) throws Exception {
		StringBuffer stringBuffer = new StringBuffer(" select * from t_user where 1=1 ");	
		if(StringUtil.isNotEmpty(userName)) {
			stringBuffer.append(" and userName =  "+"'"+userName+"'");
		}
		
		PreparedStatement psmt = connection.prepareStatement(stringBuffer.toString());	
		return psmt.executeQuery();
	}

	public ListModel<permission> getCurrentUserPermission(Connection connection,String userIdString) throws Exception {
		DefaultListModel listModel = new DefaultListModel<permission>();
		String  sql="select t1.permissionId , t2.permissionName, t2.permissionExplain from t_user_permission t1"
				+ " LEFT JOIN t_permission t2 on t1.permissionId = t2.id where t1.userId = "+userIdString;
		PreparedStatement psmt = connection.prepareStatement(sql);
		ResultSet rSet = psmt.executeQuery();
		while(rSet.next()) {
			permission permission = new permission();
			permission.setPermissionId(rSet.getInt("permissionId"));
			permission.setPermissionName(rSet.getString("permissionName"));
			permission.setPermissionExplain(rSet.getString("permissionExplain"));
			listModel.addElement(permission);
		}
		return listModel;
	}
	
	public ListModel<permission> getCurrentUserNotPermission(Connection connection, String userIdString) throws Exception {
		DefaultListModel listModel = new DefaultListModel<permission>();
		String sql = "select * from t_permission where id not in (select t1.permissionId  from t_user_permission t1 "
				+ "LEFT JOIN t_permission t2 on t1.permissionId = t2.id where t1.userId = "+userIdString+")";
		
		PreparedStatement psmt = connection.prepareStatement(sql);
		ResultSet rSet = psmt.executeQuery();
		while(rSet.next()) {
			permission permission = new permission();
			permission.setPermissionId(rSet.getInt("id"));
			permission.setPermissionName(rSet.getString("permissionName"));
			permission.setPermissionExplain(rSet.getString("permissionExplain"));
			listModel.addElement(permission);
		}
		return listModel;

	}

	public int deleteCurrentUserPermission(Connection connection, String userIdString, List<permission> permissions) throws Exception {
		StringBuffer stringBuffer = new StringBuffer("delete from t_user_permission where userId = "+userIdString+" and permissionId in (");
		for (int i = 0; i < permissions.size(); i++) {
			if(i<permissions.size()-1) {
				stringBuffer.append(""+permissions.get(i).getPermissionId()+",");
			}else {
				stringBuffer.append(""+permissions.get(i).getPermissionId()+"");
			}
		}
		stringBuffer.append(");");
		PreparedStatement psmt = connection.prepareStatement(stringBuffer.toString());
		System.out.println(stringBuffer);
		return psmt.executeUpdate();
	}

	public int addCurrentUserPermission(Connection connection, String userIdString, List<permission> permissions) throws Exception {
		String sql = "insert into t_user_permission values(null,+"+userIdString+",?)";
		int i=0;
		for (int j = 0; j < permissions.size(); j++) {
			PreparedStatement psmt = connection.prepareStatement(sql);
			System.out.println("sql = "+sql);
			psmt.setInt(1, permissions.get(i).getPermissionId());
			i++;
			psmt.executeUpdate();
		}
		return i;
	}
}
