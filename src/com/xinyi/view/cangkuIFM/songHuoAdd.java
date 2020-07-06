package com.xinyi.view.cangkuIFM;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableCellRenderer;

import com.xinyi.common.xinyiConstant;
import com.xinyi.dao.orderDao;
import com.xinyi.dao.songHuoDao;
import com.xinyi.model.deliveryCharge;
import com.xinyi.model.songHuo;
import com.xinyi.util.DateChooser;
import com.xinyi.util.DateUtil;
import com.xinyi.util.FileUtil;
import com.xinyi.util.StringUtil;
import com.xinyi.util.jdbcUtil;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class songHuoAdd extends JInternalFrame {
	private JComboBox clientBox;
	private DateChooser songHuoTime;
	private JLabel driver;
	private JTextField siji;
	private JTextField oddNums;
	private JTextField guiGeNums;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField totalPagNums;
	private JTextField totalCounts;
	
	private JLabel image;
	private JTextField fileName;
	private JButton save;
	private JLabel lblNewLabel_6;
	private JTextField reMark;
	
	private songHuoDao songhuoDao = new songHuoDao();
	private jdbcUtil jdbcUtil = new jdbcUtil();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					songHuoAdd frame = new songHuoAdd();
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
	public songHuoAdd() {
		setClosable(true);
		setIconifiable(true);
		setTitle("送货单新增");
		setFrameIcon(new ImageIcon(songHuoAdd.class.getResource("/images/xuanxiang/songHuo.png")));
		setBounds(100, 100, 919, 793);
		
		JLabel lblNewLabel = new JLabel("客户:");
		lblNewLabel.setFont(new Font("幼圆", Font.BOLD, 16));
		
		//送货单
		clientBox = new JComboBox();
		clientBox.setFont(new Font("幼圆", Font.BOLD, 16));
		clientBox.setModel(new DefaultComboBoxModel(xinyiConstant.clientStrings));
		
		JLabel lblNewLabel_1 = new JLabel("送货时间:");
		lblNewLabel_1.setFont(new Font("幼圆", Font.BOLD, 16));
		songHuoTime = new DateChooser("yyyy/MM/dd");
		
		driver = new JLabel("司机:");
		driver.setFont(new Font("幼圆", Font.BOLD, 16));
		
		siji = new JTextField();
		siji.setFont(new Font("幼圆", Font.BOLD, 16));
		siji.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("单号:");
		lblNewLabel_2.setFont(new Font("幼圆", Font.BOLD, 16));
		
		oddNums = new JTextField();
		oddNums.setFont(new Font("幼圆", Font.BOLD, 16));
		oddNums.setColumns(10);
		
		JButton btnNewButton = new JButton("生成规格");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createSpecification();
			}
		});
		btnNewButton.setIcon(new ImageIcon(songHuoAdd.class.getResource("/images/cangKuManager/SCGG.png")));
		btnNewButton.setFont(new Font("幼圆", Font.BOLD, 16));
		
		guiGeNums = new JTextField();
		guiGeNums.setFont(new Font("幼圆", Font.BOLD, 16));
		guiGeNums.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("规格批次");
		lblNewLabel_3.setFont(new Font("幼圆", Font.BOLD, 16));
		
		scrollPane = new JScrollPane();
		
		JLabel lblNewLabel_4 = new JLabel("总件数:");
		lblNewLabel_4.setFont(new Font("幼圆", Font.BOLD, 16));
		
		totalPagNums = new JTextField();
		totalPagNums.setFont(new Font("幼圆", Font.BOLD, 16));
		totalPagNums.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("总双数:");
		lblNewLabel_5.setFont(new Font("幼圆", Font.BOLD, 16));
		
		totalCounts = new JTextField();
		totalCounts.setFont(new Font("幼圆", Font.BOLD, 16));
		totalCounts.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("上传图片");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uploadFile();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(songHuoAdd.class.getResource("/images/dingDanIFM/upload.png")));
		btnNewButton_1.setFont(new Font("幼圆", Font.BOLD, 16));
		
		image = new JLabel("");

		
		fileName = new JTextField();
		fileName.setFont(new Font("幼圆", Font.BOLD, 16));
		fileName.setColumns(10);
		
		save = new JButton("保存送货单");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		save.setIcon(new ImageIcon(songHuoAdd.class.getResource("/images/mainFrm/menu/order_add.png")));
		save.setFont(new Font("幼圆", Font.BOLD, 16));
		
		lblNewLabel_6 = new JLabel("图片路径:");
		lblNewLabel_6.setFont(new Font("幼圆", Font.BOLD, 14));
		
		reMark = new JTextField();
		reMark.setFont(new Font("幼圆", Font.BOLD, 16));
		reMark.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("备注:");
		lblNewLabel_7.setFont(new Font("幼圆", Font.BOLD, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_1)
								.addComponent(save))
							.addGap(47)
							.addComponent(image, GroupLayout.PREFERRED_SIZE, 429, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton)
									.addGap(18)
									.addComponent(guiGeNums, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNewLabel_4))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(18)
									.addComponent(clientBox, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(songHuoTime, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
									.addGap(26)
									.addComponent(driver)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(siji, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(oddNums, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(totalPagNums, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_5)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(totalCounts))))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_6)
								.addComponent(lblNewLabel_7))
							.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(reMark)
								.addComponent(fileName, GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)))
						.addComponent(scrollPane))
					.addContainerGap(160, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(57)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel)
							.addComponent(clientBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(songHuoTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(oddNums, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_2)
									.addComponent(siji, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(driver)))
							.addGap(1)))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(guiGeNums, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_4)
						.addComponent(totalPagNums, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5)
						.addComponent(totalCounts, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(54)
							.addComponent(btnNewButton_1)
							.addGap(24)
							.addComponent(save))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(image, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(fileName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(reMark, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_7))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u989C\u8272\u89C4\u683C", "36#", "37#", "38#", "39#", "40#", "41#", "42#", "43#", "44#", "45#", "46#"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
		table.getColumnModel().getColumn(6).setPreferredWidth(50);
		table.getColumnModel().getColumn(7).setPreferredWidth(50);
		table.getColumnModel().getColumn(8).setPreferredWidth(50);
		table.getColumnModel().getColumn(9).setPreferredWidth(50);
		table.getColumnModel().getColumn(10).setPreferredWidth(50);
		table.getColumnModel().getColumn(11).setPreferredWidth(50);
		scrollPane.setViewportView(table);
		
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
		getContentPane().setLayout(groupLayout);

	}
	
	//保存
	private void save() {
		if(StringUtil.isEmpty(this.guiGeNums.getText()) || Integer.valueOf(this.guiGeNums.getText()) <= 0 ) {
			JOptionPane.showMessageDialog(null, "请填写规格！！！");
			return;
		}
		// 规格
		List<deliveryCharge> dList = new ArrayList<deliveryCharge>();
		for (int i = 0; i < Integer.valueOf(this.guiGeNums.getText()); i++) {
			deliveryCharge deliveryCharge = new deliveryCharge();
			deliveryCharge.setColorRule((String)table.getValueAt(i, 0));//规格,颜色
			deliveryCharge.setThirty_six((int)table.getValueAt(i, 1));//36
			deliveryCharge.setThirty_seven((int)table.getValueAt(i, 2));//37
			deliveryCharge.setThirty_eight((int)table.getValueAt(i, 3));//38
			deliveryCharge.setThirty_nine((int)table.getValueAt(i, 4));//39
			deliveryCharge.setForty((int)table.getValueAt(i, 5));//40
			deliveryCharge.setForty_one((int)table.getValueAt(i, 6));//41
			deliveryCharge.setForty_two((int)table.getValueAt(i, 7));//42
			deliveryCharge.setForty_three((int)table.getValueAt(i, 8));//43
			deliveryCharge.setForty_four((int)table.getValueAt(i, 9));//44
			deliveryCharge.setForty_five((int)table.getValueAt(i, 10));//45
			deliveryCharge.setForty_six((int)table.getValueAt(i, 11));//46
			
			dList.add(deliveryCharge);
		}
		System.out.println(dList.toString());
		
		//文件名
		String imgPath = DateUtil.getFileName()+".jpg";
		//UUID
		String uuid = UUID.randomUUID().toString();
		//客户
		String clientName = (String)this.clientBox.getSelectedItem();
		System.out.println("客户 : "+clientName);
		//送货时间
		Date songhuoTime =  this.songHuoTime.getSelect().getTime();
		System.out.println("送货时间 :"+songhuoTime);
		//司机
		String driverString  = this.siji.getText();
		System.out.println("司机 :"+driverString);
		//单号
		String oddNums  = this.oddNums.getText();
		System.out.println("单号 :"+oddNums);
		//总件数
		String totalPagNums  = this.totalPagNums.getText();
		System.out.println("总件数 :"+totalPagNums);
		//总双数
		String totalCounts  = this.totalCounts.getText();
		System.out.println("总双数 :"+totalCounts);	
		//备注
		String reMark  = this.reMark.getText();
		System.out.println("备注 :"+reMark);	
		//图片路径
		String fileName  = this.fileName.getText();
		System.out.println("图片路径 :"+fileName);
		//图片检验
		if(StringUtil.isEmpty(fileName)) {
			JOptionPane.showMessageDialog(null, "请上传图片！！！");
			return;
		}
		try {
			FileUtil.copy(this, fileName, xinyiConstant.getDeliverySlipPath()+"\\"+imgPath);
		} catch (IOException e1) {	
		 JOptionPane.showMessageDialog(null, "图片存储异常");
		}
		songHuo songHuo = new songHuo(clientName,songhuoTime,driverString,oddNums,totalPagNums,totalCounts,reMark,imgPath,uuid);
		Connection connection = null;
		try {
			connection = jdbcUtil.getCon();
		    int updateNum = songhuoDao.add(connection,songHuo);
		    if(updateNum == 1) {
		    	JOptionPane.showMessageDialog(null, "新增订单成功");
//		    	resetValues();
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
		
	}

	
	//上传图片
	private void uploadFile() {
		String fileName = FileUtil.showFileOpenDialog(this);
	    this.fileName.setText(fileName);
	    ImageIcon image = new ImageIcon(fileName);
	    image.setImage(image.getImage().getScaledInstance(this.image.getWidth(), this.image.getHeight(), Image.SCALE_AREA_AVERAGING));
	    this.image.setIcon(image);		
	}

	//生成规格          
	private void createSpecification() {
		if(StringUtil.isEmpty(this.guiGeNums.getText())) {
			JOptionPane.showMessageDialog(null, "请输入规格数量");
			return;
		}
		int guigeNums = Integer.valueOf(this.guiGeNums.getText());
		JOptionPane.showMessageDialog(null, guigeNums);
		
		deliveryCharge deliveryCharge = new deliveryCharge();
		
		DefaultTableModel dtmModel = (DefaultTableModel) table.getModel();
		dtmModel.setRowCount(0);//设置总行数为0
		for (int i = 0; i < guigeNums; i++) {
			Vector  vector =new Vector();
			vector.add(deliveryCharge.getColorRule());
			vector.add(deliveryCharge.getThirty_six());
			vector.add(deliveryCharge.getThirty_seven());
			vector.add(deliveryCharge.getThirty_eight());
			vector.add(deliveryCharge.getThirty_nine());
			vector.add(deliveryCharge.getForty());
			vector.add(deliveryCharge.getForty_one());
			vector.add(deliveryCharge.getForty_two());
			vector.add(deliveryCharge.getForty_three());
			vector.add(deliveryCharge.getForty_four());
			vector.add(deliveryCharge.getForty_five());
			vector.add(deliveryCharge.getForty_six());
			dtmModel.addRow(vector);
		}
		
		
		
	}
}
