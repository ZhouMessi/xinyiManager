package com.xinyi.common;

import java.io.File;
import java.io.IOException;

public class xinyiConstant {
	public static String[] clientStrings = new String[] { "", "华阳", "多威", "同杰", "外商" };

	// 开发环境下的路径
	public static String getOrdersImagePath() throws IOException {
		return new File(".").getCanonicalPath() + "\\src\\images\\orders";
	}

	// 开发环境下的路径
	public static String getUserImagePath() throws IOException {
		return new File(".").getCanonicalPath() + "\\src\\images\\photo";
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
			System.out.println(new File(".").getCanonicalPath());
			System.out.println(new File(".").getPath());
			System.out.println(new File(".").getAbsolutePath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
