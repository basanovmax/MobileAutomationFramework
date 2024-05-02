package com.automation.utils;

import java.io.FileReader;
import java.util.Properties;

public class ConfigReader {

	static Properties prop;

	public static void loadProperties() {
		try {
			prop = new Properties();
			FileReader reader = new FileReader("src/test/resources/config/config.properties");
			prop.load(reader);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String getProperty(String key) {
		return prop.getProperty(key);
	}
}
