package com.itcr.demoscratos.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServiceDate {
	Date closingAt;
	public ServiceDate(String date){
		try {
			closingAt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean isClose(){
		Date actual = new Date();

		if (closingAt.getTime()-actual.getTime() < 0){
			return true;
		}
		return false;
		
	}
	public String getCloseDate(){
		Date actual = new Date();
		long diff = closingAt.getTime()-actual.getTime();
		long days = diff / (24 * 60 * 60 * 1000);
		long hours = diff / (60 * 60 * 1000);
		long minutes = diff / ( 60 * 1000);
		if(days > 0){
			if(days == 1){
				return "Cierra en "+ days+" día";

			}
			return "Cierra en "+days+" días";
		}
		if(hours > 0){
			if(hours == 1){
				return "Cierra en "+hours+" hora";

			}
			return "Cierra en "+hours+" horas";
		}
		if( minutes == 0){
			return "Cerrado";
		}
		return "Cierra en "+minutes + " minutos";
	}
}
