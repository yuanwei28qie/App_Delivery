package com.microsilver.mrcard.basicservice.utils;

import com.microsilver.mrcard.basicservice.common.Consts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 验证手机号是否符合规格
 */
public class CheckBasicMsg {

	public static boolean checkMobile(String mobile) {
		String mobileRegex = Consts.MOBILE_REGEX;
		Pattern p = Pattern.compile(mobileRegex);
		Matcher m = p.matcher(mobile);
		return m.find();
	}
}
