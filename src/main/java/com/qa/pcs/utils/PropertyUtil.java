package com.qa.pcs.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {
	
	Properties prop;
	
	public PropertyUtil() {
		
		try {
			prop=new Properties();
			FileInputStream fis=new FileInputStream("D:\\Selenium\\PCS\\src\\test\\resources\\config\\config.properties");
			//FileInputStream fis=new FileInputStream(".\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public String getPropertyValue(String key_value) {
		
		return prop.getProperty(key_value);
	}

}
