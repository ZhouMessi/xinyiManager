package com.xinyi.menuView;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.print.DocFlavor.URL;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.LayoutStyle.ComponentPlacement;

import com.xinyi.common.xinyiConstant;
import com.xinyi.dao.UserDao;
import com.xinyi.model.User;
import com.xinyi.util.DateUtil;
import com.xinyi.util.FileUtil;
import com.xinyi.util.MD5Util;
import com.xinyi.util.StringUtil;
import com.xinyi.util.jdbcUtil;
import com.xinyi.view.MainFrm;
import com.xinyi.view.logonPage;
import com.xinyi.view.registerFM;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class editUserInfo extends JInternalFrame {
	private MainFrm mainFrm;
	private int UserID;

	private JTextField nickName;
	private JPasswordField oldPassWord;


	private JPasswordField newPassWord;
	private JLabel photo;
	//新上传的头像路径
	private String photoPath;
	private String oldPhotoPath;
	private String oldPassWordStr;	
	private UserDao userDao = new UserDao();
	private jdbcUtil jdbcUtil = new jdbcUtil();
	
	public String getOldPhotoPath() {
		return oldPhotoPath;
	}

	public void setOldPhotoPath(String oldPhotoPath) {
		this.oldPhotoPath = oldPhotoPath;
	}
	
	public MainFrm getMainFrm() {
		return mainFrm;
	}

	public void setMainFrm(MainFrm mainFrm) {
		this.mainFrm = mainFrm;
	}
	
	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}
	
	public JPasswordField getOldPassWord() {
		return oldPassWord;
	}

	public void setOldPassWord(JPasswordField oldPassWord) {
		this.oldPassWord = oldPassWord;
	}
	
	public String getOldPassWordStr() {
		return oldPassWordStr;
	}

	public void setOldPassWordStr(String oldPassWordStr) {
		this.oldPassWordStr = oldPassWordStr;
	}


	public void setOldPassWord(String oldPassWord) {
		this.oldPassWord.setText(oldPassWord); 
	}

	public JTextField getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName.setText(nickName); 
	}

	public JLabel getPhoto() {
		return photo;
	}

	public void setPhoto(String FileName) {
		ImageIcon image = new ImageIcon(registerFM.class.getResource("/images/photo/"+FileName));
	    image.setImage(image.getImage().getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING));
	    java.net.URL dd = registerFM.class.getResource("/images/photo/"+FileName);
		this.photo.setIcon(image);
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editUserInfo frame = new editUserInfo();
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
	public editUserInfo() {
		setClosable(true);
		setIconifiable(true);
		setTitle("编辑用户信息");
		setFrameIcon(new ImageIcon(editUserInfo.class.getResource("/images/mainFrm/menu/editUserInfo.png")));
		setBounds(100, 100, 594, 424);
		
		JLabel lblNewLabel = new JLabel("昵 称:");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
		
		nickName = new JTextField();
		nickName.setFont(new Font("微软雅黑", Font.BOLD, 16));
		nickName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("旧密码:");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
		
		JLabel lblNewLabel_2 = new JLabel("头 像:");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 16));
		
		photo = new JLabel("");
		
		JButton btnNewButton = new JButton("上传头像");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uploadImage();
			}
		});
		btnNewButton.setIcon(new ImageIcon(editUserInfo.class.getResource("/images/dingDanIFM/upload.png")));
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 16));
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateUserInfo();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(editUserInfo.class.getResource("/images/logonPage/Yes.png")));
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 32));
		
		JButton btnNewButton_2 = new JButton("重置");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(editUserInfo.class.getResource("/images/logonPage/chongzhi.png")));
		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 32));
		
		oldPassWord = new JPasswordField();
		oldPassWord.setFont(new Font("微软雅黑", Font.BOLD, 16));
		
		JLabel lblNewLabel_3 = new JLabel("新密码:");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.BOLD, 16));
		
		newPassWord = new JPasswordField();
		newPassWord.setFont(new Font("微软雅黑", Font.BOLD, 16));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(96)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton_1)
							.addGap(84)
							.addComponent(btnNewButton_2))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_3))
							.addGap(58)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(photo, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addGap(44)
									.addComponent(btnNewButton))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(newPassWord, Alignment.LEADING)
									.addComponent(oldPassWord, Alignment.LEADING)
									.addComponent(nickName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)))))
					.addContainerGap(110, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(nickName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(oldPassWord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(newPassWord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addComponent(btnNewButton))
					.addGap(96)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(188, Short.MAX_VALUE)
					.addComponent(photo, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(106))
		);
		getContentPane().setLayout(groupLayout);

	}

	private void reset() {
		this.nickName.setText("");
		this.oldPassWord.setText("");
		this.newPassWord.setText("");
		this.photoPath = "";
		
		ImageIcon image = new ImageIcon(editUserInfo.class.getResource("/images/upLoadImg.png"));
	    image.setImage(image.getImage().getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING));
		this.photo.setIcon(image);
	}

	private void uploadImage() {
		String fileName = FileUtil.showFileOpenDialog(this);
	    this.photoPath=fileName;
	    System.out.println("photoPath = "+ photoPath);
	    ImageIcon image = new ImageIcon(fileName);
	    image.setImage(image.getImage().getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING));
	    this.photo.setIcon(image);
	}

	private void updateUserInfo() {
		String nickName = this.nickName.getText();
		String oldPassWord = new String(this.oldPassWord.getPassword());
		String newPassWord = new String(this.newPassWord.getPassword());
		String photoPath = this.photoPath;
		//新上传的图片的名字
		String PhotoFileName = "photo"+ DateUtil.getFileName()+".jpg";
		
		if(StringUtil.isEmpty(nickName)) {
			JOptionPane.showMessageDialog(this, "昵称不能为空!");
			return;
		}
		
		if(StringUtil.isEmpty(oldPassWord)) {
			JOptionPane.showMessageDialog(this, "旧密码不能为空!");
			return;
		}
		
		if(StringUtil.isEmpty(newPassWord)) {
			JOptionPane.showMessageDialog(this, "新密码不能为空!");
			return;
		}
		
		if(StringUtil.isEmpty(photoPath)) {
			JOptionPane.showMessageDialog(this, "头像不能为空!");
			return;
		}
		
		if(!MD5Util.getMD5(oldPassWord).equals(oldPassWordStr) ) {
			JOptionPane.showMessageDialog(this, "您输入的旧密码与原始密码不同,请重新输入");
			reset();
			return;
		}

		Connection connection = null;
		try {
			connection = jdbcUtil.getCon();
			User user = new User(UserID, nickName, newPassWord, PhotoFileName);
			//把图片重新上传到指定文件夹,包括老图片
			FileUtil.copy(this, photoPath, xinyiConstant.getUserImagePath()+"\\"+PhotoFileName);
			Boolean isDelete = FileUtil.deleteOldImg(this.oldPhotoPath);
			if(isDelete) {
				System.out.println("老图片"+oldPhotoPath+"  删除成功");
			}else {
				System.out.println("老图片"+oldPhotoPath+"  删除失败");
			}
			int updateNums = userDao.updateUserInfo(connection,user);
			if(updateNums == 1) {
				JOptionPane.showMessageDialog(this, "当前用户信息修改成功 请重新登录");
				this.mainFrm.dispose();
				logonPage logonPage = new logonPage();
				logonPage.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(this, "当前用户信息修改失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
