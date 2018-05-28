package com.microsilver.mrcard.basicservice.common;

import com.microsilver.mrcard.basicservice.utils.SystemConfig;


public class Consts {
	//token开关
	public static final Boolean CHECK_TOKEN = SystemConfig.getBooleanValue("CHECK_TOKEN");
	//图片存储位置
	public static final String PICTURES_ADDRESS = SystemConfig.getValue("PICTURES_ADDRESS");

	//电话正则表达式
	public static final String MOBILE_REGEX = SystemConfig.getValue("MOBILE_REGEX");
	//支付微信应用ID
	public static final String APP_ID = SystemConfig.getValue("APP_ID");
	//支付微信商户ID
	public static final String MCH_ID = SystemConfig.getValue("MCH_ID");
	//支付微信公钥
	public static final String PARENT_KEY = SystemConfig.getValue("PARENT_KEY");

	//支付宝APPID
	public static final String AliPAYAPP_ID = SystemConfig.getValue("AliPAYAPP_ID");
	//支付宝秘钥(验证回调是否支付成功的秘钥)
	public static final String AliPAYAPP_KEY = SystemConfig.getValue("AliPAYAPP_KEY");

	//支付宝交易订单私钥
	public static final String AliPAYAPP_PRIVATE_KEY = SystemConfig.getValue("AliPAYAPP_PRIVATE_KEY");


	//骑手分润比例
	public static final Double DELIVERY_PROPORTION = SystemConfig.getDoubleValue("DELIVERY_PROPORTION");
	//代理商分润比例
	public static final Double AGENT_PROPORTION = SystemConfig.getDoubleValue("AGENT_PROPORTION");
	//平台分润比例
	public static final Double PLATFORM_PROPORTION = SystemConfig.getDoubleValue("PLATFORM_PROPORTION");
	//平台电话
	public static final Integer PLATfORMPHONE = SystemConfig.getIntValue("PLATfORMPHONE");
}
