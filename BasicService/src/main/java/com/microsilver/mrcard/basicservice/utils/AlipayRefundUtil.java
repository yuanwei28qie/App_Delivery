package com.microsilver.mrcard.basicservice.utils;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.microsilver.mrcard.basicservice.config.AlipayConfig;

public class AlipayRefundUtil {

	/**  支付宝退款接口
	 * @param out_trade_no 订单支付时传入的商户订单号,不能和支付宝交易号（trade_no）同时为空。
	 * @param trade_no 支付宝交易号
	 * @param refund_amount 需要退款的金额，该金额不能大于订单金额,单位为元，支持两位小数
	 * @return 将提示信息返回
	 */
	public  synchronized static  String alipayRefundRequest(String out_trade_no,String trade_no,double refund_amount) {
		String returnStr = null;

		String out_request_no="BZ35581R88001";//随机数  不是全额退款，部分退款使用该参数
		try {
			AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID, AlipayConfig.ALIPAY_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET, AlipayConfig.ALIPAY_KEY, "RSA2");
			AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
			request.setBizContent("{" +
					"\"out_trade_no\":\"" + out_trade_no + "\"," +
					"\"trade_no\":\"" + trade_no + "\"," +
					"\"refund_amount\":\"" + refund_amount + "\"," +

					"\"out_request_no\":\"" + out_request_no+ "\"," +
					"\"refund_reason\":\"正常退款\"" +
					" }");
			AlipayTradeRefundResponse response;
			response = alipayClient.execute(request);
			if (response.isSuccess()) {
				returnStr = "支付宝退款成功";
			} else {
				returnStr = response.getSubMsg();//失败会返回错误信息
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnStr;
	}


	public static void main(String str[]){
		String strq=  alipayRefundRequest("999633359083352064","2018052421001004490280391309",1);
		System.out.println(strq);
	}


}

