package com.xinyi.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.xinyi.common.xinyiConstant;
import com.xinyi.dao.UserDao;
import com.xinyi.model.User;
import com.xinyi.util.DateUtil;
import com.xinyi.util.FileUtil;
import com.xinyi.util.StringUtil;
import com.xinyi.util.jdbcUtil;

import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class registerFM extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	private JPasswordField passWord;
	
	private UserDao userDao = new UserDao();
	private jdbcUtil jdbcUtil = new jdbcUtil();
	private JTextField nickName;
	private JLabel photo;
	private String phtotString;//图片路径

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registerFM frame = new registerFM();
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
	public registerFM() {
		setFont(new Font("Dialog", Font.BOLD, 14));
		setIconImage(Toolkit.getDefaultToolkit().getImage(registerFM.class.getResource("/images/logonPage/register.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel userNameTxt = new JLabel("用户名 :");
		userNameTxt.setFont(new Font("微软雅黑", Font.BOLD, 32));
		userNameTxt.setIcon(new ImageIcon(registerFM.class.getResource("/images/logonPage/userName.png")));
		
		userName = new JTextField();
		userName.setFont(new Font("微软雅黑", Font.BOLD, 32));
		userName.setColumns(10);
		
		JLabel passWordTxt = new JLabel("密 码:");
		passWordTxt.setFont(new Font("微软雅黑", Font.BOLD, 32));
		passWordTxt.setIcon(new ImageIcon(registerFM.class.getResource("/images/logonPage/passWord.png")));
		
		passWord = new JPasswordField();
		passWord.setFont(new Font("微软雅黑", Font.BOLD, 32));
		
		JButton btnNewButton_1 = new JButton("注册");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(registerFM.class.getResource("/images/logonPage/register.png")));
		btnNewButton_1.setFont(new Font("微软雅黑", Font.BOLD, 32));
		
		JButton btnNewButton_2 = new JButton("重置");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnNewButton_2.setFont(new Font("微软雅黑", Font.BOLD, 32));
		btnNewButton_2.setIcon(new ImageIcon(registerFM.class.getResource("/images/logonPage/chongzhi.png")));
		
		JLabel lblNewLabel = new JLabel("昵 称:");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 32));
		lblNewLabel.setIcon(new ImageIcon(registerFM.class.getResource("/images/logonPage/nickName.png")));
		
		nickName = new JTextField();
		nickName.setFont(new Font("微软雅黑", Font.BOLD, 32));
		nickName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("头 像:");
		lblNewLabel_1.setIcon(new ImageIcon(registerFM.class.getResource("/images/logonPage/photo.png")));
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 32));
		
		photo = new JLabel();
		ImageIcon image = new ImageIcon(registerFM.class.getResource("/images/upLoadImg.png"));
	    image.setImage(image.getImage().getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING));
		photo.setIcon(image);
		photo.setBackground(Color.CYAN);
		photo.setForeground(Color.CYAN);

		
		JButton btnNewButton = new JButton("上传图片");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uploadImage();
			}
		});
		btnNewButton.setIcon(new ImageIcon(registerFM.class.getResource("/images/dingDanIFM/upload.png")));
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(58)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(userNameTxt)
								.addComponent(passWordTxt)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1))
							.addGap(38)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(photo, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnNewButton))
								.addComponent(nickName, 0, 0, Short.MAX_VALUE)
								.addComponent(passWord)
								.addComponent(userName, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(114)
							.addComponent(btnNewButton_1)
							.addGap(72)
							.addComponent(btnNewButton_2)))
					.addGap(135))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(userNameTxt)
						.addComponent(userName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passWordTxt)
						.addComponent(passWord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(nickName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(38)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(photo, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(43)
							.addComponent(btnNewButton)))
					.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		//设置居中对齐
				this.setLocationRelativeTo(null);
	}

	private void uploadImage() {
		String fileName = FileUtil.showFileOpenDialog(this);
	    this.phtotString=fileName;
	    System.out.println(phtotString);
	    ImageIcon image = new ImageIcon(fileName);
	    image.setImage(image.getImage().getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING));
	    this.photo.setIcon(image);
	}

	//注册新用户
	private void register() {
		String userName = this.userName.getText();
		String passWord = new String(this.passWord.getPassword());
		String nickName = this.nickName.getText();
		String photoPath = this.phtotString;	
		String phtotFileName = "photo"+ DateUtil.getFileName()+".jpg";
		if(StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(this, "用户名不能为空!");
			return;
		}
		
		if(StringUtil.isEmpty(passWord)) {
			JOptionPane.showMessageDialog(this, "密码不能为空!");
			return;
		}
		
		if(StringUtil.isEmpty(nickName)) {
			JOptionPane.showMessageDialog(this, "昵称不能为空!");
			return;
		}
		
		if(StringUtil.isEmpty(photoPath)) {
			JOptionPane.showMessageDialog(this, "头像不能为空!");
			return;
		}
		Connection connection = null;
		try {
			connection = jdbcUtil.getCon();
			int userNums = userDao.checkUserName(connection,userName);
			System.out.println(userNums);
			if(userNums ==1) {
				JOptionPane.showMessageDialog(this, "当前用户已存在,请重新输入用户名");
				this.userName.setText("");
			}else {
				User user = new User( userName, nickName, passWord, phtotFileName);
				FileUtil.copy(this, photoPath, xinyiConstant.getUserImagePath()+"\\"+phtotFileName);
				int addNum = userDao.saveUser(connection,user);
				if(addNum == 1) {
					JOptionPane.showMessageDialog(this, "新增用户成功");
					dispose();
					logonPage logonPage = new logonPage();
					logonPage.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(this, "新增用户失败");
					reset();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				jdbcUtil.closeCon(connection);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}

	private void reset() {
		this.userName.setText("");
		this.passWord.setText("");
		this.nickName.setText("");
		ImageIcon image = new ImageIcon(registerFM.class.getResource("/images/upLoadImg.png"));
	    image.setImage(image.getImage().getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING));
		this.photo.setIcon(image);
		this.phtotString = "";
	}
	
}
