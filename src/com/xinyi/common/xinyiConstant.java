package com.xinyi.common;

import java.io.File;
import java.io.IOException;

public class xinyiConstant {
	public static String[] clientStrings = new String[] { "", "华阳", "多威", "同杰", "外商" ,"睿登","和捷","同飞","航通","其他"};

	// 开发环境下的路径
	public static String getOrdersImagePath() throws IOException {
		return new File(".").getCanonicalPath() + "\\src\\images\\orders";
	}

	// 开发环境下的路径
	public static String getUserImagePath() throws IOException {
		return new File(".").getCanonicalPath() + "\\src\\images\\photo";
	}
	
	// 开发环境下的路径
	public static String getDeliverySlipPath() throws IOException {
		return new File(".").getCanonicalPath() + "\\src\\images\\deliverySlip";
	}

	// 使用环境下的路径
//	public static String getOrdersImagePath() throws IOException {
//		return new File(".").getCanonicalPath() + "\\images\\orders";
//	}

	// 使用环境下的路径
//	public static String getUserImagePath() throws IOException {
//		return new File(".").getCanonicalPath() + "\\images\\photo";
//	}

	public static void main(String[] args) {
		try {
			System.out.println(xinyiConstant.getUserImagePath());
			System.out.println(new File(".").getCanonicalPath());
			System.out.println(new File(".").getPath());
			System.out.println(new File(".").getAbsolutePath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
