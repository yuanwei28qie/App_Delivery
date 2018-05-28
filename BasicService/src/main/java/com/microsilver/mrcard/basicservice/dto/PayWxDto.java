package com.microsilver.mrcard.basicservice.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Map;

@Data
@ApiModel
public class PayWxDto {
	@ApiModelProperty(value = "out_trade_no(订单号);total_fee(订单金额);return_Code(返回状态码);return_msg(返回状态对应信息)")
	private Map<String,Object> map;

}
