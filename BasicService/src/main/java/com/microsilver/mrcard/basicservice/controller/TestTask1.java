package com.microsilver.mrcard.basicservice.controller;

import com.microsilver.mrcard.basicservice.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class TestTask1  {
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private OrderService orderService;
	private int count=0;
	//每隔60分钟
	//@Scheduled(cron="0 */60 * * * ?")
	@Scheduled(cron="* */60 * * * ?")
	private void process() {
		System.out.println("[" + Thread.currentThread().getName() + "]" + "this is scheduler task runing  " + (count++));
//		List<FxSdCarriageOrder> list = orderService.selectAllOrder();
//		if (list != null) {
//			for (FxSdCarriageOrder order : list) {
//				Byte payType = order.getPayType();
//				if (payType!=null && payType == 22) {
//					order.setStatus((byte)9);
//					orderService.updateOrder(order);
//					//返回金额到用户账户中(目前仅支持支付宝)
//					String s = AlipayRefundUtil.alipayRefundRequest(order.getOrdersn(), order.getTransId(), order.getDispatchPrice().doubleValue());
//					logger.info("用户id为:" + order.getMemberId() + ",订单已取消,取消金额为:" + order.getDispatchPrice().doubleValue()
//							+ ",订单号:" + order.getOrdersn() + ",支付宝支付流水号:" + order.getTransId() + ",支付状态:" + order.getStatus() + ",支付宝退款成功,");
//					logger.info("支付宝回调信息:"+s);
//				}
//			}
//		}
	}


}
