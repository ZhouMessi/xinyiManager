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
			
		
		for (int i = 0; i < songHuo.getdList().size(); i++) {
			String sql2 = "insert into t_deliverguige values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement psmt2 = connection.prepareStatement(sql2);
			psmt2.setString(1, songHuo.getGuiGeUUID());
			psmt2.setString(2, songHuo.getdList().get(i).getColorRule());
			psmt2.setInt(3, songHuo.getdList().get(i).getThirty_six());
			psmt2.setInt(4, songHuo.getdList().get(i).getThirty_seven());
			psmt2.setInt(5, songHuo.getdList().get(i).getThirty_eight());
			psmt2.setInt(6, songHuo.getdList().get(i).getThirty_nine());
			psmt2.setInt(7, songHuo.getdList().get(i).getForty());
			psmt2.setInt(8, songHuo.getdList().get(i).getForty_one());
			psmt2.setInt(9, songHuo.getdList().get(i).getForty_two());
			psmt2.setInt(10, songHuo.getdList().get(i).getForty_three());
			psmt2.setInt(11, songHuo.getdList().get(i).getForty_four());
			psmt2.setInt(12, songHuo.getdList().get(i).getForty_five());
			psmt2.setInt(13, songHuo.getdList().get(i).getForty_six());
			psmt2.executeUpdate();
		}
		
		

		
		return psmt.executeUpdate();		
	}
}
