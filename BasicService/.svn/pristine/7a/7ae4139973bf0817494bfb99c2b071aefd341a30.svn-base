package com.microsilver.mrcard.basicservice.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.microsilver.mrcard.basicservice.utils.JuheMsg;

@Component
@RabbitListener(queues = "basicmsgQueue")
public class ReceiverMQ {
	
	
    @RabbitHandler
    public void  process(String msg) {
    	
        
        String[] split = msg.split("-");
        
        String mobile = split[0];
        System.out.println("需要发送的电话号码:"+mobile);
        String substring = mobile.substring(1, mobile.length());
        System.out.println(substring);
        String checkCode = split[1];
        System.out.println("需要发送的验证码:"+checkCode);
       
        JuheMsg.sendMsg(substring, checkCode);
        
    }

}
