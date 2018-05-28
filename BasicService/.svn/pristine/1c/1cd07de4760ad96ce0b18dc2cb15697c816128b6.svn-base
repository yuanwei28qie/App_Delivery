package com.microsilver.mrcard.basicservice.mq;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.microsilver.mrcard.basicservice.mq.AmqpConfig.RouteConfig;
import com.microsilver.mrcard.mq.PushMsg;

@Component
@Lazy(false)
public class MQSendMsgHelper {

    @Autowired
    private AmqpConfig amqpConfig;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 构造方法注入
     */
    @Autowired
    public MQSendMsgHelper(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJSONMsg(String msg) {
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        RouteConfig route = this.amqpConfig.getRouteConfig("basicmsgHandle");
        this.rabbitTemplate.convertAndSend(route.exchange, route.routingkey, JSON.toJSONString(msg), correlationId);
    }
    
    public void sendJSONMsg(PushMsg pushmsg) {
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        RouteConfig route = this.amqpConfig.getRouteConfig("basicmsgHandle");
        this.rabbitTemplate.convertAndSend(route.exchange, route.routingkey, JSON.toJSONString(pushmsg), correlationId);
    }
   
       

  

   
}
