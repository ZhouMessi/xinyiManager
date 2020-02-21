package com.xinyi.model;

public class orderBarChartModel {
	private int huayangNumByTime1;//当前月
	private int huayangNumByTime2;//上一个月
	private int huayangNumByTime3;//上两个月
	
	private int duoweiNumByTime1;
	private int duoweiNumByTime2;
	private int duoweiNumByTime3;
	
	private int tongjieNumByTime1;
	private int tongjieNumByTime2;
	private int tongjieNumByTime3;
	
	private int waishangNumByTime1;
	private int waishangNumByTime2;
	private int waishangNumByTime3;
	

	private int otherNumByTime1;
	private int otherNumByTime2;
	private int otherNumByTime3;
	public orderBarChartModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public orderBarChartModel(int huayangNumByTime1, int huayangNumByTime2, int huayangNumByTime3, int duoweiNumByTime1,
			int duoweiNumByTime2, int duoweiNumByTime3, int tongjieNumByTime1, int tongjieNumByTime2,
			int tongjieNumByTime3, int waishangNumByTime1, int waishangNumByTime2, int waishangNumByTime3,
			int otherNumByTime1, int otherNumByTime2, int otherNumByTime3) {
		super();
		this.huayangNumByTime1 = huayangNumByTime1;
		this.huayangNumByTime2 = huayangNumByTime2;
		this.huayangNumByTime3 = huayangNumByTime3;
		this.duoweiNumByTime1 = duoweiNumByTime1;
		this.duoweiNumByTime2 = duoweiNumByTime2;
		this.duoweiNumByTime3 = duoweiNumByTime3;
		this.tongjieNumByTime1 = tongjieNumByTime1;
		this.tongjieNumByTime2 = tongjieNumByTime2;
		this.tongjieNumByTime3 = tongjieNumByTime3;
		this.waishangNumByTime1 = waishangNumByTime1;
		this.waishangNumByTime2 = waishangNumByTime2;
		this.waishangNumByTime3 = waishangNumByTime3;
		this.otherNumByTime1 = otherNumByTime1;
		this.otherNumByTime2 = otherNumByTime2;
		this.otherNumByTime3 = otherNumByTime3;
	}
	public int getHuayangNumByTime1() {
		return huayangNumByTime1;
	}
	public void setHuayangNumByTime1(int huayangNumByTime1) {
		this.huayangNumByTime1 = huayangNumByTime1;
	}
	public int getHuayangNumByTime2() {
		return huayangNumByTime2;
	}
	public void setHuayangNumByTime2(int huayangNumByTime2) {
		this.huayangNumByTime2 = huayangNumByTime2;
	}
	public int getHuayangNumByTime3() {
		return huayangNumByTime3;
	}
	public void setHuayangNumByTime3(int huayangNumByTime3) {
		this.huayangNumByTime3 = huayangNumByTime3;
	}
	public int getDuoweiNumByTime1() {
		return duoweiNumByTime1;
	}
	public void setDuoweiNumByTime1(int duoweiNumByTime1) {
		this.duoweiNumByTime1 = duoweiNumByTime1;
	}
	public int getDuoweiNumByTime2() {
		return duoweiNumByTime2;
	}
	public void setDuoweiNumByTime2(int duoweiNumByTime2) {
		this.duoweiNumByTime2 = duoweiNumByTime2;
	}
	public int getDuoweiNumByTime3() {
		return duoweiNumByTime3;
	}
	public void setDuoweiNumByTime3(int duoweiNumByTime3) {
		this.duoweiNumByTime3 = duoweiNumByTime3;
	}
	public int getTongjieNumByTime1() {
		return tongjieNumByTime1;
	}
	public void setTongjieNumByTime1(int tongjieNumByTime1) {
		this.tongjieNumByTime1 = tongjieNumByTime1;
	}
	public int getTongjieNumByTime2() {
		return tongjieNumByTime2;
	}
	public void setTongjieNumByTime2(int tongjieNumByTime2) {
		this.tongjieNumByTime2 = tongjieNumByTime2;
	}
	public int getTongjieNumByTime3() {
		return tongjieNumByTime3;
	}
	public void setTongjieNumByTime3(int tongjieNumByTime3) {
		this.tongjieNumByTime3 = tongjieNumByTime3;
	}
	public int getWaishangNumByTime1() {
		return waishangNumByTime1;
	}
	public void setWaishangNumByTime1(int waishangNumByTime1) {
		this.waishangNumByTime1 = waishangNumByTime1;
	}
	public int getWaishangNumByTime2() {
		return waishangNumByTime2;
	}
	public void setWaishangNumByTime2(int waishangNumByTime2) {
		this.waishangNumByTime2 = waishangNumByTime2;
	}
	public int getWaishangNumByTime3() {
		return waishangNumByTime3;
	}
	public void setWaishangNumByTime3(int waishangNumByTime3) {
		this.waishangNumByTime3 = waishangNumByTime3;
	}
	public int getOtherNumByTime1() {
		return otherNumByTime1;
	}
	public void setOtherNumByTime1(int otherNumByTime1) {
		this.otherNumByTime1 = otherNumByTime1;
	}
	public int getOtherNumByTime2() {
		return otherNumByTime2;
	}
	public void setOtherNumByTime2(int otherNumByTime2) {
		this.otherNumByTime2 = otherNumByTime2;
	}
	public int getOtherNumByTime3() {
		return otherNumByTime3;
	}
	@Override
	public String toString() {
		return "orderBarChartModel [huayangNumByTime1=" + huayangNumByTime1 + ", huayangNumByTime2=" + huayangNumByTime2
				+ ", huayangNumByTime3=" + huayangNumByTime3 + ", duoweiNumByTime1=" + duoweiNumByTime1
				+ ", duoweiNumByTime2=" + duoweiNumByTime2 + ", duoweiNumByTime3=" + duoweiNumByTime3
				+ ", tongjieNumByTime1=" + tongjieNumByTime1 + ", tongjieNumByTime2=" + tongjieNumByTime2
				+ ", tongjieNumByTime3=" + tongjieNumByTime3 + ", waishangNumByTime1=" + waishangNumByTime1
				+ ", waishangNumByTime2=" + waishangNumByTime2 + ", waishangNumByTime3=" + waishangNumByTime3
				+ ", otherNumByTime1=" + otherNumByTime1 + ", otherNumByTime2=" + otherNumByTime2 + ", otherNumByTime3="
				+ otherNumByTime3 + "]";
	}
	public void setOtherNumByTime3(int otherNumByTime3) {
		this.otherNumByTime3 = otherNumByTime3;
	}

	
	
}
