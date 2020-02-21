package com.xinyi.view;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.beans.PropertyVetoException;

import javax.swing.JInternalFrame;

import com.xinyi.model.orderPieChart;
import com.xinyi.model.ordersBarChart;

import javax.swing.ImageIcon;

public class ordersStatisticsIFM extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ordersStatisticsIFM frame = new ordersStatisticsIFM();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public ordersStatisticsIFM()  {
		setFrameIcon(new ImageIcon(ordersStatisticsIFM.class.getResource("/images/xuanxiang/orderTongJi.png")));
		setClosable(true);
		try {
			setClosed(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setIconifiable(true);
		setMaximizable(true);
		setTitle("订单数据统计");
		setBounds(100, 100, 1000, 800);
		setLayout(new GridLayout(2, 2, 10, 10));
		add(new ordersBarChart().getChartPanel());//添加柱形图                    
		add(new orderPieChart().getChartPanel());//添加柱形图
		add(new ordersBarChart().getChartPanel());//添加柱形图
		add(new ordersBarChart().getChartPanel());//添加柱形图

	}

}
