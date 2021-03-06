package com.xinyi.permissionManager;

import java.lang.reflect.Method;
import java.util.List;

import com.xinyi.util.jdbcUtil;
import com.xinyi.view.customCAIDAN;
import com.xinyi.view.dingDanIFM;
import com.xinyi.view.xuanXiang;

public class permissionInterceptor {
	
	public boolean jumpBefore(Object traget, Method currentMethod) {
		NoLogin noLoginAnnotation = null;
		xuanXiang xuanXiang = (xuanXiang) traget;
		Class clazz = traget.getClass();
		boolean isPass = false;
		// 获取 "方法"上的注解的值 并且是此次访问的方法上的
		Method[] methods = clazz.getDeclaredMethods();
		// 获取当前访问的方法上的注解的值
		for (Method method : methods) {
			if (method.isAnnotationPresent(NoLogin.class) && method.getName() == currentMethod.getName()) {
				noLoginAnnotation = method.getAnnotation(NoLogin.class);
				System.out.println("当前访问的方法上的注解为:" + noLoginAnnotation.value());
			}
		}
		List<String>pList = jdbcUtil.getCurrentPermissionS(xuanXiang.getJf().getUser().getId());
		for (String permission : pList) {
			if (permission.equals(noLoginAnnotation.value())) {
				isPass = true;
			}
		};
		return isPass;
	}

	public boolean menuBefore(Object traget, Method currentMethod) {
		NoLogin noLoginAnnotation = null;
		customCAIDAN customCAIDAN = (customCAIDAN) traget;
		Class clazz = traget.getClass();
		boolean isPass = false;
		// 获取 "方法"上的注解的值 并且是此次访问的方法上的
		Method[] methods = clazz.getDeclaredMethods();
		// 获取当前访问的方法上的注解的值
		for (Method method : methods) {
			if (method.isAnnotationPresent(NoLogin.class) && method.getName() == currentMethod.getName()) {
				noLoginAnnotation = method.getAnnotation(NoLogin.class);
				System.out.println("当前访问的方法上的注解为:" + noLoginAnnotation.value());
			}
		}
		List<String>pList = jdbcUtil.getCurrentPermissionS(customCAIDAN.getJf().getUser().getId());
		for (String permission : pList) {
			if (permission.equals(noLoginAnnotation.value())) {
				isPass = true;
			}
		};
		return isPass;
	}

	public void after(Object traget) {
		System.out.println("在InterceptorClass中调用方法：after()");
	}
}
