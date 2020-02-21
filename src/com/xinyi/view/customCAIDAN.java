package com.xinyi.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.UIManager;

import com.xinyi.common.xinyiConstant;
import com.xinyi.menuView.permissionSet;

public class customCAIDAN extends JMenuBar {
	private MainFrm jf;
	
	public customCAIDAN() {
		JMenu menu = new JMenu("订单");
		menu.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		menu.setIcon(new ImageIcon(customCAIDAN.class.getResource("/images/mainFrm/menu/order.png")));
		add(menu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("订单录入");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
			
		mntmNewMenuItem.setForeground(UIManager.getColor("Menu.foreground"));
		mntmNewMenuItem.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		mntmNewMenuItem.setIcon(new ImageIcon(customCAIDAN.class.getResource("/images/mainFrm/menu/order_add.png")));
		menu.add(mntmNewMenuItem);
		
		
		JMenu mnNewMenu = new JMenu("用户设置");
		mnNewMenu.setIcon(new ImageIcon(customCAIDAN.class.getResource("/images/mainFrm/menu/userInfo.png")));
		mnNewMenu.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		
		JMenuItem editUserInfo = new JMenuItem("修改信息");
		editUserInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editUserInfo();
			}
		});
			
		editUserInfo.setForeground(UIManager.getColor("Menu.foreground"));
		editUserInfo.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		editUserInfo.setIcon(new ImageIcon(customCAIDAN.class.getResource("/images/mainFrm/menu/editUserInfo.png")));
		mnNewMenu.add(editUserInfo);
		
		add(mnNewMenu);
		
		
		JMenu systemMenu = new JMenu("权限管理");
		systemMenu.setIcon(new ImageIcon(customCAIDAN.class.getResource("/images/mainFrm/menu/systemSet.png")));
		systemMenu.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		
		JMenuItem permissionSet = new JMenuItem("分配权限");
		permissionSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				permissionSet();
			}
		});
			
		permissionSet.setForeground(UIManager.getColor("Menu.foreground"));
		permissionSet.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		permissionSet.setIcon(new ImageIcon(customCAIDAN.class.getResource("/images/mainFrm/menu/permission.png")));
		systemMenu.add(permissionSet);
		
		add(systemMenu);
	}

	//分配权限
	private void permissionSet() {
		com.xinyi.menuView.permissionSet permissionSet = new permissionSet();
		permissionSet.setVisible(true);
		this.jf.getDesktopPane().add(permissionSet);
	}

	private void editUserInfo()  {
		com.xinyi.menuView.editUserInfo editUserInfo= new com.xinyi.menuView.editUserInfo();
		editUserInfo.setTitle("当前修改的用户为 :"+this.jf.getUser().getUserName());
		editUserInfo.setNickName(this.jf.getUser().getNickName());
		editUserInfo.setOldPassWordStr(this.jf.getUser().getPassWord());
		editUserInfo.setPhoto(this.jf.getUser().getPhotoString());
		editUserInfo.setUserID(this.jf.getUser().getId());
		editUserInfo.setMainFrm(jf);
		try {
			//把老图片放在新的图片路径
			editUserInfo.setPhotoPath(xinyiConstant.getUserImagePath()+"\\"+this.jf.getUser().getPhotoString());
			//把老图片放在旧的图片路径以便于删除
			editUserInfo.setOldPhotoPath(xinyiConstant.getUserImagePath()+"\\"+this.jf.getUser().getPhotoString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		editUserInfo.setVisible(true);
		
		jf.getDesktopPane().add(editUserInfo);
	}

	public MainFrm getJf() {
		return jf;
	}

	public void setJf(MainFrm jf) {
		this.jf = jf;
	}
	
	
}
