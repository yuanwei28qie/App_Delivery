package com.microsilver.mrcard.basicservice.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;



public class JuheMsg {

	public static final String DEF_CHATSET = "UTF-8";
	public static final int DEF_CONN_TIMEOUT = 30000;
	public static final int DEF_READ_TIMEOUT = 30000;
	public static String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";



	public static void main(String[] args) throws Exception {

		//sendUserDeliveryGetOrder("18113128325","997229356395499520",15283766426L,100);
	}
	
	public static void sendMsg(String userMobile,String checkCode) {
		String url = "http://113.108.68.243:9090/sendSMS.action";// 请求接口地址
		Map<String, Object> params = new HashMap<String, Object>();// 请求参数
		params.put("enterpriseID", "10108");
		params.put("loginName", "admin");
		String xiaoduantui123 = DigestUtils.md5Hex("xiaoduantui123");
		params.put("password", xiaoduantui123);
		params.put("mobiles", userMobile);
		params.put("content", "您的验证码是"+checkCode+"，如非本人操作，请忽略本短信。1分钟内有效");
		String result=HttpTookit.sendPost(url, params);
		System.out.println(result);
	}
	public static void sendUserOfOrderStatus(String mobile,String orderSn,Long deliveryPhone,int type) {
		String url = "http://113.108.68.243:9090/sendSMS.action";// 请求接口地址
		Map<String, Object> params = new HashMap<String, Object>();// 请求参数
		params.put("enterpriseID", "10108");
		params.put("loginName", "admin");
		String xiaoduantui123 = DigestUtils.md5Hex("xiaoduantui123");
		params.put("password", xiaoduantui123);
		params.put("mobiles", mobile);
		String content =null;
		switch(type){
			case 1:
				content = "[帮我买]您的订单号:"+orderSn+",骑手已为你接单, 如有需要联系骑手:"+deliveryPhone;
				break;
			case 2:
				content = "[帮我买]您的订单号:"+orderSn+",骑手已为您取货成功,如有需要请联系骑手:"+deliveryPhone;
				break;
			case 3:
				content = "[帮我买]您的订单号:"+orderSn+",骑手已为您送到,如有需要请联系骑手:"+deliveryPhone;
				break;
			case 4:
				content = "[帮我取]您的订单号:"+orderSn+",骑手已为你接单, 如有需要联系骑手:"+deliveryPhone;
				break;
			case 5:
				content = "[帮我取]您的订单号:"+orderSn+",骑手已为您取货成功,如有需要请联系骑手:"+deliveryPhone;
				break;
			case 6:
				content = "[帮我取]您的订单号:"+orderSn+",骑手已为您送到,如有需要请联系骑手:"+deliveryPhone;
				break;
			case 7:
				content = "[帮我送]您的订单号:"+orderSn+",骑手已为你接单, 如有需要联系骑手:"+deliveryPhone;
				break;
			case 8:
				content = "[帮我送]您的订单号:"+orderSn+",骑手已为您取货成功,如有需要请联系骑手:"+deliveryPhone;
				break;
			case 9:
				content = "[帮我送]您的订单号:"+orderSn+",骑手已为您送到,如有需要请联系骑手:"+deliveryPhone;
				break;
			default:
				content = "";
			break;
		}
		params.put("content", content);
		String result=HttpTookit.sendPost(url, params);
		System.out.println(result);
	}




	
	// 2.发送短信
	@SuppressWarnings("unchecked")
	static boolean getRequest22(String phone,  String value,String checkCode) {
		System.out.println("=======================进入发送短信");
		String result = null;
		String url = "http://113.108.68.243:9090/sendSMS.action";// 请求接口地址
		Map params = new HashMap();// 请求参数
		params.put("enterpriseID", "10108");
		params.put("loginName", "admin");
		String xiaoduantui123 = DigestUtils.md5Hex("xiaoduantui123");
		params.put("password", xiaoduantui123);
		params.put("mobiles", phone);
		params.put("content", "您的验证码是:"+checkCode+"如非本人操作,请忽略此短信");
		params.put("code", checkCode);

		try {
			result = HttpTookit.sendPost(url, params);
			System.out.println(result.toString()+"-------------------");
//			JSONObject object = JSON.parseObject(result);
//			if (object.getIntValue("error_code") == 0) {
//				return true;
//			} else {
//				throw new Exception(object.getString("error_code") + ":" + object.getString("reason"));
//			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean sendCheckCode2(String mobile, String contents,String checkCode) throws Exception {
		boolean result = false;
		if (contents!=null) {
			result = getRequest22(mobile, contents,checkCode);
		} else {
			throw new Exception("位置验证类型");
		}
		return result;
	}

	public static boolean sendSMS2(String mobile,String templateParams,String checkCode){
		return getRequest22(mobile, templateParams,checkCode);
	}

	/**
	 *
	 * @param strUrl
	 *            请求地址
	 * @param params
	 *            请求参数
	 * @param method
	 *            请求方法
	 * @return 网络请求字符串
	 * @throws Exception
	 */
	public static String net(String strUrl, Map params, String method) throws Exception {
		HttpURLConnection conn = null;
		BufferedReader reader = null;
		String rs = null;
		try {
			StringBuffer sb = new StringBuffer();
			if (method == null || method.equals("POST")) {
				strUrl = strUrl + "?" + urlencode(params);
			}
			URL url = new URL(strUrl);
			conn = (HttpURLConnection) url.openConnection();
			if (method == null || method.equals("POST")) {
				conn.setRequestMethod("POST");
			} else {
				conn.setRequestMethod("GET");
				conn.setDoOutput(true);
			}
			conn.setRequestProperty("User-agent", userAgent);
			conn.setUseCaches(false);
			conn.setConnectTimeout(DEF_CONN_TIMEOUT);
			conn.setReadTimeout(DEF_READ_TIMEOUT);
			conn.setInstanceFollowRedirects(false);
			
			conn.connect();
			if (params != null && method.equals("GET")) {
				try {
					DataOutputStream out = new DataOutputStream(conn.getOutputStream());
					out.writeBytes(urlencode(params));
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			InputStream is = conn.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sb.append(strRead);
			}
			rs = sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
			if (conn != null) {
				conn.disconnect();
			}
		}
		return rs;
	}

	// 将map型转为请求参数型
	public static String urlencode(Map<String, Object> data) {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry i : data.entrySet()) {
			try {
				sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue() + "", "UTF-8")).append("&");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

}