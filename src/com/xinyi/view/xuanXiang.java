package com.xinyi.view;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.xinyi.permissionManager.NoLogin;
import com.xinyi.permissionManager.jumpButton;
import com.xinyi.view.cangkuIFM.songHuoAdd;
import com.xinyi.view.dingdanIFM.orderAdd;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class xuanXiang extends JPanel implements jumpButton{
	private MainFrm jf;
	private GridLayout layout;
	private List<Component> jButtons;
	private jumpButton jumpButton;//代理类


	/**
	 * Create the panel.
	 */
	public xuanXiang() throws Exception {
		// 创建 8 行 1 列 的网格布局
		layout = new GridLayout(8, 1);
		// 设置 水平 和 竖直 间隙
		layout.setHgap(10);
		layout.setVgap(10);
		this.setLayout(layout);
	    jButtons= initCompont();
		for (Component jButton : jButtons) {
			this.add( jButton);
		}
	}

	public jumpButton getJumpButton() {
		return jumpButton;
	}

	public void setJumpButton(jumpButton jumpButton) {
		this.jumpButton = jumpButton;
	}

	public List<Component> initCompont() {
		JButton btn01 = new JButton("订单管理");
		//订单管理
		btn01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				orderManager();
			}
		});
		JButton btn02 = new JButton("客户管理");
		JButton btn03 = new JButton("生产管理");
		JButton btn04 = new JButton("财务管理");
		JButton btn05 = new JButton("鞋类管理");
		JButton btn06 = new JButton("员工管理");
		JButton btn07 = new JButton("仓库管理");
		
		//仓库管理
		btn07.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				storeManager();
			}
		});
				
		JButton btn08 = new JButton("退出系统");
		btn08.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "确定退出吗?");
				if(result == 0) {
					jf.dispose();
				}
			}
		});
		
		btn01.setFont(new Font("楷体", Font.BOLD, 18));
		btn01.setIcon(new ImageIcon(xuanXiang.class.getResource("/images/mainFrm/dingDan.png")));
		btn02.setFont(new Font("楷体", Font.BOLD, 18));
		btn02.setIcon(new ImageIcon(xuanXiang.class.getResource("/images/mainFrm/keHu.png")));
		btn03.setFont(new Font("楷体", Font.BOLD, 18));
		btn03.setIcon(new ImageIcon(xuanXiang.class.getResource("/images/mainFrm/shengChan.png")));
		btn04.setFont(new Font("楷体", Font.BOLD, 18));
		btn04.setIcon(new ImageIcon(xuanXiang.class.getResource("/images/mainFrm/caiWu.png")));
		btn05.setFont(new Font("楷体", Font.BOLD, 18));
		btn05.setIcon(new ImageIcon(xuanXiang.class.getResource("/images/mainFrm/xieLei.png")));
		btn06.setFont(new Font("楷体", Font.BOLD, 18));
		btn06.setIcon(new ImageIcon(xuanXiang.class.getResource("/images/mainFrm/yuanGong.png")));
		btn07.setFont(new Font("楷体", Font.BOLD, 18));
		btn07.setIcon(new ImageIcon(xuanXiang.class.getResource("/images/mainFrm/cangKu.png")));
		btn08.setFont(new Font("楷体", Font.BOLD, 18));
		btn08.setIcon(new ImageIcon(xuanXiang.class.getResource("/images/mainFrm/exit.png")));

		List<Component> jbList = new ArrayList<Component>();
		jbList.add(btn01);
		jbList.add(btn02);
		jbList.add(btn03);
		jbList.add(btn04);
		jbList.add(btn05);
		jbList.add(btn06);
		jbList.add(btn07);
		jbList.add(btn08);
		return jbList;	
	}
	
	private void storeManager() {
		if(jButtons.size() == 9) {
			this.removeAll();
			this.layout.setRows(8);
			jButtons= initCompont();
			for (Component jButton : jButtons) {
				this.add( jButton);
			}
			this.revalidate();
			this.repaint();
			return;
		}
		
		GridLayout	layout = new GridLayout(2, 2);
		layout.setHgap(5);
		layout.setVgap(5);
		JPanel jPanel = new JPanel(layout);
		JButton  orderButton01 = new JButton("送货单录");
		orderButton01.setIcon(new ImageIcon(xuanXiang.class.getResource("/images/xuanxiang/songHuo.png")));
		orderButton01.setFont(new Font("微软雅黑", Font.BOLD, 16));
		orderButton01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				jumpButton.deliveryAdd();
			}
		});
		//送货单查询
		JButton  orderButton02 = new JButton("送货单查");
		orderButton02.setIcon(new ImageIcon(xuanXiang.class.getResource("/images/xuanxiang/songHuoSearch.png")));
		orderButton02.setFont(new Font("微软雅黑", Font.BOLD, 16));
		orderButton02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//jumpButton.orderAdd();
			}
		});
		
		JButton  orderButton03 = new JButton("订单统计");
		orderButton03.setIcon(new ImageIcon(xuanXiang.class.getResource("/images/xuanxiang/orderTongJi.png")));
		orderButton03.setFont(new Font("微软雅黑", Font.BOLD, 16));
		orderButton03.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jumpButton.orderStatistics();
			}
		});
		
		JButton  orderButton04 = new JButton("订单查询4");
		orderButton04.setFont(new Font("微软雅黑", Font.BOLD, 16));
		jPanel.add(orderButton01);
		jPanel.add(orderButton02);
		jPanel.add(orderButton03);
		jPanel.add(orderButton04);
		jButtons.add(7, jPanel);
		
		this.removeAll();
		this.layout.setRows(9);
		for (Component jButton : jButtons) {
			this.add( jButton);
		}
		this.revalidate();
		this.repaint();
		
	}

	private void orderManager() {
		if(jButtons.size() == 9) {
			this.removeAll();
			this.layout.setRows(8);
			jButtons= initCompont();
			for (Component jButton : jButtons) {
				this.add( jButton);
			}
			this.revalidate();
			this.repaint();
			return;
		}
		
		GridLayout	layout = new GridLayout(2, 2);
		layout.setHgap(5);
		layout.setVgap(5);
		JPanel jPanel = new JPanel(layout);
		JButton  orderButton01 = new JButton("订单查询");
		orderButton01.setIcon(new ImageIcon(xuanXiang.class.getResource("/images/xuanxiang/orderSearch.png")));
		orderButton01.setFont(new Font("微软雅黑", Font.BOLD, 16));
		orderButton01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				jumpButton.orderSearch();
			}
		});
		
		JButton  orderButton02 = new JButton("订单录入");
		orderButton02.setIcon(new ImageIcon(xuanXiang.class.getResource("/images/xuanxiang/order_add.png")));
		orderButton02.setFont(new Font("微软雅黑", Font.BOLD, 16));
		orderButton02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jumpButton.orderAdd();
			}
		});
		
		JButton  orderButton03 = new JButton("订单统计");
		orderButton03.setIcon(new ImageIcon(xuanXiang.class.getResource("/images/xuanxiang/orderTongJi.png")));
		orderButton03.setFont(new Font("微软雅黑", Font.BOLD, 16));
		orderButton03.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jumpButton.orderStatistics();
			}
		});
		
		JButton  orderButton04 = new JButton("订单查询4");
		orderButton04.setFont(new Font("微软雅黑", Font.BOLD, 16));
		jPanel.add(orderButton01);
		jPanel.add(orderButton02);
		jPanel.add(orderButton03);
		jPanel.add(orderButton04);
		jButtons.add(1, jPanel);
		
		this.removeAll();
		this.layout.setRows(9);
		for (Component jButton : jButtons) {
			this.add( jButton);
		}
		this.revalidate();
		this.repaint();
	}



	public void shanchu() {
//		this.remove(jPanel);
		this.layout.setRows(8);
		this.revalidate();
		this.repaint();
	}

	public MainFrm getJf() {
		return jf;
	}

	public void setJf(MainFrm jf) {
		this.jf = jf;
	}

	//订单新增
	@Override
	@NoLogin(value = "orderAdd")
	public void orderAdd() {
		orderAdd orderAdd = new orderAdd();
		orderAdd.setVisible(true);
		jf.getDesktopPane().add(orderAdd);
	}
	//订单查询
	@Override
	@NoLogin(value = "orderSearch")
	public void orderSearch() {
		dingDanIFM danIFM = null;
		try {
			danIFM = new dingDanIFM();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		danIFM.setMainFrm(jf);
		danIFM.setVisible(true);
		jf.getDesktopPane().add(danIFM);
	}
	

	//订单统计
	@Override
	@NoLogin(value = "orderStatistics")
	public void orderStatistics() {
		ordersStatisticsIFM ordersStatisticsIFM = new ordersStatisticsIFM();
		ordersStatisticsIFM.setVisible(true);
		jf.getDesktopPane().add(ordersStatisticsIFM);
	}
	//送货单新增
	@Override
	@NoLogin(value = "deliveryAdd")
	public void deliveryAdd() {
		songHuoAdd songHuoAdd = new songHuoAdd();
		songHuoAdd.setVisible(true);
		jf.getDesktopPane().add(songHuoAdd);	
	}	
}
