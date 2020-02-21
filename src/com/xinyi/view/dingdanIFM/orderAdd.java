package com.xinyi.view.dingdanIFM;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.xinyi.common.xinyiConstant;
import com.xinyi.dao.orderDao;
import com.xinyi.model.order;
import com.xinyi.util.DateChooser;
import com.xinyi.util.DateUtil;
import com.xinyi.util.FileUtil;
import com.xinyi.util.StringUtil;
import com.xinyi.util.jdbcUtil;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.awt.event.ActionEvent;

public class orderAdd extends JInternalFrame {
	private JComboBox clientName;
	private JTextField nums;
	private JTextField price;
	private DateChooser xiadanTime;
	private DateChooser chuhuoTime;
	private JTextArea remark;
	
	private JLabel image;
	private JTextField fileName;
	
	private orderDao orderDao = new orderDao();
	private jdbcUtil jdbcUtil = new jdbcUtil();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					orderAdd frame = new orderAdd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public orderAdd() {
		setClosable(true);
		try {
			setClosed(true);
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setIconifiable(true);
		setTitle("订单新增");
		setFrameIcon(new ImageIcon(orderAdd.class.getResource("/images/mainFrm/menu/order_add.png")));
		setBounds(100, 100, 617, 810);
		
		JLabel lblNewLabel = new JLabel("客户名称 :");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 14));
		
		clientName = new JComboBox();
		clientName.setFont(new Font("微软雅黑", Font.BOLD, 14));
		clientName.setModel(new DefaultComboBoxModel(xinyiConstant.clientStrings));
		
		JLabel lblNewLabel_1 = new JLabel("数量 :");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
		
		nums = new JTextField();
		nums.setFont(new Font("微软雅黑", Font.BOLD, 14));
		nums.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("单价（元） :");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 14));
		
		price = new JTextField();
		price.setFont(new Font("微软雅黑", Font.BOLD, 14));
		price.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("下单时间 :");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.BOLD, 14));
		
	    xiadanTime = new DateChooser("yyyy-MM-dd");
		
		JLabel label = new JLabel("出货时间 :");
		label.setFont(new Font("微软雅黑", Font.BOLD, 14));
		
		chuhuoTime = new DateChooser("yyyy-MM-dd");
		
		JLabel label_1 = new JLabel("备注 :");
		label_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
		
		remark = new JTextArea();
		remark.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		remark.setToolTipText("");
		
		JButton btnNewButton = new JButton("新增");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderAdd();
			}
		});
		btnNewButton.setIcon(new ImageIcon(orderAdd.class.getResource("/images/mainFrm/menu/order_add.png")));
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
		
		JButton uploadButton = new JButton("上传图片");
		uploadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uploadFile();
			}
		});
		uploadButton.setIcon(new ImageIcon(orderAdd.class.getResource("/images/dingDanIFM/upload.png")));
		uploadButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
		
		image = new JLabel("");
		
		fileName = new JTextField();
		fileName.setEnabled(false);
		fileName.setFont(new Font("微软雅黑", Font.BOLD | Font.ITALIC, 14));
		fileName.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_1)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_3))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(xiadanTime, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
								.addComponent(clientName, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(nums, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
									.addGap(33)
									.addComponent(lblNewLabel_2)
									.addGap(18)
									.addComponent(price, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
									.addGap(10)
									.addComponent(chuhuoTime, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
									.addGap(106)))
							.addGap(93))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(247)
					.addComponent(btnNewButton)
					.addContainerGap(291, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(240)
					.addComponent(uploadButton, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(270, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(82)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(image, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(fileName, Alignment.LEADING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(remark, GroupLayout.PREFERRED_SIZE, 427, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(104, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(clientName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(nums, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(xiadanTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(chuhuoTime, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addComponent(lblNewLabel_3))
					.addGap(23)
					.addComponent(label_1)
					.addGap(5)
					.addComponent(remark, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(uploadButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(image, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(fileName, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton)
					.addGap(25))
		);
		getContentPane().setLayout(groupLayout);

	}

	//订单新增
	private void orderAdd() {
		String imgPath = DateUtil.getFileName()+".jpg";
		String fileName = this.fileName.getText();
		String clientName = (String) this.clientName.getSelectedItem();
		String nums = this.nums.getText();
		String price = this.price.getText();
		Date xiaDanTime = this.xiadanTime.getSelect().getTime(); 
		Date  chuhuoTime= this.chuhuoTime.getSelect().getTime(); 
		String reMark = this.remark.getText();
		if(StringUtil.isEmpty(fileName)) {
			JOptionPane.showMessageDialog(null, "请上传图片！！！");
			return;
		}
		
		if(StringUtil.isEmpty(clientName)) {
			JOptionPane.showMessageDialog(null, "客户名称不能为空！！！");
			return;
		}
		
		if(StringUtil.isEmpty(price)) {
			JOptionPane.showMessageDialog(null, "单价不能为空！！！");
			return;
		}
		
		if(StringUtil.isEmpty(reMark)) {
			JOptionPane.showMessageDialog(null, "备注不能为空！！！");
			return;
		}

		try {
			FileUtil.copy(this, fileName, xinyiConstant.getOrdersImagePath()+"\\"+imgPath);
		} catch (IOException e1) {
			
			JOptionPane.showMessageDialog(null, "图片存储异常");
		}
	
		
		order order = new order(clientName,Integer.valueOf(nums).intValue(),new BigDecimal(price),xiaDanTime,chuhuoTime,reMark,imgPath);
		Connection connection = null;
		try {
			connection = jdbcUtil.getCon();
		    int updateNum = orderDao.add(connection,order);
		    if(updateNum == 1) {
		    	JOptionPane.showMessageDialog(null, "新增订单成功");
		    	resetValues();
		    }else {
		    	JOptionPane.showMessageDialog(null, "新增订单失败");
			}
		}catch (Exception e) {
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
		System.out.println(order.toString());
	}

	private void resetValues() {
		this.clientName.setSelectedIndex(0);
		this.nums.setText("");
		this.price.setText("");
		this.remark.setText("");
		this.fileName.setText("");	
	}

	private void uploadFile() {
		// TODO Auto-generated method stub
	    String fileName = FileUtil.showFileOpenDialog(this);
	    this.fileName.setText(fileName);
	    ImageIcon image = new ImageIcon(fileName);
	    image.setImage(image.getImage().getScaledInstance(this.image.getWidth(), this.image.getHeight(), Image.SCALE_AREA_AVERAGING));
	    this.image.setIcon(image);
	}

	public JLabel getImage() {
		return image;
	}

	public void setImage(JLabel image) {
		this.image = image;
	}

	public JTextField getFileName() {
		return fileName;
	}

	public void setFileName(JTextField fileName) {
		this.fileName = fileName;
	}
}
