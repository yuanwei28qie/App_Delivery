
package com.microsilver.mrcard.basicservice.controller;

import com.microsilver.mrcard.basicservice.common.Consts;
import com.microsilver.mrcard.basicservice.dto.*;
import com.microsilver.mrcard.basicservice.model.*;
import com.microsilver.mrcard.basicservice.model.enums.EWarning;
import com.microsilver.mrcard.basicservice.service.*;
import com.microsilver.mrcard.basicservice.utils.*;
import com.microsilver.mrcard.basicservice.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Api(value = "/api/superDeliveryOrder", description = "骑手订单相关功能API")
@Controller
@RequestMapping(value = "/api/superDeliveryOrder")
@SuppressWarnings("unchecked")
@Transactional
public class SuperDeliveryOrderController  extends BaseController{
	
	@Resource
	private SuperDeliveryOrderService superDeliveryOrderService;
	@Resource
	private UserService userService;
	@Resource
	private SuperDeliveryService superDeliveryService;
	@Resource
	private SuperDeliveryInfoService superDeliveryInfoService;
	@Resource
	private OrderService orderService;
	@Resource
	private StringRedisTemplate stringRedisTemplate;
	@Resource
	private RedisTemplate redisTemplate;
	@Resource
	private FinanceService financeService;
	@Resource
	private LevelService levelService;
	@Resource
	private AgentInfoService agentInfoService;


