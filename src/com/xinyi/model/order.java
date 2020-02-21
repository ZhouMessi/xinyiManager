package com.xinyi.model;

import java.math.BigDecimal;
import java.util.Date;

public class order {
	private int id;//订单id
	private String clientName;//客户名称
	private int amout;//数量
	private BigDecimal price;//单价
	private Date placeTime;//下单时间
	private Date createTime;//创建时间
	private Date shipmentTime;//出货时间
	private String reMark;//备注
	private String imagePath;//订单图片名称
	
	
	public order(String clientName, int amout, BigDecimal price, Date placeTime, Date shipmentTime, String reMark,
			String imagePath) {
		super();
		this.clientName = clientName;
		this.amout = amout;
		this.price = price;
		this.placeTime = placeTime;
		this.shipmentTime = shipmentTime;
		this.reMark = reMark;
		this.imagePath = imagePath;
	}

	public String getReMark() {
		return reMark;
	}

	public void setReMark(String reMark) {
		this.reMark = reMark;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public order(String clientName, Date placeTime) {
		super();
		this.clientName = clientName;
		this.placeTime = placeTime;
	}

	public order(int id, String clientName, int amout, BigDecimal price, Date placeTime, Date createTime, Date shipmentTime) {
		super();
		this.id = id;
		this.clientName = clientName;
		this.amout = amout;
		this.price = price;
		this.placeTime = placeTime;
		this.createTime = createTime;
		this.shipmentTime = shipmentTime;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public int getAmout() {
		return amout;
	}
	public void setAmout(int amout) {
		this.amout = amout;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Date getPlaceTime() {
		return placeTime;
	}
	public void setPlaceTime(Date placeTime) {
		this.placeTime = placeTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getShipmentTime() {
		return shipmentTime;
	}
	public void setShipmentTime(Date shipmentTime) {
		this.shipmentTime = shipmentTime;
	}

	@Override
	public String toString() {
		return "order [id=" + id + ", clientName=" + clientName + ", amout=" + amout + ", price=" + price
				+ ", placeTime=" + placeTime + ", createTime=" + createTime + ", shipmentTime=" + shipmentTime
				+ ", reMark=" + reMark + ", imagePath=" + imagePath + "]";
	}

	
}
