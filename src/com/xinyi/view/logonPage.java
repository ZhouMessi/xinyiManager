package com.xinyi.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import com.xinyi.dao.UserDao;
import com.xinyi.model.User;
import com.xinyi.util.MD5Util;
import com.xinyi.util.StringUtil;
import com.xinyi.util.jdbcUtil;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class logonPage extends JFrame {

	private JPanel contentPane;
	private JTextField userNameField;
	private JPasswordField passWordField;
	
	private jdbcUtil jdbcUtil = new jdbcUtil();
	private UserDao userDao = new UserDao();
	
                           
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");	
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			BeautyEyeLNFHelper.translucencyAtFrameInactive = false;
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logonPage frame = new logonPage();
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
	public logonPage() {
		setResizable(false);
		setTitle("管理员登录");
		setIconImage(Toolkit.getDefaultToolkit().getImage(logonPage.class.getResource("/images/nextapp_systempanel_ui_homeactivity_24px_1135522_easyicon.net.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 525);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("鑫亿发鞋材信息管理系统");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("幼圆", Font.BOLD, 45));
		
		JLabel userName = new JLabel("用户名:");
		userName.setIcon(new ImageIcon(logonPage.class.getResource("/images/logonPage/userName.png")));
		userName.setForeground(new Color(0, 0, 255));
		userName.setFont(new Font("宋体", Font.BOLD, 24));
		
		JLabel passWord = new JLabel("密  码:");
		passWord.setIcon(new ImageIcon(logonPage.class.getResource("/images/logonPage/passWord.png")));
		passWord.setForeground(new Color(0, 0, 255)); 
		passWord.setFont(new Font("宋体", Font.BOLD, 24));
		
		userNameField = new JTextField();
		userNameField.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		userNameField.setColumns(10);
		
		passWordField = new JPasswordField();
		//监控输入回车登录
		passWordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER) {
//					Login();
					Login2();
				}
			}
		});
		passWordField.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		
		JButton btnNewButton = new JButton("登录");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login2();
//				Login();
			}
		});
		btnNewButton.setIcon(new ImageIcon(logonPage.class.getResource("/images/logonPage/denglu2.png")));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 24));
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(logonPage.class.getResource("/images/logonPage/chongzhi.png")));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 24));
		
		JButton btnNewButton_2 = new JButton("注册");
		btnNewButton_2.setIcon(new ImageIcon(logonPage.class.getResource("/images/logonPage/register.png")));
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBackground(new Color(0, 0, 0));
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 24));
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(45)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(104)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnNewButton)
									.addGap(33)
									.addComponent(btnNewButton_2)
									.addGap(32)
									.addComponent(btnNewButton_1))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(userName)
										.addGap(18)
										.addComponent(userNameField, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(passWord)
										.addGap(18)
										.addComponent(passWordField))))))
					.addContainerGap(102, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(96)
					.addComponent(lblNewLabel)
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(userName)
						.addComponent(userNameField, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passWord)
						.addComponent(passWordField, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_2))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		//设置居中对齐
		this.setLocationRelativeTo(null);
		
		
	}

	private void register() {
			dispose();
			registerFM registerFM = new registerFM();
			registerFM.setVisible(true);
	}

	//登录
	private void Login() {
		// TODO Auto-generated method stub
		String userNameString = this.userNameField.getText();
		String passWordString = new String(this.passWordField.getPassword());
		
		if(StringUtil.isEmpty(userNameString)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空!");
			return;
		}
		if(StringUtil.isEmpty(passWordString)) {
			JOptionPane.showMessageDialog(null, "密码不能为空!");
			return;
		}
		
		User user = new User(userNameString,MD5Util.getMD5(passWordString));
		Connection connection = null;
		try {
			connection = jdbcUtil.getCon();
			User currentUser = userDao.login(connection, user);
			if(currentUser != null) {
				dispose();
				MainFrm mainFrm = new MainFrm();
				mainFrm.setUser(currentUser);
				mainFrm.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "用户名或者密码错误!");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				jdbcUtil.closeCon(connection);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
		//登录
		private void Login2() {
			// TODO Auto-generated method stub
			String userNameString = "admin";
			String passWordString = "1";
			
			if(StringUtil.isEmpty(userNameString)) {
				JOptionPane.showMessageDialog(null, "用户名不能为空!");
				return;
			}
			if(StringUtil.isEmpty(passWordString)) {
				JOptionPane.showMessageDialog(null, "密码不能为空!");
				return;
			}
			
			User user = new User(userNameString,MD5Util.getMD5(passWordString));
			Connection connection = null;
			try {
				connection = jdbcUtil.getCon();
				User currentUser = userDao.login(connection, user);
				if(currentUser != null) {                                                                                                                            
					dispose();
					MainFrm mainFrm = new MainFrm();
					mainFrm.setUser(currentUser);
					mainFrm.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "用户名或者密码错误!");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					jdbcUtil.closeCon(connection);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}

	//重置
	private void reset() {
		// TODO Auto-generated method stub
		this.userNameField.setText("");
		this.passWordField.setText("");
	}
}
