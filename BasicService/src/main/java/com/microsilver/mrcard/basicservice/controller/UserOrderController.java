
package com.microsilver.mrcard.basicservice.controller;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.microsilver.mrcard.basicservice.config.AlipayConfig;
import com.microsilver.mrcard.basicservice.dto.*;
import com.microsilver.mrcard.basicservice.model.*;
import com.microsilver.mrcard.basicservice.model.enums.EWarning;
import com.microsilver.mrcard.basicservice.service.*;
import com.microsilver.mrcard.basicservice.utils.IdWorker;
import com.microsilver.mrcard.basicservice.utils.MapDistance;
import com.microsilver.mrcard.basicservice.utils.TimeBetween;
import com.microsilver.mrcard.basicservice.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;


@Api(value = "/api/userOrder", description = "用户订单相关接口")
@Controller
@RequestMapping(value = "/api/userOrder")
@SuppressWarnings("unchecked")
@Transactional
public class UserOrderController extends BaseController {

	private final OrderService orderService;

	private final UserService userService;

	private final UserCarriageDispatchService userCarriageDispatchService;

	private final SuperDeliveryOrderService superDeliveryOrderService;

	private final SuperDeliveryService superDeliveryService;

	private final FinanceService financeService;

	private final LevelService levelService;



	@Autowired
	public UserOrderController(OrderService orderService, UserService userService, UserCarriageDispatchService userCarriageDispatchService, SuperDeliveryOrderService superDeliveryOrderService, SuperDeliveryService superDeliveryService, FinanceService financeService, LevelService levelService) {
		this.orderService = orderService;
		this.userService = userService;
		this.userCarriageDispatchService = userCarriageDispatchService;
		this.superDeliveryOrderService = superDeliveryOrderService;
		this.superDeliveryService = superDeliveryService;
		this.financeService = financeService;
		this.levelService = levelService;
	}


