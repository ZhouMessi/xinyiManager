package com.xinyi.view.dingdanIFM;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class orderDetailTop1 extends JPanel {
	private JTextField orderId;
	private JTextField clientName;
	private JTextField nums;
	private JTextField price;
	private JTextField xiadanTime;
	private JTextField createTime;
	private JTextField chuhuoTime;
	private JTextArea reMark;

	/**
	 * Create the panel.
	 */
	public orderDetailTop1() {
		setBounds(0, 0, 1200, 800);
		JLabel lblNewLabel = new JLabel("订单Id :");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 14));
		
		orderId = new JTextField();
		orderId.setFont(new Font("微软雅黑", Font.BOLD, 14));
		orderId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("客户名称 :");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
		
		clientName = new JTextField();
		clientName.setFont(new Font("微软雅黑", Font.BOLD, 14));
		clientName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("数量 :");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 14));
		
		nums = new JTextField();
		nums.setFont(new Font("微软雅黑", Font.BOLD, 14));
		nums.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("单价 :");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.BOLD, 14));
		
		price = new JTextField();
		price.setFont(new Font("微软雅黑", Font.BOLD, 14));
		price.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("下单时间 :");
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.BOLD, 14));
		
		xiadanTime = new JTextField();
		xiadanTime.setFont(new Font("微软雅黑", Font.BOLD, 14));
		xiadanTime.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("创建时间 :");
		lblNewLabel_5.setFont(new Font("微软雅黑", Font.BOLD, 14));
		
		createTime = new JTextField();
		createTime.setFont(new Font("微软雅黑", Font.BOLD, 14));
		createTime.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("出货时间 :");
		lblNewLabel_6.setFont(new Font("宋体", Font.BOLD, 14));
		
		chuhuoTime = new JTextField();
		chuhuoTime.setFont(new Font("微软雅黑", Font.BOLD, 14));
		chuhuoTime.setColumns(10);
		
		JLabel label = new JLabel("备注 :");
		label.setFont(new Font("微软雅黑", Font.BOLD, 14));
		
		reMark = new JTextArea();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_6)
						.addComponent(lblNewLabel_4)
						.addComponent(label))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(reMark)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(orderId, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addGap(30)
									.addComponent(lblNewLabel_1)
									.addGap(18)
									.addComponent(clientName, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
									.addGap(31)
									.addComponent(lblNewLabel_2)
									.addGap(12)
									.addComponent(nums, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(xiadanTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_5)
									.addGap(19)
									.addComponent(createTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(0)
							.addComponent(lblNewLabel_3)
							.addGap(18)
							.addComponent(price, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
						.addComponent(chuhuoTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(135, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(orderId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(clientName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(nums, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(xiadanTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5)
						.addComponent(createTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_6)
						.addComponent(chuhuoTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(reMark, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(117, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

	public JTextField getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId.setText(orderId);
	}

	public JTextField getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName.setText(clientName); 
	}

	public JTextField getNums() {
		return nums;
	}

	public void setNums(String nums) {
		this.nums.setText(nums);
	}

	public JTextField getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price.setText(price); 
	}

	public JTextField getXiadanTime() {
		return xiadanTime;
	}

	public void setXiadanTime(String xiadanTime) {
		this.xiadanTime.setText(xiadanTime);
	}

	public JTextField getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime.setText(createTime);
	}

	public JTextField getChuhuoTime() {
		return chuhuoTime;
	}

	public void setChuhuoTime(String chuhuoTime) {
		this.chuhuoTime.setText(chuhuoTime);
	}

	public JTextArea getReMark() {
		return reMark;
	}

	public void setReMark(String reMark) {
		this.reMark.setText(reMark);
	}
}
