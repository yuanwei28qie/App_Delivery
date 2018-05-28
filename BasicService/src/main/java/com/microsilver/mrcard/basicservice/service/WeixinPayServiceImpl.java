package com.microsilver.mrcard.basicservice.service;

import com.microsilver.mrcard.basicservice.common.Consts;
import com.microsilver.mrcard.basicservice.utils.HttpClient;
import com.microsilver.mrcard.basicservice.utils.WXPayUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeixinPayServiceImpl {
	//给微信预支付的请求
	public Map readyPayToWeiXin(String out_trade_no, String total_fee){
		//1.参数封装
		Map<String,String> param=new HashMap();
		param.put("appid", Consts.APP_ID);//公众账号ID
		param.put("mch_id", Consts.MCH_ID);//商户
		//WXPayUtil.generateNonceStr()
		param.put("nonce_str", "1111aaa");//随机字符串
		param.put("body", "xingongsi");
		param.put("out_trade_no", out_trade_no);//交易订单号
		param.put("total_fee", total_fee);//金额（分）
		param.put("spbill_create_ip", "127.0.0.1");
		param.put("notify_url", "http://www.itcast.cn");
		param.put("trade_type", "NATIVE");//交易类型

		try {
			//第二个参数是私钥
			String xmlParam = WXPayUtil.generateSignedXml(param, "partnerkey");
			System.out.println("请求的参数："+xmlParam);

			//2.发送请求
			HttpClient httpClient=new HttpClient("https://api.mch.weixin.qq.com/pay/unifiedorder");
			httpClient.setHttps(true);
			httpClient.setXmlParam(xmlParam);
			httpClient.post();

			//3.获取结果
			String xmlResult = httpClient.getContent();

			Map<String, String> mapResult = WXPayUtil.xmlToMap(xmlResult);
			System.out.println("微信返回结果"+mapResult);
			Map map=new HashMap<>();
			map.put("code_url", mapResult.get("code_url"));//生成支付二维码的链接
			map.put("out_trade_no", out_trade_no);
			map.put("total_fee", total_fee);

			return map;

		} catch (Exception e) {
			e.printStackTrace();
			return new HashMap();
		}
	}
	//检测微信支付是否已经支付成功
	public Map queryPayStatus(String out_trade_no) {
		//1.封装参数
		Map param=new HashMap();
		param.put("appid", Consts.APP_ID);
		param.put("mch_id", Consts.MCH_ID);
		param.put("out_trade_no", out_trade_no);
		param.put("nonce_str", WXPayUtil.generateNonceStr());
		try {
			//第二个参数是私钥
			String xmlParam = WXPayUtil.generateSignedXml(param, "partnerkey");
			//2.发送请求
			HttpClient httpClient=new HttpClient("https://api.mch.weixin.qq.com/pay/orderquery");
			httpClient.setHttps(true);
			httpClient.setXmlParam(xmlParam);
			httpClient.post();

			//3.获取结果
			String xmlResult = httpClient.getContent();
			Map<String, String> map = WXPayUtil.xmlToMap(xmlResult);
			System.out.println("调动查询API返回结果："+xmlResult);

			return map;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

}
