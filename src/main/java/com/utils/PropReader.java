package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropReader {
	
	private Properties prop;
	
	static String baseDir = System.getProperty("user.dir");
	
	
	/**
	 * Directly Reads and returns a certain key from the config.properties file
	 * @param key
	 * @return String value
	 */
	public String configReader(String key) {
		prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(baseDir+"/src/test/resources/properties/config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Incorrect Properties File Path");
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}
	
	/**
	 * This method is used to load the properties from config.properties file
	 * @return returns Properties class object
	 */
	public Properties init_prop() {
		
		prop = new Properties();
		
		try {
			FileInputStream fis = new FileInputStream(".src/test/resources/com/properties/config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
	
	

}
