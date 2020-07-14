package com.xinyi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.xinyi.common.dateCommon;
import com.xinyi.model.PageInfo;
import com.xinyi.model.order;
import com.xinyi.model.orderBarChartModel;
import com.xinyi.util.DateUtil;
import com.xinyi.util.StringUtil;
import com.xinyi.util.jdbcUtil;

public class orderDao {

	public PageInfo list(String currentPageString,Connection connection, order order)throws Exception {
		int currentPage = Integer.valueOf(currentPageString);
		StringBuffer stringBuffer = new StringBuffer(" select * from t_orders where 1=1 ");	
		if(StringUtil.isNotEmpty(order.getClientName())) {
			stringBuffer.append(" and clientName = "+"'"+order.getClientName()+"'");
		}
		
		if(StringUtil.isNotEmpty(DateUtil.dateToString(order.getPlaceTime()))) {
			stringBuffer.append(" and placeTime >= "+"'"+DateUtil.getMinDate(order.getPlaceTime())+"'");
			stringBuffer.append(" and placeTime <= "+"'"+DateUtil.getMaxDate(order.getPlaceTime())+"'");
		}
		stringBuffer.append(" order by createTime desc ");
		
		PreparedStatement psmt2 = connection.prepareStatement(stringBuffer.toString());
		ResultSet resultSet = psmt2.executeQuery(stringBuffer.toString());
		int rowCount = 0;//总条数
		while (resultSet.next()) {
			rowCount++;
		}
		stringBuffer.append(" limit "+(currentPage-1)*10+","+"10");
		System.out.println(stringBuffer);
		PreparedStatement psmt = connection.prepareStatement(stringBuffer.toString());

		return new PageInfo(psmt.executeQuery(),rowCount % 10== 0 ? rowCount / 10:rowCount  / 10+ 1,rowCount);
	}

	public int add(Connection connection, order order) throws Exception {
		String sql = "insert into t_orders values(null,?,?,?,?,?,?,?,?)";
		PreparedStatement psmt = connection.prepareStatement(sql);
		psmt.setString(1, order.getClientName());
		psmt.setInt(2, order.getAmout());
		psmt.setBigDecimal(3, order.getPrice());
		psmt.setTimestamp(4,new java.sql.Timestamp(order.getPlaceTime().getTime()));
		psmt.setTimestamp(5, new java.sql.Timestamp(new java.util.Date().getTime()));
		psmt.setTimestamp(6,new java.sql.Timestamp(order.getShipmentTime().getTime()));
		psmt.setString(7, order.getReMark());
		psmt.setString(8, order.getImagePath());
		
		return psmt.executeUpdate();
	}

	public order initOrderDetail(Connection connection, String id) throws SQLException {
		order order =null;
		String sql = "select * from  t_orders  where id = ? ";
		PreparedStatement psmt = connection.prepareStatement(sql);
		psmt.setString(1, id);
		
		ResultSet rSet = psmt.executeQuery();
		while(rSet.next()) {
			order =new order();
			order.setId(rSet.getInt("id"));
			order.setAmout(rSet.getInt("amount"));
			order.setPrice(rSet.getBigDecimal("price"));
			order.setPlaceTime(rSet.getDate("placeTime"));
			order.setCreateTime(rSet.getDate("createTime"));
			order.setShipmentTime(rSet.getDate("shipmentTime"));
			order.setClientName(rSet.getString("clientName"));
			order.setReMark(rSet.getString("remark"));
			order.setImagePath(rSet.getString("imagePath"));
		}
		return order;
	}
	


