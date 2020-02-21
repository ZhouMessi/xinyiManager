package com.xinyi.util;

import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import com.xinyi.common.dateCommon;



public class DateUtil {

	private static final DateFormat DEFAULT_YMD =new SimpleDateFormat("yyyy-MM-dd");
	private static final DateFormat DEFAULT_YMD_HMS =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final DateFormat DEFAULTYMDHMS =new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
	
	public static String dateToString(Date date) {   
		if(date == null) {
			return "";
		};
		return	DEFAULT_YMD.format(date);	
	}
	
	public static Date stringToDate(String dateStr)  {	
		Date date = null;
		if(StringUtil.isEmpty(dateStr)) {
			return date;
		}
		try {
			date = DEFAULT_YMD_HMS.parse(dateStr);
		} catch (ParseException e) {
			try {
				date = DEFAULT_YMD.parse(dateStr);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return date;
	}
	public static String getMaxDate(Date date) throws Exception {
		return DEFAULT_YMD.format(date) +" 23:59:59";
	}
	public static String getMinDate(Date date) throws Exception {
		return DEFAULT_YMD.format(date) +" 00:00:00";
	}
	
	public static String getFileName() {
		return DEFAULTYMDHMS.format(new Date());
	}
	
	public static dateCommon getDateCommon() {
		        Calendar c = Calendar.getInstance();	         
		        //获取当前的月份
		        c.setTime(new Date());
		        String nowYear = String.valueOf(c.get(Calendar.YEAR));
		        String nowMonth = String.valueOf(c.get(Calendar.MONTH)+1);
		         
		        //过去一月
		        c.setTime(new Date());
		        c.add(Calendar.MONTH, -1);
		        String nowYear_1 = String.valueOf(c.get(Calendar.YEAR));
		        String nowMonth_1 = String.valueOf(c.get(Calendar.MONTH)+1);
		         
		        //过去二个月
		        c.setTime(new Date());
		        c.add(Calendar.MONTH, -2);
		        String nowYear_2 = String.valueOf(c.get(Calendar.YEAR));
		        String nowMonth_2 = String.valueOf(c.get(Calendar.MONTH)+1);        
		        return new dateCommon(nowYear, nowMonth, nowYear_1, nowMonth_1, nowYear_2, nowMonth_2);
	};
	
	public static void main(String[] args) {
		System.out.println(DateUtil.getDateCommon().toString());
	}
}
