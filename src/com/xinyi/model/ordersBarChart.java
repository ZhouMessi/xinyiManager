package com.xinyi.model;

import java.awt.Font;
import java.sql.Connection;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;

import com.xinyi.common.dateCommon;
import com.xinyi.dao.orderDao;
import com.xinyi.util.DateUtil;
import com.xinyi.util.jdbcUtil;

public class ordersBarChart {
	ChartPanel fPanel;
	private orderDao orderDao = new orderDao();
	private jdbcUtil jdbcUtil = new jdbcUtil();

	public ordersBarChart() {
		super();
		CategoryDataset dataset = getDataSet();
		 JFreeChart chart = ChartFactory.createBarChart3D(
	            "最近三个月下单数量统计", // 图表标题
                "下单厂家", // 目录轴的显示标签
                "下单数量", // 数值轴的显示标签
                dataset, // 数据集
                PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                true,           // 是否显示图例(对于简单的柱状图必须是false)
                true,          // 是否生成工具
                false           // 是否生成URL链接
                );
		 
		//从这里开始
	        CategoryPlot plot=chart.getCategoryPlot();//获取图表区域对象
	        CategoryAxis domainAxis=plot.getDomainAxis();         //水平底部列表
	         domainAxis.setLabelFont(new Font("宋体",Font.BOLD,14));         //水平底部标题
	         domainAxis.setTickLabelFont(new Font("楷体",Font.BOLD,12));  //垂直标题
	         ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状
	         rangeAxis.setLabelFont(new Font("宋体",Font.BOLD,15));
	          chart.getLegend().setItemFont(new Font("楷体", Font.BOLD, 15));
	          chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
	          
	          BarRenderer renderer = (BarRenderer) plot.getRenderer();
	        //显示条目标签
	  		  renderer.setBaseItemLabelsVisible(true);
	  		//设置条目标签生成器,在JFreeChart1.0.6之前可以通过renderer.setItemLabelGenerator(CategoryItemLabelGenerator generator)方法实现，但是从版本1.0.6开始有下面方法代替
	  		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
	  		//设置条目标签显示的位置,outline表示在条目区域外,baseline_center表示基于基线且居中
	  		renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
	  				ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER));
	          
	        //到这里结束，虽然代码有点多，但只为一个目的，解决汉字乱码问题
	          
	          fPanel=new ChartPanel(chart,true);        //这里也可以用chartFrame,可以直接生成一个独立的Frame
		}

	   private  CategoryDataset getDataSet() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
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
		String nowString = dateCommon.getNowYear_2() + "年" + dateCommon.getNowMonth_2() + "月";
		dataset.addValue(orderBarChartModel.getHuayangNumByTime3(), "华阳", nowString);
		dataset.addValue(orderBarChartModel.getDuoweiNumByTime3(), "多威", nowString);
		dataset.addValue(orderBarChartModel.getTongjieNumByTime3(), "同杰", nowString);
		dataset.addValue(orderBarChartModel.getWaishangNumByTime3(), "外商", nowString);
		dataset.addValue(10000, "其他", nowString);

		String nowString1 = dateCommon.getNowYear_1() + "年" + dateCommon.getNowMonth_1() + "月";
		dataset.addValue(orderBarChartModel.getHuayangNumByTime2(), "华阳", nowString1);
		dataset.addValue(orderBarChartModel.getTongjieNumByTime2(), "同杰", nowString1);
		dataset.addValue(orderBarChartModel.getDuoweiNumByTime2(), "多威", nowString1);
		dataset.addValue(orderBarChartModel.getWaishangNumByTime2(), "外商", nowString1);
		dataset.addValue(15500, "其他", nowString1);

		String nowString2 = dateCommon.getNowYear() + "年" + dateCommon.getNowMonth() + "月";
		dataset.addValue(orderBarChartModel.getHuayangNumByTime1(), "华阳", nowString2);
		dataset.addValue(orderBarChartModel.getTongjieNumByTime1(), "同杰", nowString2);
		dataset.addValue(orderBarChartModel.getDuoweiNumByTime1(), "多威", nowString2);
		dataset.addValue(orderBarChartModel.getWaishangNumByTime1(), "外商", nowString2);
		dataset.addValue(30000, "其他", nowString2);

		return dataset;
	   }
	   public ChartPanel getChartPanel(){
		   return fPanel;
	   }
}