	@ApiOperation(value = "创建订单", httpMethod = "POST")
	@PostMapping(value = "/createOrder", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto<OrderDto> createOrder(
			@RequestBody OrderCreateVo orderCreateVo
	) {
		RespBaseDto<OrderDto> result = new RespBaseDto<>();
		Integer userId = orderCreateVo.getUserId();
		BigDecimal dispatchPrice = orderCreateVo.getDispatchPrice();
		BigDecimal tipPrice = orderCreateVo.getTipPrice();
		String startName = orderCreateVo.getStartName();
		Long startPhone = orderCreateVo.getStartPhone();
		String startAddress = orderCreateVo.getStartAddress();
		Double startLat = orderCreateVo.getStartLat();
		Double startLng = orderCreateVo.getStartLng();
		String endName = orderCreateVo.getEndName();
		Long endPhone = orderCreateVo.getEndPhone();
		String endAddress = orderCreateVo.getEndAddress();
		Double endLat = orderCreateVo.getEndLat();
		Double endLng = orderCreateVo.getEndLng();
		Integer weight = orderCreateVo.getWeight();
		String remark = orderCreateVo.getRemark();
		Integer areaCode = orderCreateVo.getAreaCode();
		Short sourceType = orderCreateVo.getSourceType();
		Short orderType = orderCreateVo.getOrderType();
		Short goodsType = orderCreateVo.getGoodsType();
		String goodsRemark = orderCreateVo.getGoodsRemark();
		OrderDto orderDto = new OrderDto();
		try {
			//验证订单中运费是否一致
			//生成订单
			if (userId != null
					&& dispatchPrice != null
					&& tipPrice != null
					&& startName != null
					&& startPhone != null
					&& startAddress != null
					&& startLat != null
					&& startLng != null
					&& endName != null && !endName.equals("")
					&& endPhone != null
					&& endAddress != null && !endAddress.equals("")
					&& endLat != null
					&& endLng != null
					&& weight != null
					&& remark != null
					&& areaCode != null
					&& sourceType != null
					&& orderType != null
					&& goodsType != null
					&& goodsRemark != null
					) {
				//验证是否有改用户
				FxSdUserMember fxSdUserMember = userService.selectUserByUserId(userId + "");
				//检查是否开通区域
				FxSdSysCarriageDispatch fxSdSysCarriageDispatch = userCarriageDispatchService.selectDispatchByAreaId(areaCode.toString());
				if(fxSdSysCarriageDispatch!=null){
					if (fxSdUserMember != null && fxSdUserMember.getStatus()==1) {
						//校验运费
						OrderDispatchVo orderDispatchVo = new OrderDispatchVo();
						orderDispatchVo.setAreaCode(areaCode);
						orderDispatchVo.setEndLat(endLat);
						orderDispatchVo.setEndLng(endLng);
						orderDispatchVo.setStartLat(startLat);
						orderDispatchVo.setStartLng(startLng);
						orderDispatchVo.setWeight(weight);
						orderDispatchVo.setTipPrice(tipPrice.intValue());
						RespBaseDto<FreightDto> dispatchPriceDto = getDispatchPrice(orderDispatchVo);
						Integer sumBigDecimal = dispatchPriceDto.getData().getSumBigDecimal();
						//sumBigDecimal == dispatchPrice.intValue()
						//System.out.println("sumBigDecimal:"+sumBigDecimal);
						//System.out.println("dispatchPrice:"+dispatchPrice);
						if (sumBigDecimal == dispatchPrice.intValue()) {
							//if (true) {
							FxSdCarriageOrder order = new FxSdCarriageOrder();
							//订单用户id
							order.setMemberId(userId.longValue());
							//待支付状态
							order.setStatus((byte) 1);
							//订单号
							long orderSn = new IdWorker().nextId();
							order.setOrdersn(orderSn + "");
							order.setDispatchPrice(dispatchPrice);
							order.setTipPrice(tipPrice);
							order.setStartName(startName);
							order.setStartPhone(startPhone + "");
							order.setStartLat(startLat + "");
							order.setStartLng(startLng + "");
							order.setStartAddress(startAddress);
							order.setEndName(endName);
							order.setEndAddress(endAddress);
							order.setEndPhone(endPhone + "");
							order.setEndLat(endLat + "");
							order.setEndLng(endLng + "");
							//订单公里数
							String distance = MapDistance.getDistance(startLat + "", startLng + "", endLat + "", endLng + "");
							long round = Math.round(Double.parseDouble(distance));
							order.setMileages(new BigDecimal(round).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
							if(startLat==0.0||startLng==0.0){
								order.setMileages(3.0);
							}
							order.setWeight(weight);
							order.setRemark(remark);
							order.setAreaCode(areaCode);
							//订单来源(1:android,2:ios,3:微信)
							order.setSourceType(sourceType.byteValue());
							order.setOrderType(orderType.byteValue());
							String time = String.valueOf(System.currentTimeMillis() / 1000);
							order.setCreateTime(Integer.parseInt(time));
							order.setGoodsType(goodsType);
							order.setGoodsRemark(goodsRemark);
							//写库
							orderService.insertIntoAndReturnId(order);
							orderDto.setOrderSn(orderSn);
							orderDto.setOrderId(order.getId().intValue());
							orderDto.setUserId(userId);
							orderDto.setDispatchPrice(dispatchPrice);
							orderDto.setTipPrice(tipPrice);
							orderDto.setStartName(startName);
							orderDto.setStartPhone(startPhone);
							orderDto.setStartAddress(startAddress);
							orderDto.setStartLat(startLat);
							orderDto.setStartLng(startLng);
							orderDto.setEndName(endName);
							orderDto.setEndPhone(endPhone);
							orderDto.setEndAddress(endAddress);
							orderDto.setEndLat(endLat);
							orderDto.setEndLng(endLng);

							orderDto.setMileages(new BigDecimal(round).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
							if(startLat==0.0||startLng==0.0){
								orderDto.setMileages(3.0);
							}
							orderDto.setWeight(weight);
							orderDto.setRemark(remark);
							orderDto.setAreaCode(areaCode);
							orderDto.setSourceType(Integer.valueOf(sourceType));
							orderDto.setOrderType(Integer.valueOf(orderType));
							String formats = "yyyy-MM-dd HH:mm:ss";
							Long timestamp = Long.parseLong(time+"") * 1000;
							String date = new SimpleDateFormat(formats, Locale.CHINA).format(new Date(timestamp));
							orderDto.setCreateTime(date);
							orderDto.setStatus(1);
							//BigDecimal multiply = dispatchPrice.multiply(new BigDecimal(Consts.DELIVERY_PROPORTION));
							orderDto.setTotalCount(dispatchPrice);
							orderDto.setGoodsRemark(goodsRemark);
							orderDto.setGoodsType(goodsType);
							//订单十五分钟且无人接单后就取消订单


							/*JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");
							Jedis jedis = pool.getResource();
							jedis.auth("superShortLeg@2018");
							jedis.set(order.getOrdersn()+"", order.getStatus()+"");
							//60*15
							jedis.expire(order.getOrdersn()+"", 10);
							jedis.psubscribe(new KeyExpiredListener(), "__key*__:*");*/
							logger.info("订单编号:"+order.getOrdersn()+",下单用户电话:"+fxSdUserMember.getMobile()+",收货人电话:"+order.getEndPhone()
									+",支付类型:"+order.getPayType()+",订单类型:"+order.getOrderType()+",运费:"+order.getDispatchPrice()+
									",小费:"+order.getTipPrice()+",第三方支付编号:"+order.getTransId()+",订单内容:"+order.getRemark()+
									",下单时间:"+order.getCreateTime()+",抢单时间:"+order.getOrderTime()+",订单状态:"+order.getStatus());
							result.setMessage("ok");
							result.setState(200);
							result.setData(orderDto);
						} else {
							result.setMessage(EWarning.OrderAccountError.getName());
							result.setState(EWarning.OrderAccountError.getValue());
							result.setData(orderDto);
						}
					} else {
						result.setMessage(EWarning.NonExistent.getName());
						result.setState(EWarning.NonExistent.getValue());
						result.setData(orderDto);
					}
				}else{
					result.setMessage(EWarning.NoAreaMsg.getName());
					result.setState(EWarning.NoAreaMsg.getValue());
					result.setData(orderDto);
				}
			} else {
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
				result.setData(orderDto);
			}
		} catch (Exception e) {
			logger.error("createOrder error:{}", e.getMessage());
			result.setMessage(EWarning.Unknown.getName() + e.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}


	@ApiOperation(value = "获取用户所有订单", httpMethod = "POST")
	@PostMapping(value = "/getOrderInfo", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto<List<OrderDto>> getOrderInfo(
			@RequestBody OrderPageVo OrderPageVo
	) {
		RespBaseDto<List<OrderDto>> result = new RespBaseDto<>();
		Integer currentPage = OrderPageVo.getCurrentPage();
		Integer pageSize = OrderPageVo.getPageSize();
		Integer userId = OrderPageVo.getUserId();
		List<OrderDto> orderDtoList = new ArrayList<>();
		try {
			if (currentPage != null && userId != null && pageSize != null
					) {
				long userIdLong = userId.longValue();
				Byte status = 0;
				//通过页数查询多少条数据出来
				List<FxSdCarriageOrder> orderList = orderService.selectAllOrderByPage(status, userIdLong, currentPage, pageSize);
				orderQuery(result, userId, orderDtoList, orderList);
			} else {
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
				result.setData(orderDtoList);
			}
		} catch (Exception e) {
			logger.error("getOrderInfo error:{}", e.getMessage());
			result.setMessage(EWarning.Unknown.getName() + e.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}




	private void orderQuery(RespBaseDto<List<OrderDto>> result, Integer userId, List<OrderDto> orderDtoList, List<FxSdCarriageOrder> orderList) {
		if (orderList != null) {
			for (FxSdCarriageOrder orders :
					orderList) {
				if(orders.getStatus()!=(byte)9){
					OrderDto orderDto = new OrderDto();
					addOrderSn(userId, orderDto, orders);
					orderDtoList.add(orderDto);
				}
			}
			result.setData(orderDtoList);
			result.setMessage("ok");
			result.setState(200);
		} else {
			result.setMessage(EWarning.NoOrderInfo.getName());
			result.setState(EWarning.NoOrderInfo.getValue());
			result.setData(orderDtoList);
		}
	}

	@ApiOperation(value = "获取骑手信息", httpMethod = "POST")
	@PostMapping(value = "/getDeliveryInfo", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto<DeliveryAsUserDto> getDeliveryInfo(
			@RequestBody DeliveryGetInfoVo deliveryGetInfoVo
	) {
		RespBaseDto<DeliveryAsUserDto> result = new RespBaseDto<>();
		Integer deliveryId = deliveryGetInfoVo.getDeliveryId();
		DeliveryAsUserDto dto = new DeliveryAsUserDto();
		try {
			//查询是否有这个骑手
			FxSdUserDeliverinfo delivery = superDeliveryService.selectUserBysuperDeliveryId(deliveryId + "");
			if(delivery!=null){
				//服务分数
				FxSdSysLevelsetting deliveryService = levelService.selectByDliveryId(deliveryId);
				//骑手经纬度
				FxSdUserDeliverAdditional additional = superDeliveryOrderService.selectDeliveryInfo(deliveryId);
				if(deliveryService!=null && additional!=null){
					//服务次数
					int i = orderService.selectOrderCountByDeliveryId(deliveryId);
					additional.setLng(additional.getLng());
					additional.setLat(additional.getLat());
					superDeliveryOrderService.updateDeliveryAdditionalIsWork(additional);
					dto.setLat(Double.parseDouble(additional.getLat()));
					dto.setLng(Double.parseDouble(additional.getLng()));
					dto.setDeliveryId(deliveryId);
					dto.setDeliveryAvatarUrl(delivery.getAvatar());
					dto.setDeliveryIdNickName(delivery.getRealname());
					dto.setServiceNumber(i);
					dto.setServiceScore(deliveryService.getServiceScore());

					result.setState(200);
					result.setMessage("ok");
					result.setData(dto);
				}else{
					result.setMessage(EWarning.NoDeliveryServiceScore.getName());
					result.setState(EWarning.NoDeliveryServiceScore.getValue());
					result.setData(dto);
				}
			}else{
				result.setMessage(EWarning.NonExistent.getName());
				result.setState(EWarning.NonExistent.getValue());
				result.setData(dto);
			}
		} catch (Exception e) {
			logger.error("getDeliveryInfo error:{}", e.getMessage());
			result.setMessage(EWarning.Unknown.getName() + e.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}


	@ApiOperation(value = "获取用户待收货订单", httpMethod = "POST")
	@PostMapping(value = "/getReadyCollectGoodsOrder", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto<List<OrderDto>> getReadyCollectGoodsOrder(
			@RequestBody OrderPageVo OrderPageVo
	) {
		RespBaseDto<List<OrderDto>> result = new RespBaseDto<>();
		Integer currentPage = OrderPageVo.getCurrentPage();
		Integer pageSize = OrderPageVo.getPageSize();
		Integer userId = OrderPageVo.getUserId();
		List<OrderDto> orderDtoList = new ArrayList<>();
		try {
			if (currentPage != null && userId != null && pageSize != null
					) {
				long userIdLong = userId.longValue();
				Byte status = 4;
				//通过页数查询多少条数据出来
				List<FxSdCarriageOrder> orderList = orderService.selectOrderByPage(status, userIdLong, currentPage, pageSize);
				orderQuery(result, userId, orderDtoList, orderList);
			} else {
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
				result.setData(orderDtoList);
			}
		} catch (Exception e) {
			logger.error("getOrderInfo error:{}", e.getMessage());
			result.setMessage(EWarning.Unknown.getName() + e.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	@ApiOperation(value = "获取用户待支付订单", httpMethod = "POST")
	@PostMapping(value = "/getReadyPayOrderInfo", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto<List<OrderDto>> getReadyPayOrderInfo(
			@RequestBody OrderPageVo OrderPageVo
	) {
		RespBaseDto<List<OrderDto>> result = new RespBaseDto<>();
		Integer currentPage = OrderPageVo.getCurrentPage();
		Integer pageSize = OrderPageVo.getPageSize();
		Integer userId = OrderPageVo.getUserId();
		List<OrderDto> orderDtoList = new ArrayList<>();
		try {
			if (currentPage != null && userId != null && pageSize != null
					) {
				long userIdLong = userId.longValue();
				Byte status = 1;
				//通过页数查询多少条数据出来
				List<FxSdCarriageOrder> orderList = orderService.selectOrderByPage(status, userIdLong, currentPage, pageSize);
				if (orderList != null) {
					for (FxSdCarriageOrder orders : orderList) {

						OrderDto orderDto = new OrderDto();
						orderDto.setOrderId(orders.getId().intValue());
						orderDto.setOrderSn(Long.parseLong(orders.getOrdersn()));
						orderDto.setUserId(userId);
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
						orderDto.setMileages( orders.getMileages());
						orderDto.setWeight(Integer.parseInt(orders.getWeight() + ""));
						orderDto.setRemark(orders.getRemark());
						orderDto.setAreaCode(orders.getAreaCode());
						orderDto.setSourceType((int) orders.getSourceType());
						orderDto.setOrderType((int) orders.getOrderType());
						Integer createTime = orders.getCreateTime();
						String formats = "yyyy-MM-dd HH:mm:ss";
						Long timestamp = Long.parseLong(createTime+"") * 1000;
						String date = new SimpleDateFormat(formats, Locale.CHINA).format(new Date(timestamp));
						orderDto.setCreateTime(date);
						orderDto.setStatus((int) orders.getStatus());
						orderDto.setTotalCount(orders.getDispatchPrice());
						orderDto.setGoodsType(orders.getGoodsType());
						orderDto.setGoodsRemark(orders.getGoodsRemark());
						orderDtoList.add(orderDto);

					}
					result.setData(orderDtoList);
					result.setMessage("ok");
					result.setState(200);
				} else {
					result.setMessage(EWarning.NoOrderInfo.getName());
					result.setState(EWarning.NoOrderInfo.getValue());
					result.setData(orderDtoList);
				}
			} else {
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
				result.setData(orderDtoList);
			}
		} catch (Exception e) {
			logger.error("getReadyPayOrderInfo error:{}", e.getMessage());
			result.setMessage(EWarning.Unknown.getName() + e.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	@ApiOperation(value = "获取订单详情(订单id)", httpMethod = "POST")
	@PostMapping(value = "/getOrderDetails", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto<OrderDto> getOrderDetails(
			@RequestBody OrderIdVo orderIdVo
	) {
		RespBaseDto<OrderDto> result = new RespBaseDto<>();

		Integer orderId = orderIdVo.getOrderId();
		OrderDto orderDto = new OrderDto();
		try {
			if (orderId != null
					) {
				FxSdCarriageOrder order = orderService.selectOrderByOrderId(orderId);
				if (order != null) {
					addOrderSn(order.getMemberId().intValue(), orderDto, order);
					result.setData(orderDto);
					result.setMessage("ok");
					result.setState(200);
				} else {
					result.setMessage(EWarning.NoOrderInfo.getName());
					result.setState(EWarning.NoOrderInfo.getValue());
					result.setData(orderDto);
				}
			} else {
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
				result.setData(orderDto);
			}
		} catch (Exception e) {
			logger.error("getOrderInfo error:{}", e.getMessage());
			result.setMessage(EWarning.Unknown.getName() + e.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}


	@ApiOperation(value = "取消订单", httpMethod = "POST")
	@PostMapping(value = "/cancelOrder", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto<OrderStatusDto> cancelOrder(
			@RequestBody OrderIdVo orderIdVo
	) {
		RespBaseDto<OrderStatusDto> result = new RespBaseDto<>();
		Integer orderId = orderIdVo.getOrderId();
		OrderStatusDto orderStatusDto = new OrderStatusDto();
		try {
			if (orderId != null
					) {
				FxSdCarriageOrder order = orderService.selectOrderByOrderId(orderId);
				if(order!=null){
						//待支付
						if(order.getStatus()==1){
							order.setStatus((byte) 9);
							orderService.updateOrder(order);
							orderStatusDto.setUserId(order.getMemberId().intValue());
							orderStatusDto.setOrderSn(Long.parseLong(order.getOrdersn()));
							orderStatusDto.setOrderId(order.getId().intValue());
							orderStatusDto.setStatus(order.getStatus());
							result.setData(orderStatusDto);
							result.setMessage("ok");
							result.setState(200);
						//待抢单
						}else if(order.getStatus()==2){
							alipayRefundRequest(order.getOrdersn(),order.getTransId(),order.getDispatchPrice().doubleValue());
							logger.info("用户id为:" + order.getMemberId() + ",订单已取消,取消金额为:" + order.getDispatchPrice().doubleValue()
									+ ",订单号:" + order.getOrdersn() + ",支付宝支付流水号:" + order.getTransId() + ",支付状态:" + order.getStatus() + ",支付宝退款成功,");
							order.setStatus((byte)9);
							orderService.updateOrder(order);
							orderStatusDto.setUserId(order.getMemberId().intValue());
							orderStatusDto.setOrderSn(Long.parseLong(order.getOrdersn()));
							orderStatusDto.setOrderId(order.getId().intValue());
							orderStatusDto.setStatus(order.getStatus());
							result.setData(orderStatusDto);
							result.setMessage("ok");
							result.setState(200);
						}else{
							result.setMessage(EWarning.Order_ErrorStatus.getName());
							result.setState(EWarning.Order_ErrorStatus.getValue());
							result.setData(orderStatusDto);
						}
				}else{
					result.setMessage(EWarning.Order_ErrorStatus.getName());
					result.setState(EWarning.Order_ErrorStatus.getValue());
					result.setData(orderStatusDto);
				}
			} else {
				result.setMessage(EWarning.NonExistent.getName());
				result.setState(EWarning.NonExistent.getValue());
				result.setData(orderStatusDto);
			}

		} catch (Exception e) {
			logger.error("cancelOrder error:{}", e.getMessage());
			result.setMessage(EWarning.Unknown.getName() + e.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	private void addOrderSn(Integer userId, OrderDto orderDto, FxSdCarriageOrder orders) {
		orderDto.setOrderId(orders.getId().intValue());
		orderDto.setOrderSn(Long.parseLong(orders.getOrdersn()));
		orderDto.setUserId(userId);
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
		orderDto.setMileages( orders.getMileages());
		orderDto.setWeight(Integer.parseInt(orders.getWeight() + ""));
		orderDto.setRemark(orders.getRemark());
		orderDto.setAreaCode(orders.getAreaCode());
		orderDto.setSourceType((int) orders.getSourceType());
		orderDto.setOrderType((int) orders.getOrderType());
		Integer createTime = orders.getCreateTime();
		String formats = "yyyy-MM-dd HH:mm:ss";
		Long timestamp = Long.parseLong(createTime+"") * 1000;
		String date = new SimpleDateFormat(formats, Locale.CHINA).format(new Date(timestamp));
		orderDto.setCreateTime(date);
		orderDto.setStatus((int) orders.getStatus());
		orderDto.setTotalCount(orders.getDispatchPrice());
		orderDto.setGoodsType(orders.getGoodsType());
		orderDto.setGoodsRemark(orders.getGoodsRemark());
		if(orders.getDeliverId()!=null){
			orderDto.setDeliveryId(orders.getDeliverId().intValue());
		}else{
			orderDto.setDeliveryId(null);
		}
	}

	@ApiOperation(value = "获取用户待抢单订单", httpMethod = "POST")

	@PostMapping(value = "/getReadyRobOrderInfo", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto<List<OrderDto>> getReadyRobOrderInfo(
			@RequestBody OrderPageVo OrderPageVo
	) {
		RespBaseDto<List<OrderDto>> result = new RespBaseDto<>();
		Integer currentPage = OrderPageVo.getCurrentPage();
		Integer pageSize = OrderPageVo.getPageSize();
		Integer userId = OrderPageVo.getUserId();
		List<OrderDto> orderDtoList = new ArrayList<>();
		try {
			if (currentPage != null && userId != null && pageSize != null
					) {
				long userIdLong = userId.longValue();
				Byte status = 2;
				//通过页数查询多少条数据出来
				List<FxSdCarriageOrder> orderList = orderService.selectOrderByPage(status, userIdLong, currentPage, pageSize);
				if (orderList != null) {
					for (FxSdCarriageOrder orders : orderList) {
						OrderDto orderDto = new OrderDto();
						if (orders.getStatus() == 2) {
							orderDto.setOrderSn(Long.parseLong(orders.getOrdersn()));
							addOrderSn(userId, orderDto, orders);
							orderDtoList.add(orderDto);
						}
					}
					result.setData(orderDtoList);
					result.setMessage("ok");
					result.setState(200);
				} else {
					result.setMessage(EWarning.NoOrderInfo.getName());
					result.setState(EWarning.NoOrderInfo.getValue());
					result.setData(orderDtoList);
				}
			} else {
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
				result.setData(orderDtoList);
			}
		} catch (Exception e) {
			logger.error("getOrderInfo error:{}", e.getMessage());
			result.setMessage(EWarning.Unknown.getName() + e.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	@ApiOperation(value = "获取用户进行中订单", httpMethod = "POST")
	@PostMapping(value = "/getOnGoingOrderInfo", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto<List<OrderDto>> getOnGoingOrderInfo(
			@RequestBody OrderPageVo OrderPageVo
	) {
		RespBaseDto<List<OrderDto>> result = new RespBaseDto<>();
		Integer currentPage = OrderPageVo.getCurrentPage();
		Integer pageSize = OrderPageVo.getPageSize();
		Integer userId = OrderPageVo.getUserId();
		List<OrderDto> orderDtoList = new ArrayList<>();
		try {
			if (currentPage != null && userId != null && pageSize != null
					) {
				long userIdLong = userId.longValue();

				//通过页数查询多少条数据出来
				List<FxSdCarriageOrder> orderList = orderService.selectOrderPageByUser(userIdLong, currentPage, pageSize);
				if (orderList != null) {
					for (FxSdCarriageOrder orders : orderList) {
						OrderDto orderDto = new OrderDto();
						if (orders.getStatus() ==(byte) 3||orders.getStatus() ==(byte) 4) {
							addOrderSn(userId, orderDto, orders);
							orderDtoList.add(orderDto);
						}
					}
					result.setData(orderDtoList);
					result.setMessage("ok");
					result.setState(200);
				} else {
					result.setMessage(EWarning.NoOrderInfo.getName());
					result.setState(EWarning.NoOrderInfo.getValue());
					result.setData(orderDtoList);
				}
			} else {
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
				result.setData(orderDtoList);
			}
		} catch (Exception e) {
			logger.error("getOrderInfo error:{}", e.getMessage());
			result.setMessage(EWarning.Unknown.getName() + e.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	@ApiOperation(value = "获取用户订单中的运费", httpMethod = "POST")
	@PostMapping(value = "/getDispatchPrice", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto<FreightDto> getDispatchPrice(
			@RequestBody OrderDispatchVo orderDispatchVo
	) {
		RespBaseDto<FreightDto> result = new RespBaseDto<>();
		Double startLat = orderDispatchVo.getStartLat();
		Double startLng = orderDispatchVo.getStartLng();
		Double endLat = orderDispatchVo.getEndLat();
		Double endLng = orderDispatchVo.getEndLng();
		Integer weight = orderDispatchVo.getWeight();
		Integer areaCode = orderDispatchVo.getAreaCode();
		Integer tipPrice = orderDispatchVo.getTipPrice();
		FreightDto freightDto = new FreightDto();
		try {
			if (startLat != null && startLng != null && endLat != null &&
					endLng != null && weight != null && areaCode != null && tipPrice!=null
				) {
				//价格组成存储到map集合中
				Map<String, BigDecimal> map = new HashMap<>();
				//初始总价格
				Integer SumBigDecimal = 0;
				//获取代理商
				FxSdSysCarriageDispatch fxSdSysCarriageDispatch = userCarriageDispatchService.selectDispatchByAreaId(areaCode + "");
				if (fxSdSysCarriageDispatch != null) {
					//默认重量8kg(默认单位kg)
					//int defaultWeight = 8;
					int defaultWeight = fxSdSysCarriageDispatch.getInitialWeight();
					//默认公里数(公里为单位)
					Byte baseMileage = fxSdSysCarriageDispatch.getBaseMileage();
					//基础运费(默认公里数内)
					BigDecimal basePrice = fxSdSysCarriageDispatch.getBasePrice();
					//正常营业时间起点
					int beginTime = fxSdSysCarriageDispatch.getBeginTime();
					//正常营业时间结束点
					int endTime = fxSdSysCarriageDispatch.getEndTime();
					//夜间加价
					BigDecimal nightMarkup = fxSdSysCarriageDispatch.getNightMarkup();
					//公里加价(每公里加价)
					BigDecimal mileageMarkup = fxSdSysCarriageDispatch.getMileageMarkup();
					//特殊加价(如雨天等)
					BigDecimal specialMarkup = fxSdSysCarriageDispatch.getSpecialMarkup();
					//重量加价(每公斤加价)
					BigDecimal weightMarkup = fxSdSysCarriageDispatch.getWeightMarkup();
					//时间是否在营业内
					boolean inDate = TimeBetween.isInDate(new Date(), beginTime + ":00:00", endTime + ":00:00");
					if (inDate) {
						//基础价格
						SumBigDecimal += basePrice.intValue();
						SumBigDecimal += tipPrice;
						map.put("tipPrice",new BigDecimal(tipPrice));
						map.put("basicPrice", basePrice);
						//营业时间不加价
						map.put("nightPrice", new BigDecimal(0));
						SumBigDecimal = getWeight(startLat + "", startLng + "", endLat + "", endLng + "", weight + "", map, SumBigDecimal, defaultWeight, baseMileage, mileageMarkup, weightMarkup);
					} else {
						//基础价格
						SumBigDecimal += tipPrice;
						map.put("tipPrice",new BigDecimal(tipPrice));
						SumBigDecimal += basePrice.intValue();
						map.put("basicPrice", basePrice);
						//夜间加价
						SumBigDecimal += nightMarkup.intValue();
						map.put("nightPrice", nightMarkup);
						SumBigDecimal = getWeight(startLat + "", startLng + "", endLat + "", endLng + "", weight + "", map, SumBigDecimal, defaultWeight, baseMileage, mileageMarkup, weightMarkup);
					}
					if (specialMarkup != null) {
						SumBigDecimal += specialMarkup.intValue();
						map.put("specialPrice", specialMarkup);
					}
					freightDto.setSumBigDecimal(SumBigDecimal);
					freightDto.setMap(map);
					result.setData(freightDto);
					result.setMessage("ok");
					result.setState(200);
				} else {
					result.setMessage("无代理商信息");
					result.setState(1201);
				}
			} else {
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
			}
		} catch (Exception ex) {
			logger.error("getDispatchPrice error:{}", ex.getMessage());
			result.setMessage(EWarning.Unknown.getName() + ex.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	@ApiOperation(value = "用户评价骑手",httpMethod = "POST")
	@PostMapping(value = "/userEvaluateDelivery",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto<DeliveryScoreDto> userEvaluateDelivery(
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
			Integer deliveryId = EvaluateVo.getDeliveryId();
			if(orderId!=null&&starLevel!=null&&evaluateType!=null&&remake!=null&&userId!=null&&deliveryId!=null){
				//写用户评分
				FxSdUserDeliverinfo delivery = superDeliveryService.selectUserBysuperDeliveryId(deliveryId + "");
				FxSdCarriageOrder fxSdCarriageOrder = orderService.selectOrderByOrderId(orderId);
				int i = orderService.selectOrderCountByDeliveryId(deliveryId);
				if(delivery!=null && i!=-1){
					//写等级表
					FxSdSysLevelsetting levelsetting = levelService.selectByDliveryId(deliveryId);
					if(levelsetting!=null){
						int totalStar = levelsetting.getTotalStarScore() + starLevel;
						if(totalStar<100){
							levelsetting.setLevelName("白板");
						}
						if(totalStar>100&&totalStar<1000){
							levelsetting.setLevelName("黑铁");
						}
						if(totalStar>1000&&totalStar<10000){
							levelsetting.setLevelName("白银");
						}
						if(totalStar>10000&&totalStar<50000){
							levelsetting.setLevelName("黄金");
						}
						if(totalStar>50000&&totalStar<200000){
							levelsetting.setLevelName("钻石");
						}
						if(totalStar>200000){
							levelsetting.setLevelName("皇冠");
						}
						Integer levelScore = levelsetting.getLevelScore();
						if(starLevel<6){
							levelScore = levelsetting.getLevelScore() - 1;
							if(levelScore<60){
								//修改骑手的状态为禁用
								delivery.setStates((byte)2);
								superDeliveryService.updateSuperDelivery(delivery,delivery.getId());
							}
						}
						double a = new BigDecimal(totalStar / i/2).setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();
						levelsetting.setServiceScore(a);
						levelsetting.setTotalStarScore(totalStar);
						levelsetting.setDeliveryId(deliveryId);
						levelsetting.setLevelScore(levelScore);
						levelService.updateLevel(levelsetting);
					}else{
						FxSdSysLevelsetting levelset = new FxSdSysLevelsetting();
						levelset.setDeliveryId(deliveryId);
						levelset.setLevelScore(80);
						levelset.setTotalStarScore(starLevel);
						levelset.setLevelName("白板");
						levelset.setServiceScore(5.0);
						levelService.insertInto(levelset);
					}
					//写订单中
					if(fxSdCarriageOrder!=null){
						fxSdCarriageOrder.setDeliverAppraise((byte)1);
						fxSdCarriageOrder.setDeliverAppraiseDesc(remake);
						fxSdCarriageOrder.setDeliverAppraiseScore(starLevel.byteValue());
						fxSdCarriageOrder.setDeliveryAppraiseType(evaluateType);
						orderService.updateOrder(fxSdCarriageOrder);
						dto.setDeliveryId(deliveryId);
						dto.setDeliveryRaiseType(evaluateType.byteValue());
						dto.setLevelScore(delivery.getLevelSocre());
						dto.setOrderCount(i);
						dto.setOrderId(orderId);
						dto.setServiceScore(delivery.getServiceScore());
						dto.setStarLevel(starLevel);
						dto.setUserId(fxSdCarriageOrder.getMemberId().intValue());
						result.setData(dto);
						result.setState(200);
						result.setMessage("ok");
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
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
				result.setData(dto);
			}

		}catch(Exception ex){
			logger.error("userEvaluateDelivery error:{}", ex.getMessage());
			result.setMessage(EWarning.Unknown.getName() + ex.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}


	private int getWeight(@RequestParam(value = "startLat", defaultValue = "0") String startLat,
						  @RequestParam(value = "startLng", defaultValue = "0") String startLng,
						  String endLat, String endLng, String weight,
						  Map<String, BigDecimal> map, Integer sumBigDecimal,
						  int defaultWeight, Byte baseMileage, BigDecimal mileageMarkup, BigDecimal weightMarkup) {
		//判断重量
		if (Integer.parseInt(weight) <= defaultWeight) {
			//不加价
			map.put("weightPrice", new BigDecimal(0));
			sumBigDecimal = getDistancePrices(startLat, startLng, endLat, endLng, map, sumBigDecimal, baseMileage, mileageMarkup);
			return sumBigDecimal;
		} else {
			//重量加价
			BigDecimal weightPrice = new BigDecimal(weight).subtract(new BigDecimal(defaultWeight)).multiply(weightMarkup);
			map.put("weightPrice", weightPrice);
			sumBigDecimal += weightPrice.intValue();
			sumBigDecimal = getDistancePrices(startLat, startLng, endLat, endLng, map, sumBigDecimal, baseMileage, mileageMarkup);
			return sumBigDecimal;
		}
	}

	private int getDistancePrices(@RequestParam(value = "startLat", defaultValue = "0") String startLat,
								  @RequestParam(value = "startLng", defaultValue = "0") String startLng,
								  String endLat, String endLng, Map<String, BigDecimal> map,
								  Integer sumBigDecimal, Byte baseMileage, BigDecimal mileageMarkup) {
		//判断距离
		if (Double.parseDouble(startLat) == 0 || Double.parseDouble(startLng) == 0) {
			//帮我买却不知道目的地的情况下(只有终点)
			map.put("distancePrice", new BigDecimal(0));
			map.put("mileages", new BigDecimal(3));
			return sumBigDecimal;
		} else {
			double distance = Double.valueOf(MapDistance.getDistance(startLat, startLng, endLat, endLng));
			double v = baseMileage.doubleValue();
			if (v >= distance) {
				//不加价
				map.put("distancePrice", new BigDecimal(0));
				map.put("mileages", new BigDecimal(distance).setScale(2,BigDecimal.ROUND_HALF_UP));
				return sumBigDecimal;
			} else {
				long round = Math.round(distance - v);
				BigDecimal distancePrice = new BigDecimal(round).multiply(mileageMarkup);
				sumBigDecimal += distancePrice.intValue();
				map.put("distancePrice", distancePrice);
				map.put("mileages", new BigDecimal(distance).setScale(2,BigDecimal.ROUND_HALF_UP));
				return sumBigDecimal;
			}
		}
	}


	/**  支付宝退款接口
	 * @param out_trade_no 订单支付时传入的商户订单号,不能和支付宝交易号（trade_no）同时为空。
	 * @param trade_no 支付宝交易号
	 * @param refund_amount 需要退款的金额，该金额不能大于订单金额,单位为元，支持两位小数
	 * @return 将提示信息返回
	 */
	public  synchronized  String alipayRefundRequest(String out_trade_no,String trade_no,double refund_amount) {
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
				System.out.println("支付宝退款成功");
				FxSdCarriageOrder order = orderService.selectOrderByOrderSn(Long.parseLong(out_trade_no));
				if(order!=null&& order.getStatus() ==7){
					System.out.println("look me");
					order.setStatus((byte)9);
					orderService.updateOrder(order);
				}
				returnStr = "支付宝退款成功";
			} else {
				returnStr = response.getSubMsg();//失败会返回错误信息
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnStr;
	}
	private String encode(String sign) throws UnsupportedEncodingException {
		return URLEncoder.encode(sign, "utf-8").replace("+", "%20");
	}
}
