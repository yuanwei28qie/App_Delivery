package com.microsilver.mrcard.basicservice.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.microsilver.mrcard.basicservice.common.Consts;
import com.microsilver.mrcard.basicservice.config.AlipayConfig;
import com.microsilver.mrcard.basicservice.dto.PayWxDto;
import com.microsilver.mrcard.basicservice.dto.RespBaseDto;
import com.microsilver.mrcard.basicservice.model.FxSdCarriageOrder;
import com.microsilver.mrcard.basicservice.model.FxSdUserMember;
import com.microsilver.mrcard.basicservice.model.enums.EWarning;
import com.microsilver.mrcard.basicservice.service.OrderService;
import com.microsilver.mrcard.basicservice.service.UserService;
import com.microsilver.mrcard.basicservice.utils.HttpClient;
import com.microsilver.mrcard.basicservice.utils.WXPayUtil;
import com.microsilver.mrcard.basicservice.vo.AlipayVo;
import com.microsilver.mrcard.basicservice.vo.PayWxVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;



/*
 * 
 * 支付接口,对接微信和支付宝或者余额支付   
 */
@Api(value="/api/pay",description="订单支付接口")
@Controller
@RequestMapping(value="/api/pay")
@Transactional
public class PayController extends BaseController{
	private final   String CHARSET = "utf-8";
	@Resource
	private OrderService orderService;
	@Resource
	private UserService userService;

