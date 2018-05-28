package com.microsilver.mrcard.basicservice.utils;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;


public class SystemConfig {
	private static String systemproper = "system-config.properties";

	private static Properties props;
	public static synchronized Properties loadPropertyFileByFileName(String fileName) {
		if(props == null){
			props = new Properties();
			if (fileName != null) {
				InputStream is = null;
				try {
					ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
					is = classLoader.getResourceAsStream(fileName);
					if (is != null) {
						props.load(is);
						is.close();
					}
				} catch (Throwable t) {
					if (is != null) {
						try {
							is.close();
						} catch (Throwable u) {
							u.printStackTrace();
						}
					}
				}
			}			
		}
		return props;
	}

	/**
	 * 获取配置文件的值返回String类型
	 * 
	 * @param name
	 * @return
	 */
	public static String getValue(String name) {
		Properties props = loadPropertyFileByFileName(systemproper);
		return props.getProperty(name).trim();
	}

	/**
	 * 获取配置文件的值返回int类型
	 * 
	 * @param name
	 * @return
	 */
	public static int getIntValue(String name) {
		Properties props = loadPropertyFileByFileName(systemproper);
		String n = props.getProperty(name).trim();
		return Integer.parseInt(n);
	}

	/**
	 * 获取配置文件的值返回long类型
	 * 
	 * @param name
	 * @return
	 */
	public static long getLongValue(String name) {
		Properties props = loadPropertyFileByFileName(systemproper);
		String n = props.getProperty(name).trim();
		return Long.parseLong(n);
	}


	/**
	 * 获取配置文件的值返回double类型
	 * 
	 * @param name
	 * @return
	 */
	public static double getDoubleValue(String name) {
		Properties props = loadPropertyFileByFileName(systemproper);
		String n = props.getProperty(name).trim();
		return Double.parseDouble(n);
	}

	public static boolean getBooleanValue(String name) {
		Properties props = loadPropertyFileByFileName(systemproper);
		String n = props.getProperty(name).trim();
		if (n.toLowerCase().equals("true")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 获取配置文件的值返回Date类型
	 * 
	 * @param name
	 * @param format
	 *            日期格式
	 * @return
	 */
	public static Date getDateValue(String name, String format) {
		Properties props = loadPropertyFileByFileName(systemproper);
		String n = props.getProperty(name).trim();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date d = null;
		try {
			d = sdf.parse(n);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}
}
