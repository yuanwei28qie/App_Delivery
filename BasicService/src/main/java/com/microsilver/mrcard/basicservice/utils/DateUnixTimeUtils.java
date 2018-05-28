package com.microsilver.mrcard.basicservice.utils;

import org.joda.time.DateTime;

import java.util.Date;

public class DateUnixTimeUtils {

	public static Date   TimeStamp2Date(String timestampString) {
		Long timestamp = Long.parseLong(timestampString) * 1000;
		return new Date(timestamp);
	}


	public  static String format(Date date) {
		DateTime now = new DateTime();
		DateTime today_start = new DateTime(now.getYear(), now.getMonthOfYear(), now.getDayOfMonth(), 0, 0, 0);
		DateTime today_end = today_start.plusDays(1);

		if(date.after(today_start.toDate()) && date.before(today_end.toDate())) {
			return "今天";
		}

		return "不是今天";
	}
}
