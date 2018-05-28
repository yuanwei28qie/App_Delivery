package com.microsilver.mrcard.basicservice.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	/**
	 * 获取配置文件
	 * 
	 * @param filename
	 */
	public static Properties loadProperties(String filename) {
		if (filename == null || "".equals(filename)) {
			return null;
		}

		try (InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename)) {
			Properties prop = new Properties();
			prop.load(stream);
			return prop;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