	@PostMapping(value = "/isWork",produces ="application/json;charset=UTF-8")
	@ApiOperation(value = "休息/开工", httpMethod = "POST")
	@ResponseBody
	public RespBaseDto<DeliveryIsWorkDto> isWork(
			@RequestBody DeliveryIsWorkVo deliveryIsWorkVo
	) {
		RespBaseDto<DeliveryIsWorkDto> result = new RespBaseDto<>();
		Integer superDeliveryId = deliveryIsWorkVo.getSuperDeliveryId();
		Integer isWork = deliveryIsWorkVo.getIsWork();
		DeliveryIsWorkDto dto = new DeliveryIsWorkDto();
		try {
			if(superDeliveryId!=null&&isWork!=null){
				FxSdUserDeliverinfo fxSdUserDeliverinfo = superDeliveryService.selectUserBysuperDeliveryId(superDeliveryId + "");
				if(fxSdUserDeliverinfo!=null){
					FxSdUserDeliverAdditional work = superDeliveryOrderService.isWork(superDeliveryId.longValue(), isWork.byteValue());
					System.out.println(work);
					if(work!=null){
						if(work.getIsWork()==0){
							if (fxSdUserDeliverinfo.getStates()==1){
								work.setIsWork((byte)1);
								superDeliveryOrderService.updateDeliveryAdditionalIsWork(work);
								dto.setIsWork(1);
								dto.setSuperDeliveryId(superDeliveryId);
								result.setData(dto);
								result.setState(200);
							}else{
								result.setMessage(EWarning.DeliveryDisable.getName());
								result.setState(EWarning.DeliveryDisable.getValue());
								result.setData(dto);
							}
						}else{
							work.setIsWork((byte)0);
							superDeliveryOrderService.updateDeliveryAdditionalIsWork(work);
							dto.setIsWork(0);
							dto.setSuperDeliveryId(superDeliveryId);
							result.setData(dto);
							result.setState(200);
						}
					}else{
						result.setMessage(EWarning.NonExistent.getName());
						result.setState(EWarning.NonExistent.getValue());
						result.setData(dto);
					}

				}else{
					result.setMessage(EWarning.NonExistent.getName());
					result.setState(EWarning.NonExistent.getValue());
					result.setData(dto);
				}
			}else{
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
				result.setData(dto);
			}
		}  catch (Exception e) {
			logger.error("isWork error:{}", e.getMessage());
			result.setMessage(EWarning.Unknown.getName());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	@PostMapping(value = "/getDeliveryLatLng",produces ="application/json;charset=UTF-8")
	@ApiOperation(value = "随时获取骑手的经纬度", httpMethod = "POST")
	@ResponseBody
	public RespBaseDto<DeliveryLatLngDto> getDeliveryLatLng(
			@RequestBody DeliveryLatLngVo deliveryLatLngVo
	) {
		RespBaseDto<DeliveryLatLngDto> result = new RespBaseDto<>();
		Integer deliveryId = deliveryLatLngVo.getId();
		Double lat = deliveryLatLngVo.getLat();
		Double lng = deliveryLatLngVo.getLng();
		DeliveryLatLngDto dto = new DeliveryLatLngDto();
		try {
			FxSdUserDeliverAdditional additional = superDeliveryInfoService.selectInfoByDelivery(deliveryId.longValue());
			if(additional!=null){
				additional.setLng(lng+"");
				additional.setLat(lat+"");
				superDeliveryInfoService.updateDeliveryWork(additional);
				dto.setId(deliveryId);
				dto.setLat(lat);
				dto.setLng(lng);
				result.setState(200);
				result.setMessage("ok");
				result.setData(dto);
			}else{
				result.setState(EWarning.NonExistent.getValue());
				result.setMessage(EWarning.NonExistent.getName());
				result.setData(dto);
			}
		}  catch (Exception e) {
			logger.error("getDeliveryLatLng error:{}", e.getMessage());
			result.setMessage(EWarning.Unknown.getName());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}




	@PostMapping(value = "/getUserReleaseOrder",produces ="application/json;charset=UTF-8")
	@ApiOperation(value = "骑手获取用户已发布订单", httpMethod = "POST")
	@ResponseBody
	public RespBaseDto<List<OrderDto>> getUserReleaseOrder(
			@RequestBody DeliveryPageVo deliveryPageVo
	) {
		RespBaseDto<List<OrderDto>> result = new RespBaseDto<>();
		Integer currentPage = deliveryPageVo.getCurrentPage();
		Integer pageSize = deliveryPageVo.getPageSize();
		Integer areaCode = deliveryPageVo.getAreaCode();
		List<OrderDto> listOrders = new ArrayList<>();
		try {
			if(currentPage!=null&&pageSize!=null&&areaCode!=null){
				List<FxSdCarriageOrder> list = orderService.selectOrderByPageAndOrderByTime(areaCode,currentPage,pageSize);
				if(list!=null){
					for (FxSdCarriageOrder orders:
							list) {
						//待抢单
							OrderDto orderDto = new OrderDto();
							addOrderSn(orders.getMemberId()+"", orderDto, orders);
							listOrders.add(orderDto);
					}
					result.setData(listOrders);
					result.setMessage("ok");
					result.setState(200);
				}else{
					result.setMessage(EWarning.NoOrderInfo.getName());
					result.setState(EWarning.NoOrderInfo.getValue());
					result.setData(listOrders);
				}
			}else{
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
				result.setData(listOrders);
			}
		}  catch (Exception e) {
			logger.error("getUserReleaseOrder  error:{}", e.getMessage());
			result.setMessage(EWarning.Unknown.getName());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	@ApiOperation(value = "骑手抢单", httpMethod = "POST")
	@PostMapping(value = "/deliveryRobbOrder", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto<ReceiptDto> deliveryRobbOrder(
			@RequestBody DeliveryRobbOrderVo deliveryRobbOrderVo
	) {
		RespBaseDto<ReceiptDto> result = new RespBaseDto<>();
		ReceiptDto receiptDto = new ReceiptDto();
		try {
			Integer orderId = deliveryRobbOrderVo.getOrderId();
			Long orderSn = deliveryRobbOrderVo.getOrderSn();
			Integer deliveryId = deliveryRobbOrderVo.getDeliveryId();
			if(orderId!=null&&orderSn!=null&&deliveryId!=null){
				FxSdCarriageOrder order = orderService.selectOrderByOrderIdAndOrderSn(orderId, orderSn);
				FxSdUserDeliverAdditional info = superDeliveryOrderService.selectDeliveryInfo(deliveryId);
				FxSdUserDeliverinfo fxSdUserDeliverinfo = superDeliveryService.selectUserBysuperDeliveryId(deliveryId + "");
				if(order!=null&&info!=null&&fxSdUserDeliverinfo!=null&& fxSdUserDeliverinfo.getStates()==1){
					if(order.getDeliverId()==null){
						//修改订单状态,骑手id添加进订单
						order.setDeliverId(deliveryId.longValue());
						order.setStatus((byte)3);
						order.setOrderTime(Integer.parseInt(String.valueOf(System.currentTimeMillis()/1000)));
						int i = orderService.updateOrder(order);
						if(i==1){
							FxSdUserMember fxSdUserMember = userService.selectUserByUserId(order.getMemberId() + "");
							if(fxSdUserMember!=null){
								//返回信息
								receiptDto.setStartAddress(order.getStartAddress());
								receiptDto.setDeliveryPhone(Long.parseLong(fxSdUserDeliverinfo.getMobile()));
								receiptDto.setStartPhone(Long.parseLong(order.getStartPhone()));
								receiptDto.setStartName(order.getStartName());
								receiptDto.setEndAddress(order.getEndAddress());
								receiptDto.setMileages(order.getMileages());
								receiptDto.setDeliveryId(deliveryId);
								receiptDto.setExpectedTime((long)order.getCreateTime()+60*12);
								receiptDto.setOrderId(orderId);
								receiptDto.setOrderSn(orderSn);
								receiptDto.setEndName(order.getEndName());
								receiptDto.setEndPhone(Long.parseLong(order.getEndPhone()));
								receiptDto.setUserId(order.getMemberId().intValue());
								receiptDto.setEndLngLat(order.getEndLng()+","+order.getEndLat());
								receiptDto.setStartLngLat(order.getStartLng()+","+order.getStartLat());
								receiptDto.setRemark(order.getRemark());
								receiptDto.setGoodsRemark(order.getGoodsRemark());
								//骑手接单,给收货人发送验证码
								// 生成验证码
								String substring = (Math.random() + "").substring(2, 8);
								MobileCheckCode mobileCheckCode = new MobileCheckCode();
								mobileCheckCode.setCheckCode(Integer.parseInt(substring));
								mobileCheckCode.setMobile(Long.parseLong(order.getEndPhone()));
								mobileCheckCode.setType((short)4);
								redisTemplate.opsForValue().set(order.getEndPhone(),mobileCheckCode,60*60,TimeUnit.SECONDS);
								JuheMsg.sendMsg(order.getEndPhone(),substring);
								//redisTemplate.opsForValue().set(order.getEndPhone(), substring);
								//抢单成功后给用户发送信息
								int type = 1;
								switch(order.getOrderType()){
									case 1:
										//帮我买
										type = 1;
										break;
									case 2:
										//帮我取
										type = 4;
										break;
									case 3:
										//帮我送
										type = 7;
										break;
									default:
									type = 0;
									break;
								}
								JuheMsg.sendUserOfOrderStatus(fxSdUserMember.getMobile(),order.getOrdersn(),Long.parseLong(fxSdUserDeliverinfo.getMobile()),type);
								result.setMessage("ok");
								result.setState(200);
								result.setData(receiptDto);
							}else{
								//抢单失败
								result.setMessage(EWarning.RobbOrderError.getName());
								result.setState(EWarning.RobbOrderError.getValue());
								result.setData(receiptDto);
							}
						}else{
							//抢单失败
							result.setMessage(EWarning.RobbOrderError.getName());
							result.setState(EWarning.RobbOrderError.getValue());
							result.setData(receiptDto);
						}
					}else{
						//抢单失败
						result.setMessage(EWarning.RobbOrderError.getName());
						result.setState(EWarning.RobbOrderError.getValue());
						result.setData(receiptDto);
					}

				}else{
					result.setMessage(EWarning.RobbOrderError.getName());
					result.setState(EWarning.RobbOrderError.getValue());
					result.setData(receiptDto);
				}
			}else{
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
				result.setData(receiptDto);
			}
		} catch (Exception ex) {
			logger.error("deliveryRobbOrder error:{}", ex.getMessage());
			result.setMessage(EWarning.Unknown.getName() + ex.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}




	@ApiOperation(value = "骑手取货成功", httpMethod = "POST")
	@PostMapping(value = "/deliveryGetGoods", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto<OrderStatusDto> deliveryGetGoods(
			@RequestBody DeliveryRobbOrderVo deliveryRobbOrderVo
	) {
		RespBaseDto<OrderStatusDto> result = new RespBaseDto<>();
		OrderStatusDto OrderStatusDto = new OrderStatusDto();
		try {
			Integer orderId = deliveryRobbOrderVo.getOrderId();
			Long orderSn = deliveryRobbOrderVo.getOrderSn();
			Integer deliveryId = deliveryRobbOrderVo.getDeliveryId();
			if(orderId!=null&&orderSn!=null&&deliveryId!=null){
				FxSdCarriageOrder order = orderService.selectOrderByOrderIdAndOrderSnAndDeliveryId(orderId, orderSn,deliveryId);
				if(order!=null){
					order.setStatus((byte)4);
					int i = orderService.updateOrder(order);
					if(i==1){
						FxSdUserMember fxSdUserMember = userService.selectUserByUserId(order.getMemberId() + "");
						FxSdUserDeliverinfo fxSdUserDeliverinfo = superDeliveryService.selectUserBysuperDeliveryId(deliveryId + "");
						if(fxSdUserMember!=null&&fxSdUserDeliverinfo!=null){
							OrderStatusDto.setStatus((byte)4);
							OrderStatusDto.setDeliveryId(deliveryId);
							OrderStatusDto.setOrderId(orderId);
							OrderStatusDto.setOrderSn(orderSn);
							OrderStatusDto.setUserId(order.getMemberId().intValue());
							OrderStatusDto.setRemark(order.getRemark());
							OrderStatusDto.setGoodsRemark(order.getGoodsRemark());
							//给用户发送短信取货成功
							int type = 1;
							switch(order.getOrderType()){
								case 1:
									//帮我买
									type = 2;
									break;
								case 2:
									//帮我取
									type = 5;
									break;
								case 3:
									//帮我送
									type = 8;
									break;
								default:
									type = 0;
									break;
							}
							JuheMsg.sendUserOfOrderStatus(fxSdUserMember.getMobile(),order.getOrdersn(),Long.parseLong(fxSdUserDeliverinfo.getMobile()),type);
							result.setData(OrderStatusDto);
							result.setMessage("ok");
							result.setState(200);
						}else{
							result.setMessage(EWarning.OperationFailed.getName());
							result.setState(EWarning.OperationFailed.getValue());
							result.setData(OrderStatusDto);
						}
					}else{
						result.setMessage(EWarning.OperationFailed.getName());
						result.setState(EWarning.OperationFailed.getValue());
						result.setData(OrderStatusDto);
					}
				}else{
					result.setMessage(EWarning.NoOrderInfo.getName());
					result.setState(EWarning.NoOrderInfo.getValue());
					result.setData(OrderStatusDto);
				}
			}else{
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
				result.setData(OrderStatusDto);
			}
		} catch (Exception ex) {
			logger.error("deliveryGetGoods error:{}", ex.getMessage());
			result.setMessage(EWarning.Unknown.getName() + ex.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	@ApiOperation(value = "骑手确定收货", httpMethod = "POST")
	@PostMapping(value = "/deliveryConfirmGoods", produces = "application/json;charset=UTF-8")
	@ResponseBody
	@Transactional
	public RespBaseDto<OrderConfirmDto> deliveryConfirmGoods(
			@RequestBody OrderConfirmGoodsVo orderConfirmGoodsVo
	) {
		RespBaseDto<OrderConfirmDto> result = new RespBaseDto<>();
		OrderConfirmDto orderConfirmDto = new OrderConfirmDto();
		try {
			Integer orderId = orderConfirmGoodsVo.getOrderId();
			Long orderSn = orderConfirmGoodsVo.getOrderSn();
			Integer deliveryId = orderConfirmGoodsVo.getDeliveryId();
			Integer userId = orderConfirmGoodsVo.getUserId();
			Integer checkCode = orderConfirmGoodsVo.getCheckCode();
			if(orderId!=null&&orderSn!=null&&deliveryId!=null&&userId!=null&&checkCode!=null){
				FxSdCarriageOrder order = orderService.selectOrderByOrderIdAndOrderSnAndDeliveryId(orderId, orderSn,deliveryId);
				FxSdUserMember fxSdUserMember = userService.selectUserByUserId(userId.toString());
				FxSdUserDeliverinfo delivery = superDeliveryService.selectUserBysuperDeliveryId(deliveryId + "");
				if(order!=null&&fxSdUserMember!=null&&delivery!=null){
					//String redisCheckCode = stringRedisTemplate.opsForValue().get(order.getEndPhone() + "");
					MobileCheckCode mobileCheckCode = (MobileCheckCode) redisTemplate.opsForValue().get(order.getEndPhone());
					int redisCheckCode = mobileCheckCode.getCheckCode();
					short typeCheckCode = mobileCheckCode.getType();
					if(typeCheckCode==4){
						if(redisCheckCode==checkCode){
							order.setStatus((byte)5);
							Integer orderTime = order.getOrderTime();
							int nowTime = (int)System.currentTimeMillis() / 1000;
							int moreTime = nowTime - orderTime;
							//默认一个小时
							if(moreTime>60*60){
								//订单超出时间
								order.setExpiredTime(moreTime/60);
							}
							int i = orderService.updateOrder(order);
							//更新订单状态成功
							if(i==1){
								//获取订单中总金额
								BigDecimal orderTotalAccount = order.getDispatchPrice();
								System.out.println("orderTotalAccount:"+orderTotalAccount);
								//分润比例
									//骑手所获金额
								BigDecimal deliveryAccount = orderTotalAccount.multiply(new BigDecimal(Consts.DELIVERY_PROPORTION));
									//代理商所获金额
								BigDecimal agentAccount = orderTotalAccount.multiply(new BigDecimal(Consts.AGENT_PROPORTION));
									//平台所获金额
								BigDecimal platformAccount = orderTotalAccount.multiply(new BigDecimal(Consts.PLATFORM_PROPORTION));
								//存入数据库中
								//代理商财务流水
								FxSdUserAgentinfo agent = agentInfoService.selectAgentByAreaCode(order.getAreaCode());
								if(agent!=null){
									//查询代理商的财务表
									FxSdFinanceCustomer financeAgent = financeService.selectFinance(3, agent.getMobile());
									if(financeAgent!=null){
										//代理商可提现金额
										BigDecimal agentRealAccount = financeAgent.getRealAmount().add(agentAccount);
										financeAgent.setRealAmount(agentRealAccount);
										financeAgent.setTotalAmount(agentRealAccount);
										//更新代理商财务库
										financeService.updateFinance(financeAgent);
										//添加流水
										FxSdFinanceFlow flow = new FxSdFinanceFlow();
										flow.setFinanceId(financeAgent.getId());
										flow.setChangeTime(Integer.parseInt(String.valueOf(System.currentTimeMillis()/1000)));
										flow.setAmount(agentAccount);
										flow.setAmountType(1);
										flow.setSource(0);
										flow.setOrderId(Long.parseLong(order.getOrdersn()));
										//插入流水
										financeService.insertFinanceFlow(flow);
									}else{

										result.setMessage(EWarning.AgentNoFinanceMsg.getName());
										result.setState(EWarning.AgentNoFinanceMsg.getValue());
										result.setData(orderConfirmDto);
									}
								}else{
									result.setMessage(EWarning.NoAgent.getName());
									result.setState(EWarning.NoAgent.getValue());
									result.setData(orderConfirmDto);
								}
								//骑手财务流水
								FxSdFinanceCustomer financeDelivery = financeService.selectFinance(2, delivery.getMobile());
								if(financeDelivery!=null){
									BigDecimal deliveryRealAccount = financeDelivery.getRealAmount().add(deliveryAccount);
									financeDelivery.setRealAmount(deliveryRealAccount);
									financeDelivery.setTotalAmount(deliveryRealAccount.add(financeDelivery.getOtherAmount()));
									//更新骑手财务
									financeService.updateFinance(financeDelivery);
									//添加流水
									FxSdFinanceFlow flow = new FxSdFinanceFlow();
									flow.setFinanceId(financeDelivery.getId());
									flow.setChangeTime(Integer.parseInt(String.valueOf(System.currentTimeMillis()/1000)));
									flow.setAmount(deliveryAccount);
									flow.setAmountType(1);
									flow.setSource(0);
									flow.setOrderId(Long.parseLong(order.getOrdersn()));
									//插入流水
									financeService.insertFinanceFlow(flow);
								}else{
									result.setMessage(EWarning.DeliveryNoFinanceMsg.getName());
									result.setState(EWarning.DeliveryNoFinanceMsg.getValue());
									result.setData(orderConfirmDto);
								}

								//平台财务流水
								FxSdFinanceCustomer platFormFinance = financeService.selectFinance(4, Consts.PLATfORMPHONE+"");
								if(platFormFinance!=null){
									platFormFinance.setTotalAmount(platFormFinance.getTotalAmount().add(platformAccount));
									//更新平台财务
									financeService.updateFinance(platFormFinance);
									//添加流水
									FxSdFinanceFlow flow = new FxSdFinanceFlow();
									flow.setFinanceId(platFormFinance.getId());
									flow.setChangeTime(Integer.parseInt(String.valueOf(System.currentTimeMillis()/1000)));
									flow.setAmount(platformAccount);
									flow.setAmountType(1);
									flow.setSource(0);
									flow.setOrderId(Long.parseLong(order.getOrdersn()));
									//插入流水
									financeService.insertFinanceFlow(flow);
								}else{
									result.setMessage(EWarning.PlatFormNoFinanceMsg.getName());
									result.setState(EWarning.PlatFormNoFinanceMsg.getValue());
									result.setData(orderConfirmDto);
								}
								//写入收货地址的经纬度给骑手工作状态表中
								FxSdUserDeliverAdditional deliveryWork = superDeliveryInfoService.selectInfoByDelivery(deliveryId.longValue());
								deliveryWork.setLat(order.getEndLat());
								deliveryWork.setLng(order.getEndLng());
								superDeliveryInfoService.updateDeliveryWork(deliveryWork);

								orderConfirmDto.setStatus((byte)5);
								orderConfirmDto.setDeliveryId(deliveryId);
								orderConfirmDto.setOrderId(orderId);
								orderConfirmDto.setOrderSn(orderSn);
								orderConfirmDto.setUserId(order.getMemberId().intValue());
								orderConfirmDto.setUserMobile(Long.parseLong(fxSdUserMember.getMobile()));
								orderConfirmDto.setAvatar(fxSdUserMember.getAvatar());
								orderConfirmDto.setUserName(fxSdUserMember.getNickname());
								orderConfirmDto.setUserScore(fxSdUserMember.getLevelScore());
								orderConfirmDto.setOrderSumAccount(order.getDispatchPrice().add(order.getTipPrice()).doubleValue());
								//给用户发短信
								int type = 1;
								switch(order.getOrderType()){
									case 1:
										//帮我买
										type = 3;
										break;
									case 2:
										//帮我取
										type = 6;
										break;
									case 3:
										//帮我送
										type = 9;
										break;
									default:
										type = 0;
										break;
								}
								JuheMsg.sendUserOfOrderStatus(fxSdUserMember.getMobile(),order.getOrdersn(),Long.parseLong(delivery.getMobile()),type);
								result.setData(orderConfirmDto);
								result.setMessage("ok");
								result.setState(200);
							}else{
								result.setMessage(EWarning.OperationFailed.getName());
								result.setState(EWarning.OperationFailed.getValue());
								result.setData(orderConfirmDto);
							}
						}else{
							result.setMessage(EWarning.CheckCodeError.getName());
							result.setState(EWarning.CheckCodeError.getValue());
							result.setData(orderConfirmDto);
						}
					}else{
						result.setMessage(EWarning.CheckCodeTypeNotSame.getName());
						result.setState(EWarning.CheckCodeTypeNotSame.getValue());
						result.setData(orderConfirmDto);
					}
				}else{
					result.setMessage(EWarning.NoOrderInfo.getName());
					result.setState(EWarning.NoOrderInfo.getValue());
					result.setData(orderConfirmDto);
				}
			}else{
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
				result.setData(orderConfirmDto);
			}
		} catch (Exception ex) {
			logger.error("deliveryConfirmGoods error:{}", ex.getMessage());
			result.setMessage(EWarning.Unknown.getName() + ex.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	@ApiOperation(value = "骑手评价用户",httpMethod = "POST")
	@PostMapping(value = "/deliveryEvaluateUser",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto<DeliveryScoreDto> deliveryEvaluateUser(
			@RequestBody EvaluateVo EvaluateVo
	){
		RespBaseDto<DeliveryScoreDto> result = new RespBaseDto<>();
		DeliveryScoreDto dto = new DeliveryScoreDto();
		try{
			//订单id
			Integer orderId = EvaluateVo.getOrderId();
			//星星级别
			Integer starLevel =EvaluateVo.getStarLevel();
			//评价类型
			Short evaluateType =EvaluateVo.getEvaluateType();
			//备注
			String remake =EvaluateVo.getRemark();
			//用户id
			Integer userId =EvaluateVo.getUserId();
			//骑手id
			Integer deliveryId =EvaluateVo.getDeliveryId();
			if(orderId!=null && starLevel!=null && evaluateType!=null &&remake!=null&&userId!=null&&deliveryId!=null){
				//写用户评分
				FxSdUserDeliverinfo delivery = superDeliveryService.selectUserBysuperDeliveryId(deliveryId + "");
				FxSdUserMember user = userService.selectUserByUserId(userId + "");
				FxSdCarriageOrder fxSdCarriageOrder = orderService.selectOrderByOrderId(orderId);
				FxSdSysLevelsetting level = levelService.selectByUserId(userId);
				int i = orderService.selectOrderCountByUserId(userId);
				if(user!=null && i!=-1 && delivery!=null){
					//写等级表中
					if(level==null){
						FxSdSysLevelsetting levelSetting = new FxSdSysLevelsetting();
						levelSetting.setUserId(userId);
						levelSetting.setTotalStarScore(starLevel);
						levelSetting.setServiceScore(new BigDecimal(starLevel/2.0).setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue());
						levelService.insertInto(levelSetting);
						dto.setServiceScore(5.0);
					}else{
						int totalStar = level.getTotalStarScore() + starLevel;
						double a = new BigDecimal(totalStar / i/2.0).setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();
						level.setServiceScore(a);
						level.setTotalStarScore(totalStar);
						levelService.updateLevel(level);
						dto.setServiceScore(level.getServiceScore());
					}
					//写订单中
					if(fxSdCarriageOrder!=null){
						fxSdCarriageOrder.setDeliverAppraise((byte)1);
						fxSdCarriageOrder.setDeliverAppraiseDesc(remake);
						fxSdCarriageOrder.setDeliverAppraiseScore(starLevel.byteValue());
						fxSdCarriageOrder.setDeliveryAppraiseType(evaluateType);
						fxSdCarriageOrder.setStatus((byte)6);
						orderService.updateOrder(fxSdCarriageOrder);
						dto.setDeliveryId(deliveryId);
						dto.setDeliveryRaiseType(evaluateType.byteValue());
						dto.setLevelScore(80.0);
						dto.setOrderCount(i);
						dto.setOrderId(orderId);

						dto.setStarLevel(starLevel);
						dto.setUserId(userId);
						result.setData(dto);
						result.setState(200);
					}else{
						result.setMessage(EWarning.NoOrderInfo.getName());
						result.setState(EWarning.NoOrderInfo.getValue());
						result.setData(dto);
					}
				}else {
					result.setMessage(EWarning.NonExistent.getName());
					result.setState(EWarning.NonExistent.getValue());
					result.setData(dto);
				}
			}else{
				result.setMessage(EWarning.NonExistent.getName());
				result.setState(EWarning.NonExistent.getValue());
				result.setData(dto);
			}
		}catch(Exception ex){
			logger.error("deliveryEvaluateUser error:{}", ex.getMessage());
			result.setMessage(EWarning.Unknown.getName() + ex.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}


	@ApiOperation(value = "骑手提交提现申请", httpMethod = "POST")
	@PostMapping(value = "/deliveryRequestWithdrawal", produces = "application/json;charset=UTF-8")
	@ResponseBody
	@Transactional
	public RespBaseDto<DeliveryWithDrawDto> deliveryRequestWithdrawal(
			@RequestBody DeliveryWithDrawalVo deliveryWithDrawalVo
	) {
		RespBaseDto<DeliveryWithDrawDto> result = new RespBaseDto<>();
		DeliveryWithDrawDto deliveryWithDrawDto = new DeliveryWithDrawDto();
		Long deliveryMobile = deliveryWithDrawalVo.getDeliveryMobile();
		Double drawAccount = deliveryWithDrawalVo.getDrawAccount();
		String aliPayAccount = deliveryWithDrawalVo.getAliPayAccount();
		//骑手id;骑手支付宝账号;提现金额;
		try {
			if(deliveryMobile!=null&&drawAccount!=null&&aliPayAccount!=null&&!aliPayAccount.equals("")){
				String weekDayString = WeekDay.getWeekDayString();
				//每周二早上八点到下午十点才可以提交提现申请
				boolean inDate = TwoDateBetween.isInDate(new Date(), "00:00:00", "23:59:59");
				//weekDayString!=null&&weekDayString.equals("星期二")&&inDate
				if(weekDayString!=null&&weekDayString.equals("星期二")&&inDate){
					//查询财务表中余额中是否还有
					FxSdFinanceCustomer customer = new FxSdFinanceCustomer();
					customer.setUserType((byte)2);
					customer.setMobile(deliveryMobile+"");
					FxSdFinanceCustomer finance = financeService.selectAccountByUserIdAndUserType(customer);
					//查询该骑手的财务id
					FxSdUserDeliverinfo delivery = superDeliveryService.selectDeliveryBymobile(deliveryMobile);
					if(delivery!=null){
						if(delivery.getAlipayAccount().equals(aliPayAccount)){
							if(finance!=null&&finance.getStatus()==1){
								//可提现金额
								BigDecimal realAmount = finance.getRealAmount();
								BigDecimal decimal = new BigDecimal(drawAccount);
								int i = decimal.compareTo(realAmount);
								if(i>0){
									//不可以提现
									result.setMessage(EWarning.BalanceNotEnough.getName());
									result.setState(EWarning.BalanceNotEnough.getValue());
									result.setData(deliveryWithDrawDto);
								}else{
									//提交申请提现,即扣除用户提现金额,如果不同意,则由管理后台返回数据;
									//提现之后的金额
									BigDecimal subtract = realAmount.subtract(new BigDecimal(drawAccount));
									finance.setRealAmount(subtract);
									finance.setTotalAmount(subtract.add(finance.getOtherAmount()));
									//finance.setAdvanceAmount(finance.getAdvanceAmount().add(new BigDecimal(drawAccount)));
									//更新财务库
									financeService.updateFinance(finance);
									//可以提现
									//修改提现表中的状态
									FxSdWithdraw fxSdWithdraw = new FxSdWithdraw();
									fxSdWithdraw.setFinanceId(finance.getId());
									fxSdWithdraw.setAmount(new BigDecimal(drawAccount));
									//fxSdWithdraw.setBalance(finance.getRealAmount());
									String time = String.valueOf(System.currentTimeMillis() / 1000);
									fxSdWithdraw.setCreateTime(Integer.parseInt(time));
									fxSdWithdraw.setIsapproval(1);
									long l = new IdWorker().nextId();
									fxSdWithdraw.setWithdrawSn(l+"");
									//向提现表插入数据
									financeService.insertFinanceWithdraw(fxSdWithdraw);
									deliveryWithDrawDto.setBalanceAccount(finance.getRealAmount());
									deliveryWithDrawDto.setDeliveryMobile(deliveryMobile);
									deliveryWithDrawDto.setFinanceId(finance.getId().intValue());
									deliveryWithDrawDto.setStatus((short)1);
									deliveryWithDrawDto.setWithDrawId(fxSdWithdraw.getId().intValue());
									deliveryWithDrawDto.setWithDrawAccount(new BigDecimal(drawAccount));
									deliveryWithDrawDto.setWithDrawSn(l);
									result.setMessage("提交财务提现申请成功");
									result.setState(200);
									result.setData(deliveryWithDrawDto);
								}
							}else{
								result.setMessage(EWarning.NoFinanceMsg.getName());
								result.setState(EWarning.NoFinanceMsg.getValue());
							}
						} else{
							result.setMessage(EWarning.AliPayAccountError.getName());
							result.setState(EWarning.AliPayAccountError.getValue());
						}
					}else{
						result.setMessage(EWarning.NonExistent.getName());
						result.setState(EWarning.NonExistent.getValue());
					}
				}else{
					result.setMessage(EWarning.NotWithDrawDate.getName());
					result.setState(EWarning.NotWithDrawDate.getValue());
				}
			}else{
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
			}
		} catch (Exception ex) {
			logger.error("deliveryRequestWithdrawal error:{}", ex.getMessage());
			result.setMessage(EWarning.Unknown.getName() + ex.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	@ApiOperation(value = "骑手个人中心展示", httpMethod = "POST")
	@PostMapping(value = "/deliveryCenter", produces = "application/json;charset=UTF-8")
	@ResponseBody
	@Transactional
	public RespBaseDto<DeliveryCenterInfoDto> deliveryCenter(
			@RequestBody DeliveryGetInfoVo deliveryInfo
	) {
		RespBaseDto<DeliveryCenterInfoDto> result = new RespBaseDto<>();
		Integer deliveryId = deliveryInfo.getDeliveryId();
		DeliveryCenterInfoDto dto = new DeliveryCenterInfoDto();
		try {
			if(deliveryId!=null){
				int orderCount = 0;
				Map<String, BigDecimal> map = new HashMap<>();
				List<Double> list = new ArrayList();
				FxSdUserDeliverinfo delivery = superDeliveryService.selectUserBysuperDeliveryId(deliveryId + "");
				if(delivery!=null){
					//服务评分
					 Double levelScore = delivery.getLevelSocre();
					//今日完成订单数
					List<FxSdCarriageOrder> fxSdCarriageOrders = orderService.selectOrderByDelivery(deliveryId.longValue());
					System.out.println(fxSdCarriageOrders);
					if(fxSdCarriageOrders!=null){
						for (FxSdCarriageOrder orders:
						fxSdCarriageOrders) {
							Integer createTime = orders.getCreateTime();
							Date date = DateUnixTimeUtils.TimeStamp2Date(createTime + "");
							String format = DateUnixTimeUtils.format(date);
							if(format.equals("今天")){
								//今天的订单个数
								orderCount++;
								//今日收入
								BigDecimal once = orders.getDispatchPrice().multiply(new BigDecimal(Consts.DELIVERY_PROPORTION));
								//map.put("moneyToday",once);
								list.add(once.doubleValue());
								System.out.println(once);
							}
						}
						double sum =0;
						for (double a:
							 list) {
							sum+=a;
						}
						//System.out.println(orderCount);
						//System.out.println(map.get("moneyToday"));
						dto.setDeliveryId(deliveryId);
						dto.setMoneyToday(new BigDecimal(sum).setScale(2,BigDecimal.ROUND_HALF_UP));
						dto.setOrderCount(orderCount);
						dto.setServiceScore(levelScore);
						result.setData(dto);
						result.setState(200);
						result.setMessage("ok");
					}else{
						result.setMessage(EWarning.NoOrderInfo.getName());
						result.setState(EWarning.NoOrderInfo.getValue());
						result.setData(dto);
					}
				}else{
					result.setMessage(EWarning.NonExistent.getName());
					result.setState(EWarning.NonExistent.getValue());
					result.setData(dto);
				}
			}else{
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
				result.setData(dto);
			}
		} catch (Exception ex) {
			logger.error("deliveryCenter error:{}", ex.getMessage());
			result.setMessage(EWarning.Unknown.getName() + ex.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	@ApiOperation(value = "骑手个人中心详情", httpMethod = "POST")
	@PostMapping(value = "/deliveryCenterInfo", produces = "application/json;charset=UTF-8")
	@ResponseBody
	@Transactional
	public RespBaseDto<DeliveryCenterDto> deliveryCenterInfo(
			@RequestBody DeliveryGetInfoVo deliveryInfo
	) {
		RespBaseDto<DeliveryCenterDto> result = new RespBaseDto<>();
		Integer deliveryId = deliveryInfo.getDeliveryId();
		DeliveryCenterDto dto = new DeliveryCenterDto();
		List<Double> listOrder = new ArrayList();

		try {
			if(deliveryId!=null){
				FxSdUserDeliverinfo delivery = superDeliveryService.selectUserBysuperDeliveryId(deliveryId + "");
				if(delivery!=null){
					//签约状态
					Byte states = delivery.getStates();
					//骑手等级名称
					Double levelScore = delivery.getLevelSocre();
					//骑手头像
					String avatar = delivery.getAvatar();
					List<FxSdCarriageOrder> list = orderService.selectOrderByDelivery(deliveryId.longValue());
					FxSdFinanceCustomer finance = new FxSdFinanceCustomer();
					finance.setUserType((byte)2);
					finance.setMobile(delivery.getMobile());
					FxSdFinanceCustomer fxSdFinanceCustomer = financeService.selectAccountByUserIdAndUserType(finance);

					if(list!=null && fxSdFinanceCustomer!=null){
						double moneyNotToday =0.0;
						int orderCountToday=0;
						int orderCountNotToday=0;
						double mileageToday=0.0;
						double mileageNotToday=0.0;
						double moneyToday=0.0;
						int orderCount=0;
						for (FxSdCarriageOrder order:
						list) {
							Integer createTime = order.getCreateTime();
							Double mileages = order.getMileages();
							Date date = DateUnixTimeUtils.TimeStamp2Date(createTime + "");
							String format = DateUnixTimeUtils.format(date);
							if(format.equals("今天")){
								//今日收入
								orderCountToday++;
								mileageToday+=mileages;
								BigDecimal once = order.getDispatchPrice().multiply(new BigDecimal(Consts.DELIVERY_PROPORTION));
								double v = once.doubleValue();
								moneyToday+=v;
							}else{
								//不是今日收入
								orderCountNotToday++;
								mileageNotToday+=mileages;
								BigDecimal once = order.getDispatchPrice().multiply(new BigDecimal(Consts.DELIVERY_PROPORTION));
								double v = once.doubleValue();
								moneyNotToday+=v;
							}
						}
						//总的订单个数
						for (double a:
							 listOrder) {
							orderCount+=a;
						}
						//今日收益
						dto.setMoneyToday(new BigDecimal(moneyToday).setScale(2,BigDecimal.ROUND_HALF_UP));
						dto.setOrderCountToday(orderCountToday);
						dto.setDistanceToday(mileageToday);
						dto.setDistanceAll(mileageNotToday+mileageToday);
						dto.setMoneyAll(new BigDecimal(moneyNotToday).add(new BigDecimal(moneyToday)).setScale(2,BigDecimal.ROUND_HALF_UP));
						dto.setOrderCountAll(orderCountToday+orderCountNotToday);
						String s = deliveryId + "6658";
						delivery.setIdentifier(s);
						superDeliveryService.updateDelivery(delivery);
						dto.setDeliveryInvitationCode(Integer.parseInt(s));
						dto.setCreditScore(80.00);
						dto.setDeliveryId(deliveryId);
						dto.setDeliveryURL(avatar);
						dto.setLevelName("白金");
						dto.setStatus(states.shortValue());
						dto.setBalance(fxSdFinanceCustomer.getTotalAmount());
						result.setData(dto);
						result.setMessage("ok");
						result.setState(200);
					}else{
						result.setData(dto);
						result.setMessage(EWarning.NoOrderInfo.getName());
						result.setState(EWarning.NoOrderInfo.getValue());
					}
				}else{
					result.setData(dto);
					result.setMessage(EWarning.NonExistent.getName());
					result.setState(EWarning.NonExistent.getValue());
				}

			}else{
				result.setData(dto);
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
			}

		} catch (Exception ex) {
			logger.error("deliveryCenterInfo error:{}", ex.getMessage());
			result.setMessage(EWarning.Unknown.getName() + ex.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	@ApiOperation(value = "获取骑手所有订单", httpMethod = "POST")
	@PostMapping(value = "/getDeliveryAllOrders", produces = "application/json;charset=UTF-8")
	@ResponseBody
	@Transactional
	public RespBaseDto<List<OrderDto>> getDeliveryAllOrders(
			@RequestBody DeliveryOrderVo deliveryOrderVo
	) {
		RespBaseDto<List<OrderDto>> result = new RespBaseDto<>();
		Integer deliveryId = deliveryOrderVo.getDeliveryId();
		Integer currentPage = deliveryOrderVo.getCurrentPage();
		Integer areaCode = deliveryOrderVo.getAreaCode();
		Integer pageSize = deliveryOrderVo.getPageSize();
		List<OrderDto> listOrder = new ArrayList();
		try {
			//查询骑手订单
			List<FxSdCarriageOrder> orders = orderService.selectOrderByPageOfDeliveryId(currentPage, pageSize, deliveryId,areaCode);
			if(orders!=null){
				for (FxSdCarriageOrder order:
				orders) {
					OrderDto orderDto = new OrderDto();
					addOrderSn(order.getMemberId()+"",orderDto,order);
					listOrder.add(orderDto);
				}
				result.setData(listOrder);
				result.setState(200);
				result.setMessage("ok");
			}else{
				result.setData(listOrder);
				result.setState(EWarning.NoOrderInfo.getValue());
				result.setMessage(EWarning.NoOrderInfo.getName());
			}


		} catch (Exception ex) {
			logger.error("getDeliveryAllOrders error:{}", ex.getMessage());
			result.setMessage(EWarning.Unknown.getName() + ex.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}



	@ApiOperation(value = "获取骑手待评价订单", httpMethod = "POST")
	@PostMapping(value = "/getDeliveryWaitEvaluateOrders", produces = "application/json;charset=UTF-8")
	@ResponseBody
	@Transactional
	public RespBaseDto<List<OrderDto>> getDeliveryWaitEvaluateOrders(
			@RequestBody DeliveryOrderVo deliveryOrderVo
	) {
		RespBaseDto<List<OrderDto>> result = new RespBaseDto<>();
		Integer deliveryId = deliveryOrderVo.getDeliveryId();
		Integer currentPage = deliveryOrderVo.getCurrentPage();
		Integer areaCode = deliveryOrderVo.getAreaCode();
		Integer pageSize = deliveryOrderVo.getPageSize();
		List<OrderDto> listOrder = new ArrayList();
		try {
			//查询骑手订单
			List<FxSdCarriageOrder> orders = orderService.selectOrderByPageOfDeliveryId(currentPage, pageSize, deliveryId,areaCode);

			if(orders!=null){
				for (FxSdCarriageOrder order:
						orders) {
					System.out.println(orders);
					//获取待评价订单
					if(order.getStatus()==5){
						OrderDto orderDto = new OrderDto();
						addOrderSn(order.getMemberId()+"",orderDto,order);
						listOrder.add(orderDto);
					}
				}
				result.setData(listOrder);
				result.setState(200);
				result.setMessage("ok");
			}else{
				result.setData(listOrder);
				result.setState(EWarning.NoOrderInfo.getValue());
				result.setMessage(EWarning.NoOrderInfo.getName());
			}


		} catch (Exception ex) {
			logger.error("getDeliveryWaitEvaluateOrders error:{}", ex.getMessage());
			result.setMessage(EWarning.Unknown.getName() + ex.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}


	@ApiOperation(value = "获取骑手已完成订单", httpMethod = "POST")
	@PostMapping(value = "/getDeliveryFinishOrders", produces = "application/json;charset=UTF-8")
	@ResponseBody
	@Transactional
	public RespBaseDto<List<OrderDto>> getDeliveryFinishOrders(
			@RequestBody DeliveryOrderVo deliveryOrderVo
	) {
		RespBaseDto<List<OrderDto>> result = new RespBaseDto<>();
		Integer deliveryId = deliveryOrderVo.getDeliveryId();
		Integer currentPage = deliveryOrderVo.getCurrentPage();
		Integer areaCode = deliveryOrderVo.getAreaCode();
		Integer pageSize = deliveryOrderVo.getPageSize();
		List<OrderDto> listOrder = new ArrayList();
		try {
			//查询骑手订单
			List<FxSdCarriageOrder> orders = orderService.selectOrderByPageOfDeliveryId(currentPage, pageSize, deliveryId,areaCode);
			if(orders!=null){
				for (FxSdCarriageOrder order:
						orders) {
					//获取已完成订单
					if(order.getStatus()==5||order.getStatus()==6){
						OrderDto orderDto = new OrderDto();
						addOrderSn(order.getMemberId()+"",orderDto,order);
						listOrder.add(orderDto);
					}
				}
				result.setData(listOrder);
				result.setState(200);
				result.setMessage("ok");
			}else{
				result.setData(listOrder);
				result.setState(EWarning.NoOrderInfo.getValue());
				result.setMessage(EWarning.NoOrderInfo.getName());
			}


		} catch (Exception ex) {
			logger.error("getDeliveryFinishOrders error:{}", ex.getMessage());
			result.setMessage(EWarning.Unknown.getName() + ex.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}


	@ApiOperation(value = "获取骑手待取货,待确认收货详情", httpMethod = "POST")
	@PostMapping(value = "/getDeliveryOrderInfo", produces = "application/json;charset=UTF-8")
	@ResponseBody
	@Transactional
	public RespBaseDto<DeliveryInfoDto> getDeliveryOrderInfo(
			@RequestBody DeliveryRobbOrderVo deliveryRobbOrderVo
	) {
		RespBaseDto<DeliveryInfoDto> result = new RespBaseDto<>();
		Integer deliveryId = deliveryRobbOrderVo.getDeliveryId();
		Integer orderId = deliveryRobbOrderVo.getOrderId();
		Long orderSn = deliveryRobbOrderVo.getOrderSn();
		DeliveryInfoDto dto = new DeliveryInfoDto();
		try {
			//查询骑手订单
			FxSdCarriageOrder orders = orderService.selectOrderByOrderIdAndOrderSnAndDeliveryId(orderId, orderSn, deliveryId);
			if(orders!=null){
				//用户评分
				Long userId = orders.getMemberId();

				FxSdUserMember user = userService.selectUserByUserId(userId + "");
				System.out.println(user);
				FxSdSysLevelsetting levelsetting = levelService.selectByDliveryId(deliveryId);
				dto.setUserService(levelsetting.getServiceScore());
				if(user.getAvatar()!=null){
					dto.setAvatarUrl(user.getAvatar());
				}
				if(user.getNickname()!=null){
					dto.setUserNikeName(user.getNickname());
				}
				dto.setMobile(Long.parseLong(user.getMobile()));
				dto.setStatus(orders.getStatus().intValue());
				dto.setEndAddress(orders.getEndAddress());
				dto.setMileages(orders.getMileages());
				dto.setExpectedTime((long)orders.getCreateTime()+60*12);
				dto.setStartLngLat(orders.getStartLng()+","+orders.getStartLat());
				dto.setEndLngLat(orders.getEndLng()+","+orders.getEndLat());
				dto.setStartName(orders.getStartName());
				dto.setStartPhone(Long.parseLong(orders.getStartPhone()));
				dto.setEndName(orders.getEndName());
				dto.setEndPhone(Long.parseLong(orders.getEndPhone()));
				if(orders.getMemberId()!=null){
					dto.setUserId(orders.getMemberId().intValue());
				}
				dto.setDeliveryId(deliveryId);
				dto.setOrderId(orderId);
				dto.setOrderSn(Long.parseLong(orders.getOrdersn()));
				dto.setOrderAccount(orders.getDispatchPrice());
				dto.setRemark(orders.getRemark());
				dto.setGoodsRemark(orders.getGoodsRemark());

				result.setData(dto);
				result.setMessage("ok");
				result.setState(200);
			}else{
				result.setData(dto);
				result.setState(EWarning.NoOrderInfo.getValue());
				result.setMessage(EWarning.NoOrderInfo.getName());
			}


		} catch (Exception ex) {
			logger.error("getDeliveryOrderInfo error:{}", ex.getMessage());
			result.setMessage(EWarning.Unknown.getName() + ex.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	private void addOrderSn(String userId, OrderDto orderDto, FxSdCarriageOrder orders) {
		orderDto.setOrderSn(Long.parseLong(orders.getOrdersn()));
		orderDto.setOrderId(orders.getId().intValue());
		orderDto.setUserId(Integer.parseInt(userId));
		orderDto.setDispatchPrice(orders.getDispatchPrice());
		orderDto.setTipPrice(orders.getTipPrice());
		orderDto.setStartName(orders.getStartName());
		orderDto.setStartPhone(Long.parseLong(orders.getStartPhone()));
		orderDto.setStartAddress(orders.getStartAddress());
		orderDto.setStartLat(Double.parseDouble(orders.getStartLat()));
		orderDto.setStartLng(Double.parseDouble(orders.getStartLng()));
		orderDto.setEndName(orders.getEndName());
		orderDto.setEndPhone(Long.parseLong(orders.getEndPhone()));
		orderDto.setEndAddress(orders.getEndAddress());
		orderDto.setEndLat(Double.parseDouble(orders.getEndLat()));
		orderDto.setEndLng(Double.parseDouble(orders.getEndLng()));
		orderDto.setMileages(orders.getMileages());
		orderDto.setWeight(Integer.parseInt(orders.getWeight()+""));
		orderDto.setRemark(orders.getRemark());
		orderDto.setTotalCount(orders.getDispatchPrice().multiply(new BigDecimal(Consts.DELIVERY_PROPORTION)).setScale(2,BigDecimal.ROUND_HALF_UP));
		orderDto.setAreaCode(orders.getAreaCode());
		orderDto.setSourceType((int)orders.getSourceType());
		orderDto.setOrderType((int)orders.getOrderType());
		Integer createTime = orders.getCreateTime();
		String formats = "yyyy-MM-dd HH:mm:ss";
		Long timestamp = Long.parseLong(createTime+"") * 1000;
		String date = new SimpleDateFormat(formats, Locale.CHINA).format(new Date(timestamp));
		orderDto.setCreateTime(date);
		orderDto.setStatus((int)orders.getStatus());
		orderDto.setGoodsRemark(orders.getGoodsRemark());
		orderDto.setGoodsType(orders.getGoodsType());
	}
}
