package com.xinyi.daoManager;



public class Test1 {
	public static void main(String[] args) {
		int i = 1075;
		int i2 = 637;
		int i3 = 1000;
		int i4 = (i2*i3)/i;
		System.out.println(i4);

//		Test1 test1 = new Test1();
//		User user = (User) test1.getInitObject(new User());
	}
	
	
	public <T> Object getInitObject(Object object){
		Class<? extends Object>class1=object.getClass();
		System.out.println(class1.getName());
		return null;
	}
}
