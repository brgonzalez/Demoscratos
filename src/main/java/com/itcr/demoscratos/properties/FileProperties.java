package com.itcr.demoscratos.properties;

import java.io.IOException;
import java.util.Properties;
 

public class FileProperties {
	
	private String emailAdmin;
	private String passMySQL;
	
	public Properties getProperties()   {         
		try{             
			Properties propiedades = new Properties();             
			propiedades.load( getClass().getResourceAsStream("file.properties") );             
			if (!propiedades.isEmpty()){                                
				return propiedades;             
			} else {                
				return null;             
			}         
		}catch (IOException ex) {  
			System.out.println("Error al leer properties");
			return null;
		}
	}
	public String getEmailAdmin(){
		return emailAdmin;
	}
	public String getPassMySQL(){
		return passMySQL;
	}
}