	@ApiOperation(value = "微信预支付", httpMethod = "POST")
	@PostMapping(value = "/beforePayWx", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto<PayWxDto> beforePayWx(@RequestBody PayWxVo payWxVo)  {
		RespBaseDto<PayWxDto> result = new RespBaseDto<>();
		Long outTradeNo = payWxVo.getOutTradeNo();
		Double totalFee = payWxVo.getTotalFee();
		PayWxDto payWxDto = new PayWxDto();
		try{
			if(outTradeNo!=null&&totalFee!=null){
				//通过订单号查询订单号和金额是否一致
				double moeny = totalFee*100;
				FxSdCarriageOrder order = orderService.selectOrderByOrderSn(outTradeNo);
				if(order!=null){
					BigDecimal decimal = order.getDispatchPrice().add(order.getTipPrice());
					int i = decimal.compareTo(new BigDecimal(totalFee));
					if(i==0){
						//订单金额相等
						//1.参数封装
						Map param=new HashMap();
						param.put("appid", Consts.APP_ID);//公众账号ID
						param.put("mch_id", Consts.MCH_ID);//商户
						param.put("nonce_str", WXPayUtil.generateNonceStr());//随机字符串
						param.put("body", "成都超级跑腿");
						param.put("out_trade_no", outTradeNo);//交易订单号
						param.put("total_fee", moeny);//金额（分）
						param.put("spbill_create_ip", "127.0.0.1");
						param.put("notify_url", "http://www.baidu.cn");
						param.put("trade_type", "NATIVE");//交易类型
						String xmlParam = WXPayUtil.generateSignedXml(param,Consts.PARENT_KEY);
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
						//map.put("code_url", mapResult.get("code_url"));//生成支付二维码的链接
						map.put("out_trade_no", outTradeNo);
						map.put("total_fee", totalFee);
						map.put("return_Code",mapResult.get("return_code"));
						map.put("return_msg",mapResult.get("return_msg"));
						payWxDto.setMap(map);
						result.setMessage("ok");
						result.setState(200);
						result.setData(payWxDto);
					}else{
						result.setMessage(EWarning.OrderAccountError.getName());
						result.setState(EWarning.OrderAccountError.getValue());
						result.setData(payWxDto);
					}
				}else{
					result.setMessage(EWarning.NoOrderInfo.getName());
					result.setState(EWarning.NoOrderInfo.getValue());
					result.setData(payWxDto);
				}
			}else{
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
				result.setData(payWxDto);
			}
		}catch(Exception e){
			logger.error("beforePayWx error:{}", e.getMessage());
			result.setMessage(EWarning.Unknown.getName() + e.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}


	@ApiOperation(value = "检测微信支付是否成功", httpMethod = "POST")
	@PostMapping(value = "/CheckPayWxIsSuccess", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto<PayWxDto> CheckPayWxIsSuccess(@RequestBody PayWxVo payWxVo)  {
		RespBaseDto<PayWxDto> result = new RespBaseDto<>();
		Long outTradeNo = payWxVo.getOutTradeNo();
		Double totalFee = payWxVo.getTotalFee();
		PayWxDto payWxDto = new PayWxDto();
		try{
			if(outTradeNo!=null&&totalFee!=null){
				//通过订单号查询订单号和金额是否一致
				double moeny = totalFee*100;
				FxSdCarriageOrder order = orderService.selectOrderByOrderSn(outTradeNo);
				if(order!=null){
					BigDecimal decimal = order.getDispatchPrice().add(order.getTipPrice());
					int i = decimal.compareTo(new BigDecimal(totalFee));
					if(i==0){
						//订单金额相等
						//1.封装参数
						Map param=new HashMap();
						param.put("appid", Consts.APP_ID);
						param.put("mch_id", Consts.PARENT_KEY);
						param.put("out_trade_no", outTradeNo);
						param.put("nonce_str", WXPayUtil.generateNonceStr());
						//2.发送请求
						String xmlParam = WXPayUtil.generateSignedXml(param, Consts.PARENT_KEY);
						HttpClient httpClient=new HttpClient("https://api.mch.weixin.qq.com/pay/orderquery");
						httpClient.setHttps(true);
						httpClient.setXmlParam(xmlParam);
						httpClient.post();
						//3.获取结果
						String xmlResult = httpClient.getContent();
						Map<String, String> mapResult = WXPayUtil.xmlToMap(xmlResult);
						System.out.println("调动查询API返回结果："+xmlResult);
						Map map=new HashMap<>();
						map.put("out_trade_no", outTradeNo);
						map.put("total_fee", totalFee);
						map.put("return_Code",mapResult.get("return_code"));
						map.put("return_msg",mapResult.get("return_msg"));
						payWxDto.setMap(map);
						result.setMessage("ok");
						result.setState(200);
						result.setData(payWxDto);
					}else{
						result.setMessage(EWarning.OrderAccountError.getName());
						result.setState(EWarning.OrderAccountError.getValue());
						result.setData(payWxDto);
					}
				}else{
					result.setMessage(EWarning.NoOrderInfo.getName());
					result.setState(EWarning.NoOrderInfo.getValue());
					result.setData(payWxDto);
				}
			}else{
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
				result.setData(payWxDto);
			}
		}catch(Exception e){
			logger.error("CheckPayWxIsSuccess error:{}", e.getMessage());
			result.setMessage(EWarning.Unknown.getName() + e.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}


	@ApiOperation(value = "支付宝预支付", httpMethod = "POST")
	@PostMapping(value = "/aliPayReady", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto aliPayReady(
			@RequestBody AlipayVo info) throws AlipayApiException {
		String out_trade_no = info.getOut_trade_no();
		String total_amount = info.getTotal_amount();
		RespBaseDto<Object> baseDto = new RespBaseDto<>();
		String orderStr = "";
		try {
			FxSdCarriageOrder order = orderService.selectOrderByOrderSn(Long.parseLong(out_trade_no));
			if(order!=null&&order.getStatus()==1){
				BigDecimal orderTotalAccount = order.getDispatchPrice();

				int i = orderTotalAccount.compareTo(new BigDecimal(total_amount));
				if(i==0){
					//传入订单金额正确
					Map<String,String> orderMap = new LinkedHashMap<String,String>();            //订单实体
					Map<String,String> bizModel = new LinkedHashMap<String,String>();            //公共实体

					// 商户订单号，商户网站订单系统中唯一订单号，必填
					orderMap.put("out_trade_no",out_trade_no);
					// 订单名称，必填
					orderMap.put("subject","手机网站支付购买游戏币");
					// 付款金额，必填
					orderMap.put("total_amount",total_amount);
					// 商品描述，可空
					orderMap.put("body","您购买游戏币"+total_amount +"元");
					// 超时时间 可空
					orderMap.put("timeout_express","5m");
					// 销售产品码 必填
					orderMap.put("product_code","QUICK_MSECURITY_PAY");

					/****** 2.商品参数封装结束 *****/

					/******--------------- 3.公共参数封装 开始 ------------------------*****/        //支付宝用
					//1.商户appid
					bizModel.put("app_id",AlipayConfig.APPID);
					//2.请求网关地址
					bizModel.put("method",AlipayConfig.URL);
					//3.请求格式
					bizModel.put("format",AlipayConfig.FORMAT);
					//4.回调地址
					bizModel.put("return_url",AlipayConfig.return_url);
					//5.私钥
					bizModel.put("private_key",AlipayConfig.ALIPAY_PRIVATE_KEY);
					//6.商家id
					bizModel.put("seller_id","2088102170411333");
					//7.加密格式
					bizModel.put("sign_type",AlipayConfig.SIGNTYPE+"");
					//8.回调地址
					bizModel.put("notify_url",AlipayConfig.notify_url);

					/******--------------- 3.公共参数封装 结束 ------------------------*****/
					//实例化客户端
					AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",
							AlipayConfig.APPID, AlipayConfig.ALIPAY_PRIVATE_KEY, "json", AlipayConfig.CHARSET, AlipayConfig.ALIPAY_KEY, "RSA2");
					//实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
					AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
					//SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
					AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
					model.setBody("帮我买-帮我取-帮我送");
					model.setSubject("成都小短腿");
					model.setOutTradeNo(out_trade_no);//更换为自己的订单编号
					model.setTimeoutExpress("5m");
					model.setTotalAmount(total_amount);//订单价格
					model.setProductCode("QUICK_MSECURITY_PAY");
					request.setBizModel(model);
					request.setNotifyUrl("http://211.149.164.182:8081/api/pay/notify");//回调地址不可以带参数
					//String orderStr = "";
					try {
						//这里和普通的接口调用不同，使用的是sdkExecute
						AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
						orderStr = response.getBody();
						System.out.println(orderStr);//就是orderString 可以直接给客户端请求，无需再做处理。
					} catch (AlipayApiException e) {
						e.printStackTrace();
					}
					baseDto.setMessage("订单生成成功");
					baseDto.setState(200);
					baseDto.setData(orderStr);
				//订单号不存在
				}else{
					baseDto.setMessage(EWarning.OrderAccountError.getName());
					baseDto.setState(EWarning.OrderAccountError.getValue());
					baseDto.setData(orderStr);
				}
			}else{
				baseDto.setMessage(EWarning.NoOrderInfo.getName());
				baseDto.setState(EWarning.NoOrderInfo.getValue());
				baseDto.setData(orderStr);
			}
		} catch (Exception e) {
			baseDto.setMessage("订单生成失败");
			baseDto.setState(400);
			baseDto.setData(orderStr);
		}

		return baseDto;
	}

	/**
	 * 支付宝支付成功后.回调该接口

	 */

	@RequestMapping(value="/notify",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String notify(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Map<String, String> params = new HashMap<>();
		//Trade trade =null;
		//1.从支付宝回调的request域中取值
		Map<String, String[]> requestParams2 = request.getParameterMap();

		for (Iterator<String> iter = requestParams2.keySet().iterator(); iter.hasNext();) {
			String name = iter.next();
			String[] values = requestParams2.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			// valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
			params.put(name, valueStr);
		}
		//2.封装必须参数
		String out_trade_no = request.getParameter("out_trade_no");            // 商户订单号
		String orderType = request.getParameter("body");                    // 订单内容
		String tradeStatus = request.getParameter("trade_status");            //交易状态
		String tradeNo = request.getParameter("trade_no");
		System.out.println("orderType:"+orderType);
		System.out.println("tradeNo:"+tradeNo);

		//3.签名验证(对支付宝返回的数据验证，确定是支付宝返回的)
		boolean signVerified = false;
		try {
			//3.1调用SDK验证签名
			signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.ALIPAY_KEY, AlipayConfig.CHARSET, AlipayConfig.SIGNTYPE);
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		//4.对验签进行处理
		if (signVerified) {    //验签通过
			if(tradeStatus.equals("TRADE_SUCCESS")) {    //只处理支付成功的订单: 修改交易表状态,支付成功
				FxSdCarriageOrder order = orderService.selectOrderByOrdersn(out_trade_no);
				if(order!=null){
					FxSdUserMember fxSdUserMember = userService.selectUserByUserId(order.getMemberId() + "");
					order.setStatus((byte)2);
					order.setPayType((byte)22);
					System.out.println(tradeNo);
					order.setTransId(tradeNo);
					orderService.updateOrder(order);
					//logger.info("订单号:"+out_trade_no+",订单状态修改成功 orderStatus:"+order.getStatus());
					logger.info("订单编号:"+order.getOrdersn()+",下单用户电话:"+fxSdUserMember.getMobile()+",收货人电话:"+order.getEndPhone()
							+",支付类型:"+order.getPayType()+",订单类型:"+order.getOrderType()+",运费:"+order.getDispatchPrice()+
							",小费:"+order.getTipPrice()+",第三方支付编号:"+order.getTransId()+",订单内容:"+order.getRemark()+
							",下单时间:"+order.getCreateTime()+",抢单时间:"+order.getOrderTime()+",订单状态:"+order.getStatus());
					return "success";
				}else{
					return "fail";
				}
			}else{
				return "fail";
			}
		} else {  //验签不通过
			System.err.println("验签失败");
			return "fail";
		}
	}


}