	//获取柱状图数据
	public orderBarChartModel initBarChartOrder(Connection connection, dateCommon dateCommon) throws SQLException {
		orderBarChartModel orderBarChartModel = new orderBarChartModel();	
		String sql = "select sum(amount) sum FROM t_orders"
				+ " where year(placeTime) =? and MONTH(placeTime)=? and clientName = ?; ";
		PreparedStatement psmt = connection.prepareStatement(sql);
		psmt.setString(1, dateCommon.getNowYear());
		psmt.setString(2, dateCommon.getNowMonth());
		psmt.setString(3, "华阳");	
		ResultSet rSet = psmt.executeQuery();
		 if (rSet.next()) {  
			 orderBarChartModel.setHuayangNumByTime1(rSet.getInt("sum"));  
		 }  
		 
		 PreparedStatement psmt2 = connection.prepareStatement(sql);
		 psmt2.setString(1, dateCommon.getNowYear_1());
		 psmt2.setString(2, dateCommon.getNowMonth_1());
		 psmt2.setString(3, "华阳");	
		 ResultSet rSet2 = psmt2.executeQuery();
		 if (rSet2.next()) {  
			 orderBarChartModel.setHuayangNumByTime2(rSet2.getInt("sum"));  
		 }  
		 
		 PreparedStatement psmt3 = connection.prepareStatement(sql);
		 psmt3.setString(1, dateCommon.getNowYear_2());
		 psmt3.setString(2, dateCommon.getNowMonth_2());
		 psmt3.setString(3, "华阳");	
		 ResultSet rSet3 = psmt3.executeQuery();
		 if (rSet3.next()) {  
			 orderBarChartModel.setHuayangNumByTime3(rSet3.getInt("sum"));  
		 } 
		 
		 PreparedStatement psmt4 = connection.prepareStatement(sql);
		 psmt4.setString(1, dateCommon.getNowYear());
		 psmt4.setString(2, dateCommon.getNowMonth());
		 psmt4.setString(3, "多威");	
			ResultSet rSet4 = psmt4.executeQuery();
			 if (rSet4.next()) {  
				 orderBarChartModel.setDuoweiNumByTime1(rSet4.getInt("sum"));  
		 }

		PreparedStatement psmt5 = connection.prepareStatement(sql);
		psmt5.setString(1, dateCommon.getNowYear_1());
		psmt5.setString(2, dateCommon.getNowMonth_1());
		psmt5.setString(3, "多威");
		ResultSet rSet5 = psmt5.executeQuery();
		if (rSet5.next()) {
			orderBarChartModel.setDuoweiNumByTime2(rSet5.getInt("sum"));
		}
		
		PreparedStatement psmt6 = connection.prepareStatement(sql);
		psmt6.setString(1, dateCommon.getNowYear_2());
		psmt6.setString(2, dateCommon.getNowMonth_2());
		psmt6.setString(3, "多威");
		ResultSet rSet6 = psmt6.executeQuery();
		if (rSet6.next()) {
			orderBarChartModel.setDuoweiNumByTime3(rSet6.getInt("sum"));
		}
		 
		PreparedStatement psmt7 = connection.prepareStatement(sql);
		psmt7.setString(1, dateCommon.getNowYear());
		psmt7.setString(2, dateCommon.getNowMonth());
		psmt7.setString(3, "同杰");
		ResultSet rSet7 = psmt7.executeQuery();
		if (rSet7.next()) {
			orderBarChartModel.setTongjieNumByTime1(rSet7.getInt("sum"));
		}
		
		PreparedStatement psmt8 = connection.prepareStatement(sql);
		psmt8.setString(1, dateCommon.getNowYear_1());
		psmt8.setString(2, dateCommon.getNowMonth_1());
		psmt8.setString(3, "同杰");
		ResultSet rSet8 = psmt8.executeQuery();
		if (rSet8.next()) {
			orderBarChartModel.setTongjieNumByTime2(rSet8.getInt("sum"));
		}
		
		PreparedStatement psmt9 = connection.prepareStatement(sql);
		psmt9.setString(1, dateCommon.getNowYear_2());
		psmt9.setString(2, dateCommon.getNowMonth_2());
		psmt9.setString(3, "同杰");
		ResultSet rSet9 = psmt9.executeQuery();
		if (rSet9.next()) {
			orderBarChartModel.setTongjieNumByTime3(rSet9.getInt("sum"));
		}
		
		PreparedStatement psmt10 = connection.prepareStatement(sql);
		psmt10.setString(1, dateCommon.getNowYear());
		psmt10.setString(2, dateCommon.getNowMonth());
		psmt10.setString(3, "外商");
		ResultSet rSet10 = psmt10.executeQuery();
		if (rSet10.next()) {
			orderBarChartModel.setWaishangNumByTime1(rSet10.getInt("sum"));
		}
		
		PreparedStatement psmt11 = connection.prepareStatement(sql);
		psmt11.setString(1, dateCommon.getNowYear_1());
		psmt11.setString(2, dateCommon.getNowMonth_1());
		psmt11.setString(3, "外商");
		ResultSet rSet11 = psmt11.executeQuery();
		if (rSet11.next()) {
			orderBarChartModel.setWaishangNumByTime2(rSet11.getInt("sum"));
		}
		
		PreparedStatement psmt12 = connection.prepareStatement(sql);
		psmt12.setString(1, dateCommon.getNowYear_2());
		psmt12.setString(2, dateCommon.getNowMonth_2());
		psmt12.setString(3, "外商");
		ResultSet rSet12 = psmt12.executeQuery();
		if (rSet12.next()) {
			orderBarChartModel.setWaishangNumByTime3(rSet12.getInt("sum"));
		}
		 
		return orderBarChartModel;
	}
	public static void main(String[] args) {
		orderDao orderDao = new orderDao();
		jdbcUtil jdbcUtil = new jdbcUtil();
		Connection connection2 = null;
		try {		
			connection2 = jdbcUtil.getCon();
		orderBarChartModel orderBarChartModel1 = orderDao.initBarChartOrder(connection2, DateUtil.getDateCommon());
		System.out.println(orderBarChartModel1.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				jdbcUtil.closeCon(connection2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
