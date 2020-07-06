package com.xinyi.view.dingdanIFM;

import javax.swing.JPanel;

import com.xinyi.common.imagePX;
import com.xinyi.common.xinyiConstant;
import com.xinyi.util.DoubleUtil;
import com.xinyi.view.MainFrm;

import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class orderDetailTop2 extends JPanel {

	private JLabel imageJLabel;
	/**
	 * Create the panel.
	 */
	public orderDetailTop2() {
		setBounds(0, 0, 1000, 1000);
		imageJLabel = new JLabel("");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(imageJLabel, GroupLayout.PREFERRED_SIZE, 1000, GroupLayout.PREFERRED_SIZE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(imageJLabel, GroupLayout.PREFERRED_SIZE, 1000, GroupLayout.PREFERRED_SIZE)
		);
		setLayout(groupLayout);
	}
	public JLabel getImageJLabel() {
		return imageJLabel;
	}
	public void setImageJLabel(String ImageName) throws IOException {
//		ImageIcon image = new ImageIcon(orderDetailTop2.class.getResource("/images/"+"Snipaste_2020-02-01_15-06-07.jpg"));
		ImageIcon image = new ImageIcon(xinyiConstant.getOrdersImagePath()+"\\"+ImageName);
		System.out.println("图片宽 :"+image.getIconWidth() + "图片高 :"+image.getIconHeight());
		imagePX imagePX = getNeedPX(image);
		System.out.println("imagePx width = "+imagePX.getImgWide() + "imagePx Height = "+imagePX.getImgHigh());
		image.setImage(image.getImage().getScaledInstance(imagePX.getImgWide(), imagePX.getImgHigh(), Image.SCALE_AREA_AVERAGING));
		this.imageJLabel.setIcon(image);
	}
	private imagePX getNeedPX(ImageIcon image) {
		//获取当前图片的宽高比
		double d = DoubleUtil.divide(new Double(image.getIconWidth()), new Double(image.getIconHeight()));
		System.out.println("当前图片的宽高比例为 :"+d);
		if(d>=1d) {
			 return new imagePX(1000, (1000*image.getIconHeight())/image.getIconWidth());
		}else {
			return new imagePX((900*image.getIconWidth())/image.getIconHeight(), 900);
		}
	}

}
