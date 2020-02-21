package com.xinyi.menuView;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.GridLayout;
import java.security.Permissions;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.xinyi.dao.orderDao;
import com.xinyi.dao.permissionDao;
import com.xinyi.model.permission;
import com.xinyi.util.DateUtil;
import com.xinyi.util.jdbcUtil;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.naming.directory.SearchControls;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class permissionSet extends JInternalFrame {

	private jdbcUtil jdbcUtil = new jdbcUtil();
	private permissionDao permissionDao = new permissionDao();
	private JTextField userNameField;
	private JTable table;
	private JList list;
	private JList addPermissionList;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					permissionSet frame = new permissionSet();
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
	public permissionSet() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("分配权限");
		setFrameIcon(new ImageIcon(permissionSet.class.getResource("/images/mainFrm/menu/permission.png")));
		setBounds(100, 100, 1200, 429);

		JLabel lblNewLabel = new JLabel("请输入用户名:");
		lblNewLabel.setFont(new Font("幼圆", Font.BOLD, 16));

		userNameField = new JTextField();
		userNameField.setFont(new Font("幼圆", Font.BOLD, 16));
		userNameField.setColumns(10);

		JButton btnNewButton = new JButton("查找");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchUser();
			}
		});
		btnNewButton.setIcon(new ImageIcon(permissionSet.class.getResource("/images/reset.png")));
		btnNewButton.setFont(new Font("幼圆", Font.BOLD, 16));

		JScrollPane tableScrollPane = new JScrollPane();

		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton_1 = new JButton("移除");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeCurrentUserPermission();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(permissionSet.class.getResource("/images/mainFrm/menu/deletePermission.png")));
		btnNewButton_1.setFont(new Font("幼圆", Font.BOLD, 16));
		
		JButton btnNewButton_2 = new JButton("新增");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addcurrentUserPermission();
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(permissionSet.class.getResource("/images/mainFrm/menu/addPermission.png")));
		btnNewButton_2.setFont(new Font("幼圆", Font.BOLD, 16));
		
		JScrollPane scrollPane_1 = new JScrollPane();

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(userNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton))
						.addComponent(tableScrollPane, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addGap(35)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
					.addGap(114))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(113)
							.addComponent(btnNewButton_1)
							.addGap(69)
							.addComponent(btnNewButton_2))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(53)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel)
										.addComponent(userNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNewButton))
									.addGap(58)
									.addComponent(tableScrollPane, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE))
								.addComponent(scrollPane, Alignment.TRAILING)
								.addComponent(scrollPane_1, Alignment.TRAILING))))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_2 = new JLabel("   需要新增的权限");
		lblNewLabel_2.setIcon(new ImageIcon(permissionSet.class.getResource("/images/mainFrm/menu/order_add.png")));
		lblNewLabel_2.setFont(new Font("幼圆", Font.BOLD, 16));
		scrollPane_1.setColumnHeaderView(lblNewLabel_2);
		
		addPermissionList = new JList();
		
		addPermissionList.setFont(new Font("幼圆", Font.BOLD, 16));

		// 设置字体颜色（未选中时）
		addPermissionList.setForeground(Color.black);

		// 设置选中选项的字体颜色
		addPermissionList.setSelectionForeground(Color.yellow);

		// 设置选中条的颜色
		addPermissionList.setSelectionBackground(Color.blue);

		scrollPane_1.setViewportView(addPermissionList);

		JLabel lblNewLabel_1 = new JLabel("  当前用户拥有的权限");
		lblNewLabel_1.setIcon(new ImageIcon(permissionSet.class.getResource("/images/mainFrm/menu/permission1.png")));
		lblNewLabel_1.setFont(new Font("幼圆", Font.BOLD, 16));
		scrollPane.setColumnHeaderView(lblNewLabel_1);

		list = new JList();
		list.setFont(new Font("幼圆", Font.BOLD, 16));

		// 设置字体颜色（未选中时）
		list.setForeground(Color.black);

		// 设置选中选项的字体颜色
		list.setSelectionForeground(new Color(255, 255, 0));

		// 设置选中条的颜色
		list.setSelectionBackground(Color.RED);

		scrollPane.setViewportView(list);
		System.out.println(list.getSize());
		table = new JTable();

		// 表格选择事件
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tableChoose();
			}
		});

		// 设置表格内容颜色
		table.setForeground(Color.BLACK); // 字体颜色
		table.setFont(new Font("幼圆", Font.BOLD, 14)); // 字体样式
		table.setSelectionForeground(Color.DARK_GRAY); // 选中后字体颜色
		table.setSelectionBackground(Color.LIGHT_GRAY); // 选中后字体背景
		table.setGridColor(Color.GRAY); // 网格颜色

		// 设置table内容居中
		DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
		cr.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, cr);

		// 设置表头居中
		DefaultTableCellRenderer thr = new DefaultTableCellRenderer();
		thr.setHorizontalAlignment(JLabel.CENTER);
		table.getTableHeader().setDefaultRenderer(thr);

		// 设置表头
		table.getTableHeader().setResizingAllowed(false); // 设置不允许手动改变列宽
		table.getTableHeader().setReorderingAllowed(false); // 设置不允许拖动重新排序各列

		// 设置行高
		table.setRowHeight(30);

		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u7528\u6237ID", "\u767B\u5F55\u7528\u6237\u540D", "\u663E\u793A\u540D\u79F0" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, Object.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		tableScrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);

		this.fillTable("");
	}

	private void addcurrentUserPermission() {
		 // 获取所有被选中的选项索引
        int[] indices = addPermissionList.getSelectedIndices();
     // 获取选项数据的 ListModel
        ListModel<permission> listModel = addPermissionList.getModel();
        List<permission>permissions =new ArrayList<permission>();
        for (int index : indices) {
//        	System.out.println("权限ID = "+listModel.getElementAt(index).getPermissionId() + 
//        			"权限名字 ="+ listModel.getElementAt(index).getPermissionName()+"权限详情 = "+listModel.getElementAt(index).getPermissionExplain());
        	permissions.add(listModel.getElementAt(index));
        }
        int row = this.table.getSelectedRow();//
		String userIdString = (String) this.table.getValueAt(row, 0);
        System.out.println("当前操作的用户Id = "+userIdString);
        Connection connection = null;
        
        try {
			connection = jdbcUtil.getCon();
			int addNums = permissionDao.addCurrentUserPermission(connection,userIdString,permissions);
			if(addNums > 0) {
	        	JOptionPane.showMessageDialog(this, "成功新增权限"+addNums+"条");
	        	tableChoose();
	        }else {
	        	JOptionPane.showMessageDialog(this, "权限新增失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void removeCurrentUserPermission() {
		 // 获取所有被选中的选项索引
        int[] indices = list.getSelectedIndices();
        List<permission>permissions =new ArrayList<permission>();
     // 获取选项数据的 ListModel
        ListModel<permission> listModel = list.getModel();
        // 输出选中的选项
        for (int index : indices) {
        	permissions.add(listModel.getElementAt(index));
        }
        
        int row = this.table.getSelectedRow();//
		String userIdString = (String) this.table.getValueAt(row, 0);
        System.out.println("当前操作的用户Id = "+userIdString);
        
//        int num = JOptionPane.showConfirmDialog(this, "你确定要移除该用户的权限吗");
        Connection connection = null;
        
        try {
			connection = jdbcUtil.getCon();
			int deleteNums = permissionDao.deleteCurrentUserPermission(connection,userIdString,permissions);
			if(deleteNums > 0) {
	        	JOptionPane.showMessageDialog(this, "成功移除权限"+deleteNums+"条");
	        	tableChoose();
	        }else {
	        	JOptionPane.showMessageDialog(this, "权限移除失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void tableChoose() {
		int row = this.table.getSelectedRow();//
		String userIdString = (String) this.table.getValueAt(row, 0);
		System.out.println(userIdString);
		Connection connection = null;
		
		try {
			connection = jdbcUtil.getCon();
			ListModel<permission> listModel = permissionDao.getCurrentUserPermission(connection,userIdString);
			this.list.setModel(listModel);
			
			ListModel<permission> listNotModel = permissionDao.getCurrentUserNotPermission(connection,userIdString);
			this.addPermissionList.setModel(listNotModel);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				jdbcUtil.closeCon(connection);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	private void SearchUser() {
		String userNameString = this.userNameField.getText();
		fillTable(userNameString);
	}

	private void fillTable(String userName) {
		DefaultTableModel dtmModel = (DefaultTableModel) table.getModel();
		dtmModel.setRowCount(0);// 设置总行数为0
		Connection connection = null;

		try {
			connection = jdbcUtil.getCon();
			ResultSet rSet = permissionDao.list(connection, userName);
			while (rSet.next()) {
				Vector vector = new Vector();
				vector.add(rSet.getString("id"));
				vector.add(rSet.getString("userName"));
				vector.add(rSet.getString("nickName"));
				dtmModel.addRow(vector);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				jdbcUtil.closeCon(connection);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
