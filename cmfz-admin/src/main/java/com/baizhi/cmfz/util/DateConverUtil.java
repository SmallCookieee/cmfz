package com.baizhi.cmfz.util;

import java.text.SimpleDateFormat;

public class DateConverUtil {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public static java.util.Date toUtilDate(String source){
		try{
			return sdf.parse(source);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static java.sql.Date toSqlDate(java.util.Date utilUate){
		return new java.sql.Date(utilUate.getTime());
	}
	
	public static String toString(java.util.Date date){
		return sdf.format(date);
	}
}
