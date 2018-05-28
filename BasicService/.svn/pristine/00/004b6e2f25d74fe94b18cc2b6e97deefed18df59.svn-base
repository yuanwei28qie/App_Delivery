package com.microsilver.mrcard.basicservice.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.microsilver.mrcard.basicservice.common.Consts;
import com.microsilver.mrcard.common.CryptoTools;

public class Utils  {
	
	private final static Logger logger = LoggerFactory.getLogger(Utils.class);
	/**
	 * 校验APP头信息中的token
	 * 
	 * @param token
	 * @return
	 */
	public static boolean checkToken(String appType,String token,String clientType) {
		boolean result = false;
		String desKey = Consts.APP_TOKEN_DES_KEY;
		try {
			if(appType!=null&&appType.equals("5")){
				//超级跑腿
				desKey = Consts.CHAO_JI_PAO_TUI_DES_KEY;
			}
			String deToken = CryptoTools.decodeByDes(token, desKey);
			int index = deToken.lastIndexOf("+");
			String strCers = deToken.substring(0, index);
			Long times = Long.valueOf(deToken.substring(index + 1));
			Long spaceTime = Math.abs(System.currentTimeMillis() - times);
			//logger.info("token：[{}],终端类型:{},间隔时间:{}", token, clientType,spaceTime);
			if (spaceTime < Consts.TOKEN_EFFECTIVE_SECOND * 1000) {
				String deCers = CryptoTools.decodeByDes(strCers.toString(), desKey);
				String[] strs = deCers.split("[+]");
				if (strs.length >= 3) {
					result = true;
				} else {
					logger.info("证书无效：[{}]", deCers);
				}
			} else {
				logger.info("token已过期：[{}],终端类型:{},间隔时间:{}", token, clientType,spaceTime);
			}
			return result;
		} catch (Exception ex) {
			logger.error("token出错误：[{}],{}", token, ex.getMessage());

		}
		return result;
	}
}
