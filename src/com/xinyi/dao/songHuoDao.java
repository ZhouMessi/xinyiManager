package com.xinyi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.xinyi.model.order;
import com.xinyi.model.songHuo;

public class songHuoDao {
	
	public int add(Connection connection, songHuo songHuo) throws Exception {
		String sql = "insert into t_delivergoods values(null,?,?,?,?,?,?,?,?,?)";
		PreparedStatement psmt = connection.prepareStatement(sql);
		psmt.setString(1, songHuo.getClientName());
		psmt.setTimestamp(2,new java.sql.Timestamp(songHuo.getDeliveryTime().getTime()));
		psmt.setString(3, songHuo.getDriver());
		psmt.setString(4, songHuo.getOddNums());
		psmt.setString(5, songHuo.getTotalPagNums());
		psmt.setString(6, songHuo.getTotalCounts());
		psmt.setString(7, songHuo.getImagePath());
		psmt.setString(8, songHuo.getRemark());
		psmt.setString(9, songHuo.getGuiGeUUID());
			
		return psmt.executeUpdate();
	}
}
