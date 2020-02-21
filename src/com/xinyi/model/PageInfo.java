package com.xinyi.model;

import java.sql.ResultSet;

public class PageInfo {

	private ResultSet resultSet;//结果集
	
	private int totalPage;//总页数
	
	private int totalRows;//总条数
	

	public PageInfo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PageInfo(ResultSet resultSet, int totalPage, int totalRows) {
		super();
		this.resultSet = resultSet;
		this.totalPage = totalPage;
		this.totalRows = totalRows;
	}


	public ResultSet getResultSet() {
		return resultSet;
	}


	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}


	public int getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	public int getTotalRows() {
		return totalRows;
	}


	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	
	
	
}
