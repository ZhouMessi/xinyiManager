package com.xinyi.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.xinyi.common.xinyiConstant;
import com.xinyi.model.User;
import com.xinyi.permissionManager.DynamicProxyHandler;
import com.xinyi.permissionManager.jumpButton;
import com.xinyi.permissionManager.menuFunction;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;

public class MainFrm extends JFrame {
	private User user;
	private final JSplitPane splitPaneMain = new JSplitPane();
	private JDesktopPane desktopPane = new JDesktopPane();
//	private JDesktopPane desktopPane =  initDePane();
	private JLabel jLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// 设置桌面背景图
	private JDesktopPane initDePane() throws Exception {
		String picPath = MainFrm.class.getResource("/images/panelImg.jpg").getPath();
		final Image image = ImageIO.read(new File(picPath));
		return new JDesktopPane() {
			public void paint(Graphics g) {
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			}
		};

	}

	/**
	 * Create the frame.
	 * 
	 * @throws Exception
	 */
	public MainFrm() throws Exception {
		setBackground(Color.LIGHT_GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrm.class
				.getResource("/images/nextapp_systempanel_ui_homeactivity_24px_1135522_easyicon.net.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		// 设置全屏
//		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		getContentPane().add(splitPaneMain, BorderLayout.CENTER);
		getDesktopPane().setBackground(Color.CYAN);
		splitPaneMain.setRightComponent(getDesktopPane());
		getDesktopPane().setLayout(null);

		JPanel panel = new JPanel();
		splitPaneMain.setLeftComponent(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		JSplitPane splitPane_1 = new JSplitPane();
		// 设置垂直分割
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_1.setOneTouchExpandable(true);

		// 设置分隔条的初始位置
		splitPane_1.setDividerLocation(100);
		// 设置分隔条的大小（宽度）
		splitPane_1.setDividerSize(20);
		panel.add(splitPane_1);

		// 放图片的标签
		jLabel = new JLabel();
		splitPane_1.setLeftComponent(jLabel);
		xuanXiang jPanel2 = new xuanXiang();
		jPanel2.setJf(this);

		// 创建动态代理工具
		DynamicProxyHandler proxyHandler = new DynamicProxyHandler();
		// 创建业务组件
		jumpButton target = jPanel2;
		// 获取代理对象
		jumpButton proxy = (jumpButton) proxyHandler.getJumpProxyInstance(target);
		jPanel2.setJumpButton(proxy);

		splitPane_1.setRightComponent(jPanel2);
		// 分隔条上显示快速 折叠/展开 两边组件的小按钮
		splitPaneMain.setOneTouchExpandable(true);

		// 拖动分隔条时连续重绘组件
		splitPaneMain.setContinuousLayout(true);
		// 设置分隔条的初始位置
		splitPaneMain.setDividerLocation(250);
		// 设置分隔条的大小（宽度）
		splitPaneMain.setDividerSize(20);
		// JMenuBar menuBar = new JMenuBar();
		customCAIDAN caidan = new customCAIDAN();
		caidan.setJf(this);

		menuFunction target2 = caidan;
		// 获取代理对象
		menuFunction proxy2 = (menuFunction) proxyHandler.getMenuProxyInstance(target2);
		caidan.setMenuFunction(proxy2);

		setJMenuBar(caidan);

	}

	public JDesktopPane getDesktopPane() {
		return desktopPane;
	}

	public void setDesktopPane(JDesktopPane desktopPane) {
		this.desktopPane = desktopPane;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
		this.setTitle("当前用户为 : " + user.getUserName());

		try {
			ImageIcon image = new ImageIcon(xinyiConstant.getUserImagePath() + "\\" + user.getPhotoString());
			image.setImage(image.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
			jLabel.setIcon(image);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		jLabel.setText(user.getNickName());
		jLabel.setFont(new Font("幼圆", Font.BOLD, 18));
		jLabel.setForeground(new Color(139, 58, 58));
	}
}
