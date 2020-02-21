package com.xinyi.permissionManager;

import java.awt.Component;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.swing.JOptionPane;

public class DynamicProxyHandler {

	// 声明被代理对象
	private Object target;
	// 创建拦截器
	permissionInterceptor interceptor = new permissionInterceptor();

	// 动态生成一个代理对象,并绑定代理类和代理处理器
	public Object getJumpProxyInstance(final Object target) {
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
				new InvocationHandler() {

					// 参数 1：proxy 生成的代理对象，不建议直接在方法中调用这个对象，不然会出现递归。
					// 参数 2：真实对象的方法
					// 参数 3： 代理对象调用这个方法时传递的参数
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						boolean isPass = interceptor.jumpBefore(target, method);
						Object result = null;
						if (isPass) {
							result = method.invoke(target, args);
						} else {
							JOptionPane.showMessageDialog((Component) target, "当前用户没有此权限");
						}
						interceptor.after(proxy);
						return result;
					}
				});
	}

	// 动态生成一个代理对象,并绑定代理类和代理处理器
	public Object getMenuProxyInstance(final Object target) {
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
				new InvocationHandler() {

					// 参数 1：proxy 生成的代理对象，不建议直接在方法中调用这个对象，不然会出现递归。
					// 参数 2：真实对象的方法
					// 参数 3： 代理对象调用这个方法时传递的参数
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						boolean isPass = interceptor.menuBefore(target, method);
						Object result = null;
						if (isPass) {
							result = method.invoke(target, args);
						} else {
							JOptionPane.showMessageDialog((Component) target, "当前用户没有此权限");
						}
						interceptor.after(proxy);
						return result;
					}
				});
	}
}
