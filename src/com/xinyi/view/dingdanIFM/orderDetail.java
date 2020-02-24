package com.xinyi.view.dingdanIFM;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Locale;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import com.xinyi.dao.orderDao;
import com.xinyi.model.order;
import com.xinyi.util.jdbcUtil;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

import java.awt.BorderLayout;

public class orderDetail extends JInternalFrame {
	private String id;
	private jdbcUtil jdbcUtil = new jdbcUtil();
	private orderDao orderDao = new orderDao();
	private orderDetailTop1 orderDetailTop1 = new orderDetailTop1();
	private orderDetailTop2 orderDetailTop2 = new orderDetailTop2();



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					orderDetail frame = new orderDetail();
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
	public orderDetail() {
		setMaximizable(true);	
		try {
			setFrameIcon(new ImageIcon(orderDetail.class.getResource("/images/mainFrm/menu/orderDetailIcon.png")));
			setIconifiable(true);
			setClosed(true);
			setClosable(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setTitle("订单详情");
		setBounds(50, 50, 1200, 800);
		
		// 创建选项卡面板
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		 // 创建第 1 个选项卡（选项卡只包含 标题）
        tabbedPane.addTab("基本信息",new ImageIcon(orderDetail.class.getResource("/images/baseInfo.png")), orderDetailTop1);

        // 创建第 2 个选项卡（选项卡包含 标题 和 图标）
        tabbedPane.addTab("订单图片",new ImageIcon(orderDetail.class.getResource("/images/image.png")), orderDetailTop2);

        // 创建第 3 个选项卡（选项卡包含 标题、图标 和 tip提示）
        tabbedPane.addTab("账务信息",new ImageIcon(orderDetail.class.getResource("/images/caiwu.png")),createPanel3());
       
	}

	//给选项卡初始化信息
    private void intiTab(String orderId) {
    	Connection connection = null;
    	order order = null;
    	try {
			connection  = jdbcUtil.getCon();
			order = orderDao.initOrderDetail(connection,id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				jdbcUtil.closeCon(connection);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

    	this.orderDetailTop1.setOrderId(order.getId()+"");
    	this.orderDetailTop1.setClientName(order.getClientName());
    	this.orderDetailTop1.setNums(order.getAmout()+"");
    	this.orderDetailTop1.setPrice(order.getPrice()+"");
    	this.orderDetailTop1.setXiadanTime(order.getPlaceTime()+"");
    	this.orderDetailTop1.setCreateTime(order.getCreateTime()+"");
    	this.orderDetailTop1.setChuhuoTime(order.getShipmentTime()+"");
    	this.orderDetailTop1.setReMark(order.getReMark());
    	
    	try {
			this.orderDetailTop2.setImageJLabel(order.getImagePath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}

	/**
     * 创建一个面板，面板中心显示一个标签，用于表示某个选项卡需要显示的内容
     */
    private static JComponent createPanel3() {
        // 创建面板, 使用一个 1 行 1 列的网格布局（为了让标签的宽高自动撑满面板）
        JPanel panel = new JPanel(new GridLayout(1, 1));
        // 创建标签
        JLabel label = new JLabel("我是第三个");
        label.setFont(new Font(null, Font.PLAIN, 50));
        label.setHorizontalAlignment(SwingConstants.CENTER);

        // 添加标签到面板
        panel.add(label);

        return panel;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
		intiTab(id);
	}

}
