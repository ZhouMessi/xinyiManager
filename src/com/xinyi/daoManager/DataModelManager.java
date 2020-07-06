package com.xinyi.daoManager;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.xinyi.model.User;
import com.xinyi.util.jdbcUtil;

public class DataModelManager {

	private jdbcUtil jdbcUtil = new jdbcUtil();

	public static void main(String[] args) {

		DataModelManager db = new DataModelManager();

//		List<User> users = db.getModel(User.class);
		db.name(User.class);
		
	}

	
	private void name(Class class1) {
			
	}
	
	private <T> List<T> getModel(Class<T> class1) {
		String tableNmae = null;
		List<T> list = new ArrayList<T>();
		Class<T> clazz = class1;
		

		if (clazz.isAnnotationPresent(Table.class)) {

			tableNmae = clazz.getAnnotation(Table.class).TableName();
		}
		// 获取 "属性变量" 上的注解的值
		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {
			if (field.isAnnotationPresent(Parameter.class)) {
				Parameter parameter = field.getAnnotation(Parameter.class);
				System.out.println("当前Model 上具有的参数" + parameter.name());
			}
		}
		Connection connection = null;

		try {
			connection = jdbcUtil.getCon();
			String sql = "select * from " + tableNmae;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
//				<T> t1 =  class1.newInstance(); 
				
			};
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				jdbcUtil.closeCon(connection);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public void name(Object object) {
		
	}
}
