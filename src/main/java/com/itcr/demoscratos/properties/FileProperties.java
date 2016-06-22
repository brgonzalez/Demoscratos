package com.itcr.demoscratos.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
 

public class FileProperties {
	
	private String emailAdmin;
	private String passMySQL;
	
	public Properties getProperties()   {         

		Properties prop = new Properties();
		InputStream input = null;

		try {

			//input = new FileInputStream("/home/brgonzalez/Documents/workspace-sts-3.7.3.RELEASE/demoscratos/file.properties");
			input = new FileInputStream("/home/brgonzalez/Documents/workspace-sts-3.7.3.RELEASE/demoscratos/file.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			System.out.println(prop.getProperty("emailAdmin"));
			
			return prop;

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop;
	  
	}
	public String getEmailAdmin(){
		return emailAdmin;
	}
	public String getPassMySQL(){
		return passMySQL;
	}
	
	public static void main(String[] args){
		FileProperties s = new FileProperties();
		s.getProperties();
	}
}
