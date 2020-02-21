package com.xinyi.view;

import java.awt.EventQueue;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.naming.directory.SearchControls;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.xinyi.common.xinyiConstant;
import com.xinyi.dao.orderDao;
import com.xinyi.model.PageInfo;
import com.xinyi.model.order;
import com.xinyi.util.DateChooser;
import com.xinyi.util.DateUtil;
import com.xinyi.util.StringUtil;
import com.xinyi.util.jdbcUtil;
import com.xinyi.view.dingdanIFM.orderAdd;
import com.xinyi.view.dingdanIFM.orderDetail;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class dingDanIFM extends JInternalFrame {
	private MainFrm mainFrm;
	
	public MainFrm getMainFrm() {
		return mainFrm;
	}

	public void setMainFrm(MainFrm mainFrm) {
		this.mainFrm = mainFrm;
	}

	private JTextField placeTimeField;
	private DateChooser placeDateChooser;
	private JTable table;
	private JPanel panel;
	private JComboBox comboBox;
	
	private jdbcUtil jdbcUtil = new jdbcUtil();
	private orderDao orderDao = new orderDao();
	
	private com.xinyi.util.pagePanel pagePanel;
	private JTextField choosedOrderID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dingDanIFM frame = new dingDanIFM();
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
	public dingDanIFM() throws Exception {
		getContentPane().setBackground(UIManager.getColor("Button.background"));
		setIconifiable(true);
		setClosable(true);
		setForeground(Color.BLACK);
		setBackground(UIManager.getColor("Button.light"));
		setFrameIcon(new ImageIcon(dingDanIFM.class.getResource("/images/dingDanIFM/dingdan.png")));
		setTitle("订单管理");
		try {
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setBounds(100, 100, 975, 669);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u67E5\u8BE2\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setViewportBorder(new TitledBorder(null, "\u8BA2\u5355", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		//翻页
		pagePanel = new com.xinyi.util.pagePanel();
		pagePanel.setDanIFM(this);
		
		JButton btnNewButton_4 = new JButton("查看详情");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seeOrderDetail();
			}
		});
		btnNewButton_4.setFont(new Font("微软雅黑", Font.BOLD, 18));
		
		JLabel lblNewLabel = new JLabel("已选择订单ID:");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
		
		choosedOrderID = new JTextField();
		choosedOrderID.setFont(new Font("微软雅黑", Font.BOLD, 18));
		choosedOrderID.setColumns(10);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(57)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(pagePanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 857, Short.MAX_VALUE)
								.addComponent(scrollPane, Alignment.LEADING)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(239)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(choosedOrderID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(24)
							.addComponent(btnNewButton_4)))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 359, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_4)
						.addComponent(lblNewLabel)
						.addComponent(choosedOrderID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
					.addComponent(pagePanel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(28))
		);
			
		
		table = new JTable();
		//表格选择事件
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tableChoose();
			}
		});
		table.setFont(new Font("微软雅黑", Font.BOLD, 14));
		
		
		// 设置表格内容颜色
        table.setForeground(Color.BLACK);                   // 字体颜色
        table.setFont(new Font(null, Font.PLAIN, 14));      // 字体样式
        table.setSelectionForeground(Color.DARK_GRAY);      // 选中后字体颜色
        table.setSelectionBackground(Color.LIGHT_GRAY);     // 选中后字体背景
        table.setGridColor(Color.GRAY);                     // 网格颜色
        
        // 设置table内容居中
        DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
        cr.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class,cr);
       
        //设置表头居中
        DefaultTableCellRenderer thr = new DefaultTableCellRenderer();
        thr.setHorizontalAlignment(JLabel.CENTER);
        table.getTableHeader().setDefaultRenderer(thr);
        
        // 设置表头
        table.getTableHeader().setResizingAllowed(false);               // 设置不允许手动改变列宽
        table.getTableHeader().setReorderingAllowed(false);             // 设置不允许拖动重新排序各列  
      
        // 设置行高
        table.setRowHeight(30);   
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BA2\u5355ID", "\u5BA2\u6237\u540D\u79F0", "\u6570\u91CF", "\u5355\u4EF7", "\u4E0B\u5355\u65F6\u95F4", "\u521B\u5EFA\u65F6\u95F4", "\u51FA\u8D27\u65F6\u95F4"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, String.class, Integer.class, Float.class, String.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		scrollPane.setViewportView(table);
		
		JLabel clientName = new JLabel("客户名称 : ");
		clientName.setFont(new Font("微软雅黑", Font.BOLD, 18));
		panel.add(clientName);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("微软雅黑", Font.BOLD, 18));
		comboBox.setModel(new DefaultComboBoxModel(xinyiConstant.clientStrings));
		panel.add(comboBox);
		
		JLabel placeTime = new JLabel(" 下单时间 : ");
		placeTime.setFont(new Font("微软雅黑", Font.BOLD, 18));
		panel.add(placeTime);
		
		
		placeTimeField = new JTextField();
		placeTimeField.setEnabled(false);
		placeTimeField.setFont(new Font("微软雅黑", Font.BOLD, 12));
		panel.add(placeTimeField);
		placeTimeField.setColumns(10);

		
		JButton btnNewButton_2 = new JButton("确定");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectPlaceTime();
			}
		});
		btnNewButton_2.setFont(new Font("微软雅黑", Font.BOLD, 12));
		btnNewButton_2.setIcon(new ImageIcon(dingDanIFM.class.getResource("/images/timeIcon.png")));
		panel.add(btnNewButton_2);
		
		

		placeDateChooser = new DateChooser("yyyy-MM-dd");
		placeDateChooser.setBorder(new LineBorder(new Color(128, 128, 128)));
		placeDateChooser.setFont(new Font("微软雅黑", Font.BOLD, 12));
		panel.add(placeDateChooser);
		
		JButton btnNewButton_3 = new JButton("清空");
		btnNewButton_3.setIcon(new ImageIcon(dingDanIFM.class.getResource("/images/clean.png")));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cleatPlaceTime();
			}
		});
		btnNewButton_2.setFont(new Font("微软雅黑", Font.BOLD, 12));
		btnNewButton_2.setIcon(new ImageIcon(dingDanIFM.class.getResource("/images/timeIcon.png")));
		panel.add(btnNewButton_3);

