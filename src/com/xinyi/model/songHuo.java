package com.xinyi.model;

import java.util.Date;

public class songHuo {
	private String clientName;//客户
	private Date deliveryTime;//送货时间
	private String driver;//司机
	private String oddNums;//单号
	private String totalPagNums;//总件数
	private String totalCounts;//总双数
	private String remark;//备注
	private String imagePath;//图片路径
	private String guiGeUUID;//规格UUID
	
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public Date getDeliveryTime() {
		return deliveryTime;
	}
	public songHuo(String clientName, Date deliveryTime, String driver, String oddNums, String totalPagNums,
			String totalCounts, String remark, String imagePath, String guiGeUUID) {
		super();
		this.clientName = clientName;
		this.deliveryTime = deliveryTime;
		this.driver = driver;
		this.oddNums = oddNums;
		this.totalPagNums = totalPagNums;
		this.totalCounts = totalCounts;
		this.remark = remark;
		this.imagePath = imagePath;
		this.guiGeUUID = guiGeUUID;
	}
	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getOddNums() {
		return oddNums;
	}
	public void setOddNums(String oddNums) {
		this.oddNums = oddNums;
	}
	public String getTotalPagNums() {
		return totalPagNums;
	}
	public void setTotalPagNums(String totalPagNums) {
		this.totalPagNums = totalPagNums;
	}
	public String getTotalCounts() {
		return totalCounts;
	}
	public void setTotalCounts(String totalCounts) {
		this.totalCounts = totalCounts;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getGuiGeUUID() {
		return guiGeUUID;
	}
	public void setGuiGeUUID(String guiGeUUID) {
		this.guiGeUUID = guiGeUUID;
	}
	
	
}
