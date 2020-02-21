package com.xinyi.view.dingdanIFM;

import javax.swing.JPanel;

import com.xinyi.common.xinyiConstant;
import com.xinyi.view.MainFrm;

import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class orderDetailTop2 extends JPanel {

	private JLabel imageJLabel;
	/**
	 * Create the panel.
	 */
	public orderDetailTop2() {
		setBounds(0, 0, 1075, 637);
		setLayout(new BorderLayout(0, 0));	
		imageJLabel = new JLabel("");
		add(imageJLabel, BorderLayout.WEST);
	}
	public JLabel getImageJLabel() {
		return imageJLabel;
	}
	public void setImageJLabel(String ImageName) throws IOException {
//		ImageIcon image = new ImageIcon(orderDetailTop2.class.getResource("/images/"+"Snipaste_2020-02-01_15-06-07.jpg"));
		ImageIcon image = new ImageIcon(xinyiConstant.getOrdersImagePath()+"\\"+ImageName);
		image.setImage(image.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_AREA_AVERAGING));
		this.imageJLabel.setIcon(image);
	}

}
