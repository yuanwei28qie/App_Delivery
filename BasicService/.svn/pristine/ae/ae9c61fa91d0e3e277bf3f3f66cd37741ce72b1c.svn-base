/**
 * 
 */
package com.microsilver.mrcard.basicservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.microsilver.mrcard.basicservice.dto.RespBaseDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import com.microsilver.mrcard.basicservice.service.SuperDeliveryOrderService;
/**
 * 
 * @Name com.microsilver.mrcard.basicservice.controller.SuperDeliveryOrderController
 * @Description 
 * 
 * @Author huwei
 * @Version 2018年3月28日 下午3:12:31
 * @Copyright  Micro Silver-SuperDelivery
 *
 */
@Api(value = "/api/SuperDeliveryOrderController", description = "骑手功能API")
@Controller
@RequestMapping(value = "/api/SuperDeliveryOrderController")
public class SuperDeliveryOrderController {
	
	@Autowired
	private SuperDeliveryOrderService superDeliveryOrderService;
	
	@RequestMapping("/isWork")
	@ApiOperation(value = "休息/开工", httpMethod = "POST")
	@ApiImplicitParams({ @ApiImplicitParam(name = "superDeliveryId", value = "用户id"),
			@ApiImplicitParam(name = "isWork", value = "true.开工 false.休息") })
	public RespBaseDto<String> isWork(
			Long superDeliveryId, 
			Boolean isWork) {
		RespBaseDto<String> result = new RespBaseDto<>();
		try {
			int r = superDeliveryOrderService.isWork(superDeliveryId, isWork);
			if (r == 1)
				result.setData("OK");
		}  catch (Exception e) {
			e.printStackTrace();
			result.setMessage("出现异常请联系官网技术人员");
			result.setState(1);
		}
		return result;
	}
}
