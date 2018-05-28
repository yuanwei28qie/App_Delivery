package com.microsilver.mrcard.basicservice.controller;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

public class JiguangPush extends  BaseController{
	//极光请求头中携带的参数,格式是aapKey:masterSecret
	private static String masterSecret = "154283f8fe15b4e20e3f7f69";
	private static String appKey = "996819b0700414a4fdfe98bf";
	private static final String ALERT = "推送信息";
	 /*
	  *  * 极光推送
     */
	public void jiguangPush(){
		String alias = "123456";//声明别名
		logger.info("对别名" + alias + "的用户推送信息");
		PushResult result = push(String.valueOf(alias),ALERT);
		if(result != null && result.isResultOK()){
			logger.info("针对别名" + alias + "的信息推送成功！");
		}else{
			logger.info("针对别名" + alias + "的信息推送失败！");
		}
	}

	/**
	 * 极光推送方法(采用java SDK)
	 * @param alias
	 * @param alert
	 * @return PushResult
	 */
	public  PushResult push(String alias,String alert){
		ClientConfig clientConfig = ClientConfig.getInstance();
		JPushClient jpushClient = new JPushClient(masterSecret, appKey, null, clientConfig);
		PushPayload payload = buildPushObject_android_ios_alias_alert(alias,alert);
		try {
			return jpushClient.sendPush(payload);
		} catch (APIConnectionException e) {
			logger.error("Connection error. Should retry later. ", e);
			return null;
		} catch (APIRequestException e) {
			logger.error("Error response from JPush server. Should review and fix it. ", e);
			logger.info("HTTP Status: " + e.getStatus());
			logger.info("Error Code: " + e.getErrorCode());
			logger.info("Error Message: " + e.getErrorMessage());
			logger.info("Msg ID: " + e.getMsgId());
			return null;
		}
	}

	/**
	 * 生成极光推送对象PushPayload（采用java SDK）
	 * @param alias
	 * @param alert
	 * @return PushPayload
	 */
	public static PushPayload buildPushObject_android_ios_alias_alert(String alias,String alert){
		return PushPayload.newBuilder()
				.setPlatform(Platform.android_ios())
				.setAudience(Audience.alias(alias))
				.setNotification(Notification.newBuilder()
						.addPlatformNotification(AndroidNotification.newBuilder()
								.addExtra("type", "infomation")
								.setAlert(alert)
								.build())
						.addPlatformNotification(IosNotification.newBuilder()
								.addExtra("type", "infomation")
								.setAlert(alert)
								.build())
						.build())
				.setOptions(Options.newBuilder()
						.setApnsProduction(false)//true-推送生产环境 false-推送开发环境（测试使用参数）
						.setTimeToLive(90)//消息在JPush服务器的失效时间（测试使用参数）
						.build())
				.build();
	}
}
