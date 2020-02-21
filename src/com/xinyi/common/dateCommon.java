package com.xinyi.common;

public class dateCommon {

	private String nowYear;
	private String nowMonth;
	
	private String nowYear_1;
	private String nowMonth_1;
	
	private String nowYear_2;
	private String nowMonth_2;
	
	public dateCommon(String nowYear, String nowMonth, String nowYear_1, String nowMonth_1, String nowYear_2,
			String nowMonth_2) {
		super();
		this.nowYear = nowYear;
		this.nowMonth = nowMonth;
		this.nowYear_1 = nowYear_1;
		this.nowMonth_1 = nowMonth_1;
		this.nowYear_2 = nowYear_2;
		this.nowMonth_2 = nowMonth_2;
	}
	
	public dateCommon() {
		super();
	}

	@Override
	public String toString() {
		return "dateCommon [nowYear=" + nowYear + ", nowMonth=" + nowMonth + ", nowYear_1=" + nowYear_1
				+ ", nowMonth_1=" + nowMonth_1 + ", nowYear_2=" + nowYear_2 + ", nowMonth_2=" + nowMonth_2 + "]";
	}

	public String getNowYear() {
		return nowYear;
	}
	public void setNowYear(String nowYear) {
		this.nowYear = nowYear;
	}
	public String getNowMonth() {
		return nowMonth;
	}
	public void setNowMonth(String nowMonth) {
		this.nowMonth = nowMonth;
	}
	public String getNowYear_1() {
		return nowYear_1;
	}
	public void setNowYear_1(String nowYear_1) {
		this.nowYear_1 = nowYear_1;
	}
	public String getNowMonth_1() {
		return nowMonth_1;
	}
	public void setNowMonth_1(String nowMonth_1) {
		this.nowMonth_1 = nowMonth_1;
	}
	public String getNowYear_2() {
		return nowYear_2;
	}
	public void setNowYear_2(String nowYear_2) {
		this.nowYear_2 = nowYear_2;
	}
	public String getNowMonth_2() {
		return nowMonth_2;
	}
	public void setNowMonth_2(String nowMonth_2) {
		this.nowMonth_2 = nowMonth_2;
	}
	
	
	
}
