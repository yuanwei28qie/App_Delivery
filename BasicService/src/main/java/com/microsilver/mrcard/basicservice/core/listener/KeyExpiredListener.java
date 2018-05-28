package com.microsilver.mrcard.basicservice.core.listener;

import com.microsilver.mrcard.basicservice.model.FxSdCarriageOrder;
import com.microsilver.mrcard.basicservice.service.OrderService;
import com.microsilver.mrcard.basicservice.utils.SpringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import redis.clients.jedis.JedisPubSub;


public class KeyExpiredListener extends JedisPubSub {
	protected final Logger logger = LoggerFactory.getLogger(getClass());




	@Override
	public void onPSubscribe(String pattern, int subscribedChannels) {
		System.out.println("onPSubscribe "
				+ pattern + " " + subscribedChannels);
	}

	@Override
	public void onPMessage(String pattern, String channel, String message) {
		//FxSdCarriageOrder order = new OrderService().selectOrderByOrderSn(Long.parseLong(message));
		//结束后就调用改监听器的方法
		System.out.println("onPMessage pattern "
				+ pattern + " " + channel + " " + message);

		ApplicationContext applicationContext=SpringUtils.getApplicationContext();
		OrderService orderService = applicationContext.getBean(OrderService.class);
		FxSdCarriageOrder order = orderService.selectOrderByOrderSn(Long.parseLong(message));
		if(order!=null){
			if(order.getStatus()==1){
				System.out.println("11111111111");
				order.setStatus((byte)9);
				//new OrderService().updateOrder(order);
				orderService.updateOrder(order);
			}
			//logger.info("订单id:"+dto.getData().getOrderId()+",订单状态为:"+dto.getData().getStatus()+",返回信息:"+dto.getMessage()+"返回状态码:"+dto.getState());
		}else{
			logger.error("监听器返回无订单信息");
		}

	}
}
