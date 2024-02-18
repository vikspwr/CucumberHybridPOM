/**
 * 
 */
package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Author : Vikas S Pawar
 */
public class PropertiesReader {

	private String configFilePath = "src/test/resources/ConfigProp/config.properties";
	private Properties properties;
	private FileInputStream fis;

	public Properties init_Prop() {
		properties = new Properties();
		try {
			fis = new FileInputStream(configFilePath);
			properties.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
}