//		
//		shipmentDateChooser = new DateChooser("yyyy-MM-dd");
//		shipmentDateChooser.setBorder(new LineBorder(new Color(128, 128, 128)));
//		shipmentDateChooser.setFont(new Font("微软雅黑", Font.BOLD, 12));
//		panel.add(shipmentDateChooser);
		
		JButton btnNewButton = new JButton("查询 ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search();
			}
		});
		btnNewButton.setIcon(new ImageIcon(dingDanIFM.class.getResource("/images/reset.png")));
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 18));
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("重置 ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(dingDanIFM.class.getResource("/images/search.png")));
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 18));
		panel.add(btnNewButton_1);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable(new order());
	}
	
	//查看详情
	private void seeOrderDetail() {
		if(StringUtil.isEmpty(this.choosedOrderID.getText())) {
			JOptionPane.showMessageDialog(null,"请选择需要查看的订单!!");
			return;
		}
//		orderDetail orderDetail = new orderDetail(this.choosedOrderID.getText());
		orderDetail orderDetail = new orderDetail();
		orderDetail.setId(this.choosedOrderID.getText());
	    orderDetail.setVisible(true);
		mainFrm.getDesktopPane().add(orderDetail);
	}

	//选择表格事件
	private void tableChoose() {
		int row = this.table.getSelectedRow();//
		this.choosedOrderID.setText((String)table.getValueAt(row, 0));
	}

	//重置
	private void reset() {
		// TODO Auto-generated method stub
		this.comboBox.setSelectedIndex(0);
		this.placeTimeField.setText("");
		this.pagePanel.resetButton();	
	}

	//清空下单时间
	private void cleatPlaceTime() {
		// TODO Auto-generated method stub
		this.placeTimeField.setText("");
	}

	//选择下单时间
	private void selectPlaceTime() {
		//获取下单时间选择器的时间
		String placeTime = DateUtil.dateToString(this.placeDateChooser.getSelect().getTime());
		this.placeTimeField.setText(placeTime);
	}

	//查询功能
	public void Search() {
		// TODO Auto-generated method stub
		String clientName = (String) this.comboBox.getSelectedItem();		
		String  placeTime = this.placeTimeField.getText();
		order order = new order(clientName,DateUtil.stringToDate(placeTime));
		this.fillTable(order);
	}
	
	//填充表格
	private void fillTable(order order) {
		DefaultTableModel dtmModel = (DefaultTableModel) table.getModel();
		dtmModel.setRowCount(0);//设置总行数为0
		Connection connection = null;			
		PageInfo pageInfo = null;
		try {
			connection = jdbcUtil.getCon();
			pageInfo = orderDao.list(this.pagePanel.getCurrentPageField(),connection,order);
			ResultSet rSet = pageInfo.getResultSet();
			while (rSet.next()) {
				Vector  vector =new Vector();
				vector.add(rSet.getString("id"));
				vector.add(rSet.getString("clientName"));
				vector.add(rSet.getInt("amount"));
				vector.add(rSet.getBigDecimal("price"));
				vector.add(DateUtil.dateToString(rSet.getDate("placeTime")));
				vector.add(DateUtil.dateToString(rSet.getDate("createTime")));
				vector.add(DateUtil.dateToString(rSet.getDate("shipmentTime")));
				dtmModel.addRow(vector);		
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				jdbcUtil.closeCon(connection);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.pagePanel.setTotalPages(pageInfo.getTotalPage()+"");
		this.pagePanel.setTotalRows(pageInfo.getTotalRows()+"");
		
	}
}
