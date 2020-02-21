 package com.xinyi.model;

import java.awt.Font;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.TextAnchor;

import com.xinyi.common.dateCommon;
import com.xinyi.dao.orderDao;
import com.xinyi.util.DateUtil;
import com.xinyi.util.jdbcUtil;

public class orderPieChart {
	ChartPanel frame1;
	private jdbcUtil jdbcUtil = new jdbcUtil();
	private orderDao orderDao = new orderDao();
	
	public orderPieChart(){
		  DefaultPieDataset data = getDataSet();
	      JFreeChart chart = ChartFactory.createPieChart3D("最近三个月下单量占比",data,true,false,false);
	    //设置百分比
	      PiePlot pieplot = (PiePlot) chart.getPlot();
	      DecimalFormat df = new DecimalFormat("0.00%");//获得一个DecimalFormat对象，主要是设置小数问题
	      NumberFormat nf = NumberFormat.getNumberInstance();//获得一个NumberFormat对象
	      StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}({1}占{2})", nf, df);//获得StandardPieSectionLabelGenerator对象
	      pieplot.setLabelGenerator(sp1);//设置饼图显示百分比
	  
	  //没有数据的时候显示的内容
	      pieplot.setNoDataMessage("无数据显示");
	      pieplot.setCircular(false);
	      pieplot.setLabelGap(0.02D);
	  
	      pieplot.setIgnoreNullValues(true);//设置不显示空值
	      pieplot.setIgnoreZeroValues(true);//设置不显示负值
	     frame1=new ChartPanel (chart,true);
	      chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
	      PiePlot piePlot= (PiePlot) chart.getPlot();//获取图表区域对象
	      piePlot.setLabelFont(new Font("宋体",Font.BOLD,10));//解决乱码
	      chart.getLegend().setItemFont(new Font("黑体",Font.BOLD,10));
	      
	}
    private  DefaultPieDataset getDataSet() {
        DefaultPieDataset dataset = new DefaultPieDataset();
       
        dateCommon dateCommon = DateUtil.getDateCommon();		
		Connection connection = null;
		orderBarChartModel orderBarChartModel = null;
		try {
			connection = jdbcUtil.getCon();
			orderBarChartModel = orderDao.initBarChartOrder(connection, dateCommon);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				jdbcUtil.closeCon(connection);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
        dataset.setValue("华阳",orderBarChartModel.getHuayangNumByTime1()+orderBarChartModel.getHuayangNumByTime2()+orderBarChartModel.getHuayangNumByTime3());
        dataset.setValue("多威",orderBarChartModel.getDuoweiNumByTime1()+orderBarChartModel.getDuoweiNumByTime2()+orderBarChartModel.getDuoweiNumByTime3());
        dataset.setValue("同杰",orderBarChartModel.getTongjieNumByTime1()+orderBarChartModel.getTongjieNumByTime2()+orderBarChartModel.getTongjieNumByTime3());
        dataset.setValue("外商",orderBarChartModel.getWaishangNumByTime1()+orderBarChartModel.getWaishangNumByTime2()+orderBarChartModel.getWaishangNumByTime3());
        dataset.setValue("其他",60000);
        return dataset;
}
    public ChartPanel getChartPanel(){
    	return frame1;
    	
    }
}
