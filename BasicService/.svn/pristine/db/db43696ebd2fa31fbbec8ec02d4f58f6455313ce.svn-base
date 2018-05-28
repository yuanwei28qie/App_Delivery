package com.microsilver.mrcard.basicservice.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.microsilver.mrcard.basicservice.dto.RespBaseDto;
import com.microsilver.mrcard.mq.PushMsg;

/**
 * 
 * @Name com.microsilver.mrcard.serviceplatform.service.IFinanceRemoteSmpl
 * @Description 
 * 
 * @Author bruce
 * @Version 2017年7月26日 下午7:43:12
 * @Copyright Micro Silver
 *
 */
@FeignClient(value = "API-SERVICE")
public interface IFinanceRemoteSmpl {
	/*@RequestMapping(value = "/api/Common/sendCheckCode", method = RequestMethod.POST)
	public RespBaseDto<Object> getCheckCode(@RequestParam(value="apptype") String apptype,
			   @RequestParam(value="mobile") String mobile,
			   @RequestParam(value="type") int type);*/
	@RequestMapping(value = "/api/Common/getCheckCode", method = RequestMethod.POST)
	public RespBaseDto<Object> getCheckCode(
			   @RequestParam(value="mobile") String mobile,
			   @RequestParam(value="type") int type);
	@RequestMapping(value = "/api/Common/sendCheckCode", method = RequestMethod.POST)
	public RespBaseDto<Object> sendCheckCode(
			   @RequestParam(value="apptype") String apptype,
			   @RequestParam(value="mobile") String mobile,
			   @RequestParam(value="type") int type);
	
	@RequestMapping(value = "/api/Common/validateCheckCode", method = RequestMethod.POST)
	public RespBaseDto<String> validateCheckCode(@RequestParam(value="mobile")String mobile,
			@RequestParam(value="type")int type,
			@RequestParam(value="checkCode")String checkCode);
	
}
