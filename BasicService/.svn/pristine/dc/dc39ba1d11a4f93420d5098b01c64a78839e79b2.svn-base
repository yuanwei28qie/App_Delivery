/**
 * 
 */
package com.microsilver.mrcard.basicservice.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 
 * @Name com.heyin.TimeBetween
 * @Description
 * 
 * @Author huwei
 * @Version 2018年4月9日 下午5:17:55
 * @Copyright Micro Silver-SuperDelivery
 *
 */
public class TimeBetween {

	public static void main(String[] args) {
		boolean inDate = isInDate(new Date(), "8:00:00", "22:00:00");
		System.out.println(inDate);
	}

	public static boolean isInDate(Date date, String strDateBegin, String strDateEnd) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
		String strDate = sdf.format(date); // 2016-12-16 11:53:54
		// 截取当前时间时分秒 转成整型
		int tempDate = Integer
				.parseInt(strDate.substring(11, 13) + strDate.substring(14, 16) + strDate.substring(17, 19));
		// 截取开始时间时分秒 转成整型
		int tempDateBegin = Integer
				.parseInt(strDateBegin.substring(0, 1) + strDateBegin.substring(2, 4) + strDateBegin.substring(5,6));
		// 截取结束时间时分秒 转成整型
		int tempDateEnd = Integer
				.parseInt(strDateEnd.substring(0, 2) + strDateEnd.substring(3, 5) + strDateEnd.substring(6, 8));

		if ((tempDate >= tempDateBegin && tempDate <= tempDateEnd)) {
			return true;
		} else {
			return false;
		}
	}
}
